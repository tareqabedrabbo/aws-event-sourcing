package ps.takeaways.httpapi;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.kinesis.producer.KinesisProducer;
import com.amazonaws.services.kinesis.producer.KinesisProducerConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HttpApiApplication {

    @Value("${aws.kinesis.producer.recordMaxBufferedTime}")
    private int recordMaxBufferedTime;

    @Value("${aws.kinesis.producer.region}")
    private String kinesisRegion;

    @Value("${aws.kinesis.producer.maxConnections}")
    private int kinesisMaxConnections;

    @Value("${aws.kinesis.producer.requestTimeout}")
    private int kinesisRequestTimeout;

    @Value("${aws.kinesis.producer.inputStream}")
    private String kinesisInputStream;

    @Value("${aws.accessKey}")
    private String awsAccessKey;

    @Value("${aws.secretKey}")
    private String awsSecretKey;

    public static void main(String[] args) {
        SpringApplication.run(HttpApiApplication.class, args);
    }

    @Bean
    public KinesisProducer kinesisProducer() {
        final AWSStaticCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(new BasicAWSCredentials(
                awsAccessKey, awsSecretKey
        ));
        final KinesisProducerConfiguration config = new KinesisProducerConfiguration()
                .setRecordMaxBufferedTime(recordMaxBufferedTime)
                .setMaxConnections(kinesisMaxConnections)
                .setRequestTimeout(kinesisRequestTimeout)
                .setRegion(kinesisRegion)
                .setCredentialsProvider(credentialsProvider);

        return new KinesisProducer(config);
    }

}
