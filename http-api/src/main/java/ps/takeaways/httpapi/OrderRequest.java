package ps.takeaways.httpapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Map;

public class OrderRequest {

    @JsonProperty(required = true)
    private String orderId;
    private long orderTs;
    private String deliveryAddress;
    private Map<String, Object> orderDetails;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getOrderTs() {
        return orderTs;
    }

    public void setOrderTs(long orderTs) {
        this.orderTs = orderTs;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Map<String, Object> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Map<String, Object> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "orderId='" + orderId + '\'' +
                ", orderTs=" + orderTs +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
