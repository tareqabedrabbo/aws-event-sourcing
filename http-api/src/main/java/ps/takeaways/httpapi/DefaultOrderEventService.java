package ps.takeaways.httpapi;

import com.amazonaws.services.kinesis.producer.KinesisProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultOrderEventService implements OrderEventService {

    @Autowired
    private KinesisProducer kinesisProducer;

    @Override
    public void createEvent(OrderRequest orderRequest) {
        System.out.println(kinesisProducer);
    }
}
