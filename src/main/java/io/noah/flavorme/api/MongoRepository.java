package io.noah.flavorme.api;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * Created by chanwook on 2014. 9. 11..
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface MongoRepository {
}
