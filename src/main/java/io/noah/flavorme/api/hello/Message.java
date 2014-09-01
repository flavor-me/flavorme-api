package io.noah.flavorme.api.hello;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by chanwook on 2014. 8. 28..
 */
@Entity
@Document(collection = "helloMessage")
public class Message implements Serializable {

    @javax.persistence.Id
    @org.springframework.data.annotation.Id
    private String id;

    private String message;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public Message(String id, String message) {
        this.id = id;
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
