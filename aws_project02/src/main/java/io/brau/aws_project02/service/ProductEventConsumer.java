package io.brau.aws_project02.service;

import io.brau.aws_project02.model.Envelope;
import io.brau.aws_project02.model.ProductEvent;
import io.brau.aws_project02.model.ProductEventLog;
import io.brau.aws_project02.model.SnsMessage;
import io.brau.aws_project02.repository.ProductEventLogRepository;
import jakarta.jms.JMSException;
import jakarta.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.time.Duration;
import java.time.Instant;

@Service
public class ProductEventConsumer {
    private static final Logger log = LoggerFactory.getLogger(ProductEventConsumer.class.getName());

    private final JsonMapper jsonMapper;
    private final ProductEventLogRepository productEventLogRepository;

    @Autowired
    private ProductEventConsumer(JsonMapper jsonMapper, ProductEventLogRepository productEventLogRepository) {
        this.jsonMapper = jsonMapper;
        this.productEventLogRepository = productEventLogRepository;
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

        ProductEventLog productEventLog = buildProductEventLog(envelope, productEvent);
        productEventLogRepository.save(productEventLog);

    }

    private ProductEventLog buildProductEventLog(Envelope envelope, ProductEvent productEvent) {
        long timestamp = Instant.now().toEpochMilli();

        ProductEventLog productEventLog = new ProductEventLog();
        productEventLog.setPk(productEvent.getCode());
        productEventLog.setSk(envelope.getEventType() + "_" + timestamp);
        productEventLog.setEventType(envelope.getEventType());
        productEventLog.setProductId(productEvent.getProductId());
        productEventLog.setUsername(productEvent.getUserName());
        productEventLog.setTimestamp(timestamp);
        productEventLog.setTtl(Instant.now().plus(
                Duration.ofMinutes(10)).getEpochSecond()
        );

        return productEventLog;
    }
}
