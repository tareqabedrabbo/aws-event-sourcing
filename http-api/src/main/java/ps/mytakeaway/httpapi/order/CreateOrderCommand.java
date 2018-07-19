package ps.mytakeaway.httpapi.order;

import org.immutables.value.Value;

import java.time.Instant;
import java.util.List;

@Value.Immutable
public interface CreateOrderCommand {

    default long processingTs() {
        return Instant.now().toEpochMilli();
    }

    long orderEventTs();

    String orderId();

    String userId();

    String deliveryAddress();

    List<String> items();
}
