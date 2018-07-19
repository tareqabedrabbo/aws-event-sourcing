package ps.mytakeaway.httpapi.order;

import java.io.IOException;

public interface OrderCommandService {
    void createCommand(CreateOrderRequest createOrderRequest) throws IOException;
}
