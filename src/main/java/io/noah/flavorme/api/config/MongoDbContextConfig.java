package io.noah.flavorme.api.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by chanwook on 2014. 8. 28..
 */
@Configuration
public class MongoDbContextConfig extends AbstractMongoConfiguration {

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
}
