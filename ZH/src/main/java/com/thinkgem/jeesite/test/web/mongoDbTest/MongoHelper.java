package com.thinkgem.jeesite.test.web.mongoDbTest;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(locations = "classpath:mongoDB.properties")
public class MongoHelper {
    @Value(value = "${DBName}")
    private  String DBName ;
    @Value("${mongo.SERVERADRESS}")
    private String SERVERADRESS ;
    static  int PORT = 27017;
    static String USERNAME = "${mongo.USERNAME}";
    static  String PASSWORD = "${mongo.PASSWORD}";


    public MongoHelper() {
    }

    public MongoClient getMongoClient() {
        MongoClient mongoClient = null;
        try {
            // 连接到 mongodb 服务
//            MongoCredential credential = MongoCredential.createScramSha1Credential("testuser", "test", "123456".toCharArray());
//            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
//            credentials.add(credential);
//            MongoClientOptions options = new MongoClientOptions.Builder().build();
//            ServerAddress serverAddress = new ServerAddress(SErverAddress,PORT);
//            mongoClient = new MongoClient(serverAddress, options);
            System.out.println("-----------WZP.print-----------DBName值=" + DBName + SERVERADRESS + PORT + "," + "当前类=MongoHelper.getMongoClient()");
            MongoClientURI uri = new MongoClientURI("mongodb://testuser:123456@10.100.50.111/?authSource=test");
            mongoClient = new MongoClient(uri);
            System.out.println("Connect to mongodb successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return mongoClient;
    }

    public MongoDatabase getMongoDataBase(MongoClient mongoClient) {
        MongoDatabase mongoDataBase = null;
        try {
            if (mongoClient != null) {
                // 连接到数据库
                mongoDataBase = mongoClient.getDatabase(DBName);

                System.out.println("Connect to DataBase successfully");
            } else {
                throw new RuntimeException("MongoClient不能够为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mongoDataBase;
    }

    public void closeMongoClient(MongoDatabase mongoDataBase, MongoClient mongoClient) {
        if (mongoDataBase != null) {
            mongoDataBase = null;
        }
        if (mongoClient != null) {
            mongoClient.close();
        }
        System.out.println("CloseMongoClient successfully");

    }
}