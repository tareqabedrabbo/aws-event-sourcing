package ps.mytakeaway.httpapi;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.kinesis.producer.KinesisProducer;
import com.amazonaws.services.kinesis.producer.KinesisProducerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(AwsKinesisProducerConfig.class)
public class HttpApiApplication {

    @Value("${aws.accessKey}")
    private String awsAccessKey;

    @Value("${aws.secretKey}")
    private String awsSecretKey;

    public static void main(String[] args) {
        SpringApplication.run(HttpApiApplication.class, args);
    }

    @Bean
    public KinesisProducer kinesisProducer(AwsKinesisProducerConfig awsKinesisProducerConfig) {
        final AWSStaticCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(new BasicAWSCredentials(
                awsAccessKey, awsSecretKey
        ));
        final KinesisProducerConfiguration config = new KinesisProducerConfiguration()
                .setRecordMaxBufferedTime(awsKinesisProducerConfig.getRecordMaxBufferedTime())
                .setMaxConnections(awsKinesisProducerConfig.getMaxConnections())
                .setRequestTimeout(awsKinesisProducerConfig.getRequestTimeout())
                .setRegion(awsKinesisProducerConfig.getRegion())
                .setCredentialsProvider(credentialsProvider);

        return new KinesisProducer(config);
    }

}
