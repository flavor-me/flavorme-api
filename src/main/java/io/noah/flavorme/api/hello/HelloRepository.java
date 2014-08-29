package io.noah.flavorme.api.hello;

/**
 * Created by chanwook on 2014. 8. 28..
 */
public interface HelloRepository {
    void hello(Message message);

    Message find(String id);

    void bye(Message message);

    void update(Message saved);

    int countAll();
}
