package io.noah.flavorme.api.hello;

import io.noah.flavorme.api.config.AppContextConfig;
import io.noah.flavorme.api.config.MongoDbContextConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.*;

/**
 * Created by chanwook on 2014. 8. 29..
 */
@ContextConfiguration(classes = {MongoDbContextConfig.class, AppContextConfig.class})
public class HelloRepositoryTests extends AbstractJUnit4SpringContextTests {

    @Autowired
    HelloRepository r;

    @Autowired
    MongoTemplate m;

    @Test
    public void testSimpleCrud() throws Exception {

        Message message = new Message("Hi~Hello~");
        r.hello(message);

        assertTrue(message.getId() != null && message.getId().length() > 0);

        Message saved = r.find(message.getId());
        assertNotNull(saved);
        assertEquals(message.getMessage(), saved.getMessage());

        saved.setMessage("Bye~~");
        r.update(saved);

        saved = r.find(message.getId());
        assertEquals("Bye~~", saved.getMessage());

        r.bye(message);

        assertTrue(0 == r.countAll());


        m.dropCollection(Message.class);

    }
}
