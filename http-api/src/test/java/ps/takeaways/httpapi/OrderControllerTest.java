package ps.takeaways.httpapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void order() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"orderId\": \"order123\", \"orderTs\": 3148129084, \"deliveryAddress\": \"address\", \"orderDetails\": {}}")
        )
                .andExpect(status().isOk());
    }
}