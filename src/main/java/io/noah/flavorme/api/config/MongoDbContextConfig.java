package io.noah.flavorme.api.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import io.noah.flavorme.api.MongoRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by chanwook on 2014. 8. 28..
 */
@Configuration
@ComponentScan(useDefaultFilters = false,
        basePackages = {"io.noah.flavorme.api"},
        includeFilters= {@ComponentScan.Filter(value = {MongoRepository.class})})
public class MongoDBContextConfig extends AbstractMongoConfiguration {

    public static final String MONGO_HOST = "ds063809.mongolab.com";

    @Override
    protected String getDatabaseName() {
        return "flavor-me";
    }

    @Override
    protected UserCredentials getUserCredentials() {
        return new UserCredentials("flavorme", "flavorme00");
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(new ServerAddress(MONGO_HOST, 63809));
    }

    @Override
    protected String getMappingBasePackage() {
        return "io.noah.flavorme.api";
    }
}
