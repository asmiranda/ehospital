package com.ajb.ehospital.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;


@Configuration
@EnableMongoRepositories("com.ajb.ehospital.repository")
@PropertySource("classpath:application.properties")
@ComponentScan("com.ajb.ehospital")
@EnableMongoAuditing
public class MongoConfig extends AbstractMongoConfiguration {
    @Value("${dataSource.username}")
    private String username;
    @Value("${dataSource.password}")
    private String password;
    @Value("${dataSource.databaseName}")
    private String databaseName;
    @Value("${dataSource.serverAddress}")
    private String serverAddress;
    @Value("${dataSource.port}")
    private int port;

    /**
     * Return the name of the database to connect to.
     *
     * @return must not be {@literal null}.
     */
    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public Mongo mongo() throws Exception {
        if ((username == null || username.isEmpty()))
            return new MongoClient(new ServerAddress(serverAddress, port));
        MongoCredential mongoCredential = MongoCredential.createCredential(username,
                getDatabaseName(),
                password.toCharArray());
        return new MongoClient(new ServerAddress(serverAddress, port),
                Arrays.asList(mongoCredential));
    }
}
