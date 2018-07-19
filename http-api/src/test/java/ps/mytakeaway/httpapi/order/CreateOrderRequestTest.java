package ps.mytakeaway.httpapi.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@JsonTest
public class CreateOrderRequestTest {

    @Autowired
    private JacksonTester<CreateOrderRequest> json;

    @Test
    public void testDeserialise() throws Exception {
        String content = new String(Files
                .readAllBytes(Paths.get(new ClassPathResource("create-order-request.json").getURI())));
        CreateOrderRequest request = json.parseObject(content);

        assertThat(request.getUserId()).isEqualTo("user1");
        assertThat(request.getEventTs()).isEqualTo(1532016680348l);
        assertThat(request.getDeliveryAddress()).isEqualTo("some address");
        assertThat(request.getItems()).contains("item1", "item2");
    }


}