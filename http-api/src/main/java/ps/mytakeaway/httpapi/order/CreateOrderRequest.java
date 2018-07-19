package ps.mytakeaway.httpapi.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CreateOrderRequest {

    @JsonProperty(required = true)
    private String orderId;

    private long eventTs;

    private String userId;

    private String deliveryAddress;

    private List<String> items;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getEventTs() {
        return eventTs;
    }

    public void setEventTs(long eventTs) {
        this.eventTs = eventTs;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CreateOrderRequest{" +
                "orderId='" + orderId + '\'' +
                ", eventTs=" + eventTs +
                ", userId='" + userId + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", items=" + items +
                '}';
    }
}
