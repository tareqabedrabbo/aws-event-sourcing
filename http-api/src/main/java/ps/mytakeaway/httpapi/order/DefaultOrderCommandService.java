package ps.mytakeaway.httpapi.order;

import com.amazonaws.services.kinesis.producer.KinesisProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ps.mytakeaway.httpapi.AwsKinesisProducerConfig;

import java.io.IOException;
import java.nio.ByteBuffer;

@Service
public class DefaultOrderCommandService implements OrderCommandService {

    @Autowired
    private KinesisProducer kinesisProducer;

    @Autowired
    private AwsKinesisProducerConfig config;

    private final ObjectMapper objectMapper;

    public DefaultOrderCommandService() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public void createCommand(CreateOrderRequest createOrderRequest) throws IOException {
        CreateOrderCommand event = ImmutableCreateOrderCommand.builder()
                .orderId(createOrderRequest.getOrderId())
                .orderEventTs(createOrderRequest.getEventTs())
                .build();
        final byte[] bytes = objectMapper.writeValueAsBytes(event);
        kinesisProducer.addUserRecord(config.getCommandInputStream(), createOrderRequest.getOrderId(), ByteBuffer.wrap(bytes));
    }
}
