package io.noah.flavorme.api.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chanwook on 2014. 8. 23..
 */
@RestController
public class HelloApi {
    @Autowired
    private HelloRepository r;

    @RequestMapping(value = "/hello/{msg}", method = RequestMethod.GET)
    public Message hello(@PathVariable("msg") String messageText) {
        Message message = new Message(messageText);
        r.hello(message);
        return message;
    }
}
