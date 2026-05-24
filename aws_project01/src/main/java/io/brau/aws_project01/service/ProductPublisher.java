package io.brau.aws_project01.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.Topic;
import io.brau.aws_project01.enums.EventType;
import io.brau.aws_project01.model.Envelope;
import io.brau.aws_project01.model.Product;
import io.brau.aws_project01.model.ProductEvent;
import tools.jackson.databind.json.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductPublisher {
    private static final Logger LOG = LoggerFactory.getLogger(ProductPublisher.class);

    private final AmazonSNS snsClient;
    private final Topic productEventsTopic;
    private final JsonMapper jsonMapper;

    public ProductPublisher(AmazonSNS snsClient,
                            @Qualifier("productEventsTopic") Topic productEventsTopic,
                            JsonMapper jsonMapper) {
        this.snsClient = snsClient;
        this.productEventsTopic = productEventsTopic;
        this.jsonMapper = jsonMapper;
    }

    public void publishProductEvent(Product product, EventType eventType, String username) {
        ProductEvent productEvent = new ProductEvent();

        productEvent.setProductId(product.getId());
        productEvent.setCode(product.getCode());
        productEvent.setUserName(username);

        Envelope envelope = new Envelope();
        envelope.setEventType(eventType);

        try {
            envelope.setData(jsonMapper.writeValueAsString(productEvent));

            PublishResult publishResult = snsClient.publish(
                    productEventsTopic.getTopicArn(),
                    jsonMapper.writeValueAsString(envelope)
            );

            LOG.info("Product Event Sent - Event: {} - ProductId: {} - MessageId: {} ",
                    envelope.getEventType(),
                    productEvent.getProductId(),
                    publishResult.getMessageId());
        } catch (Exception e) {
            LOG.error("Failed do create product event message: {}", e.getMessage());
        }
    }
}
