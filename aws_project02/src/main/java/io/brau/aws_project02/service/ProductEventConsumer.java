package io.brau.aws_project02.service;

import io.brau.aws_project02.model.Envelope;
import io.brau.aws_project02.model.ProductEvent;
import io.brau.aws_project02.model.SnsMessage;
import jakarta.jms.JMSException;
import jakarta.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

@Service
public class ProductEventConsumer {
    private static final Logger log = LoggerFactory.getLogger(ProductEventConsumer.class.getName());

    private final JsonMapper jsonMapper;

    @Autowired
    private ProductEventConsumer(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @JmsListener(destination = "${aws.sqs.queue.product.events.name}")
    public void receiveProductEvent(TextMessage textMessage) throws JMSException {
        SnsMessage snsMessage = jsonMapper.readValue(textMessage.getText(), SnsMessage.class);
        Envelope envelope = jsonMapper.readValue(snsMessage.getMessage(), Envelope.class);
        ProductEvent productEvent = jsonMapper.readValue(envelope.getData(), ProductEvent.class);

        log.info("Product Event Received - Event: {} - ProductId: {} - MessageId: {}",
                envelope.getEventType(),
                productEvent.getProductId(),
                snsMessage.getMessageId());
    }
}
