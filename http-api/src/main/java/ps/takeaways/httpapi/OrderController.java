package ps.takeaways.httpapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> order(@RequestBody OrderRequest orderRequest) {
        ResponseEntity<Void> responseEntity = new ResponseEntity<Void>(HttpStatus.OK);
        System.out.println(orderRequest);
        return responseEntity;
    }
}
