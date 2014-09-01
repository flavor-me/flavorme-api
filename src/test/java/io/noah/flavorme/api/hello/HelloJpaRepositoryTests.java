package io.noah.flavorme.api.hello;

import io.noah.flavorme.api.config.JpaDBContextConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by chanwook on 2014. 8. 29..
 */
@ContextConfiguration(classes = {JpaDBContextConfig.class})
public class HelloJpaRepositoryTests extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    SimpleHelloJpaRepository r;

    @Test
    public void testSimpleCrud() throws Exception {
        // JPA auto increment는 integral type만 되니까 직접 생성 ..
        Message message = new Message(UUID.randomUUID().toString(), "Hi~Hello~");
        r.save(message);

        assertTrue(message.getId() != null && message.getId().length() > 0);

        Message saved = r.findOne(message.getId());
        assertNotNull(saved);
        assertEquals(message.getMessage(), saved.getMessage());

        saved.setMessage("Bye~~");
        r.save(saved);

        saved = r.findOne(message.getId());
        assertEquals("Bye~~", saved.getMessage());

        r.delete(message);

        assertTrue(0 == r.count());
    }
}
