package ps.mytakeaway.httpapi.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderCommandService orderCommandService;

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public ResponseEntity<Void> order(@PathVariable String orderId,
                                      @RequestBody CreateOrderRequest createOrderRequest) throws Exception {
        ResponseEntity<Void> responseEntity = new ResponseEntity<Void>(HttpStatus.OK);
        orderCommandService.createCommand(createOrderRequest);
        return responseEntity;
    }
}
