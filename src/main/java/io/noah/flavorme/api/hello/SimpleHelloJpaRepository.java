package io.noah.flavorme.api.hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by chanwook on 2014. 9. 1..
 */
@Repository
public interface SimpleHelloJpaRepository extends CrudRepository<Message, String> {
}
