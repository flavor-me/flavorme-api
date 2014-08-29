package io.noah.flavorme.api.hello;

import java.io.Serializable;

/**
 * Created by chanwook on 2014. 8. 28..
 */
public class Message implements Serializable {

    private String id;

    private String message;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
