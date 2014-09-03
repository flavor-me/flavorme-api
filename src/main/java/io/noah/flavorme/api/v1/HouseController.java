package io.noah.flavorme.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chanwook on 2014. 9. 3..
 */
@Controller
@RequestMapping(value = "/v1")
public class HouseController {

    @RequestMapping(value = "/houses", method = RequestMethod.GET)
    public String list() {
        return "v1/houselist/houselist";
    }
}
