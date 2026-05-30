package io.brau.aws_project01.config.local;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import jakarta.jms.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.destination.DynamicDestinationResolver;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.net.URI;

@Configuration
@EnableJms
@Profile("local")
public class JmsConfigLocal {

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.endpoint:http://localhost:4566}")
    private String awsEndpoint;

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        SqsClient sqsClient = SqsClient.builder()
                .region(Region.of(awsRegion))
                .endpointOverride(URI.create(awsEndpoint))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("test", "test")))
                .build();

        SQSConnectionFactory sqsConnectionFactory = new SQSConnectionFactory(
                new ProviderConfiguration(),
                sqsClient);

        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(sqsConnectionFactory);
        factory.setDestinationResolver(new DynamicDestinationResolver());
        factory.setConcurrency("2");
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);

        return factory;
    }
}
