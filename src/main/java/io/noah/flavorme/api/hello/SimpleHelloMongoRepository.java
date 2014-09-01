package io.noah.flavorme.api.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by chanwook on 2014. 8. 28..
 */
@Repository
public class SimpleHelloMongoRepository implements HelloRepository {

    @Autowired
    private MongoTemplate mt;


    @Override
    public void hello(Message msg) {
        mt.insert(msg);
    }

    @Override
    public Message find(String id) {
        return mt.findById(id, Message.class);
    }

    @Override
    public void bye(Message msg) {
        mt.remove(msg);
    }

    @Override
    public void update(Message msg) {
        mt.updateFirst(query(where("id").is(msg.getId())), Update.update("message", msg.getMessage()), Message.class);
    }

    @Override
    public int countAll() {
        return mt.findAll(Message.class).size();
    }
}
