package com.thinkgem.jeesite.test.web.mongoDbTest;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.BsonValue;
import org.bson.Document;
import org.junit.Test;

import java.util.Map;

import static com.mongodb.client.model.Filters.eq;

public class TestMongDBJDBC {
    private MongoHelper mongoHelper = new MongoHelper();

    @Test
    public void connectTest() {
        try {
            // 连接到 mongodb 服务
//            MongoClient mongoClient = new MongoClient("39.106.214.184", 27017);
//            MongoClient mongoClient = new MongoClient("10.100.50.111", 27017);
//            用户名密码认证连接
//            MongoClient mongoClient = new MongoClient("10.100.50.111", 27017);
            MongoClient mongoClient = new MongoClient("mongodb://mongoadmin:love431@10.100.50.111:27017/?authSource=admin");

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            System.out.println("连接到数据库");
//            创建集合
            mongoDatabase.createCollection("b");
            System.out.println("创建集合");


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


    @Test
    public void test2() throws Exception {
        MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        System.out.println("-----------WZP.print-----------mongoDataBase.getName()值=" + mongoDataBase.getName() + "," + "当前类=TestMongDBJDBC.test2()");

    }

    @Test
    public void closemongo() throws Exception {
        MongoClient mongoClient = mongoHelper.getMongoClient();
        MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoClient);
        mongoHelper.closeMongoClient(mongoDataBase, mongoClient);

    }

    /**
     * 新增文档
     * @throws Exception
     */
    @Test
    public void CrudAdd() throws Exception {
        MongoCRUDImpl mongoCRUD = new MongoCRUDImpl();
        MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        MongoCollection<Document> crudtest = mongoDataBase.getCollection("crudtest");
        crudtest.insertOne(Document.parse("{'aa':'123'}"));
    }
    /**
     * 查询库
     * @throws Exception
     */
    @Test
    public void CrudQueryDatabase() throws Exception {
        MongoCRUDImpl mongoCRUD = new MongoCRUDImpl();
        MongoClient mongoClient = mongoHelper.getMongoClient();
        System.out.println("-----------WZP.print-----------所有表名=" + "：" + "当前类=TestMongDBJDBC.CrudQueryCollection()");

    }
    /**
     * 查询集合
     * @throws Exception
     */
    @Test
    public void CrudQueryCollection() throws Exception {
        MongoCRUDImpl mongoCRUD = new MongoCRUDImpl();
        MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        MongoIterable<String> strings = mongoDataBase.listCollectionNames();
        System.out.println("-----------WZP.print-----------所有表名=" + "：" + "当前类=TestMongDBJDBC.CrudQueryCollection()");
        for (String s : strings) {
            System.out.println(s);
        }
    }

    /**
     * 查询文档
     * @throws Exception
     */
    @Test
    public void CrudQuery() throws Exception {
        MongoCRUDImpl mongoCRUD = new MongoCRUDImpl();
        MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        Map<String, Integer> stringIntegerMap = mongoCRUD.queryByID(mongoDataBase, "crudtest", 1);

        System.out.println("-----------WZP.print-----------stringIntegerMap.toString()值=" + stringIntegerMap.toString() + "," + "当前类=TestMongDBJDBC.CrudQuery()");
    }
    /**
     * 删除文档
     */
    @Test
    public  void CrudDel() throws Exception{
        MongoCRUDImpl mongoCRUD = new MongoCRUDImpl();
        MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        MongoCollection<Document> crudtest = mongoDataBase.getCollection("crudtest");

        DeleteResult aa = crudtest.deleteOne(eq("aa", "123"));
    }
    /**
     * 更新文档
     */
    @Test
    public  void CrudUpdate() throws Exception{
        MongoCRUDImpl mongoCRUD = new MongoCRUDImpl();
        MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        MongoCollection<Document> crudtest = mongoDataBase.getCollection("crudtest");
        UpdateResult updateResult = crudtest.updateOne(eq("_id", 1.0), new Document("$set", new Document("title", "更新了标题2")));
        BsonValue upsertedId = updateResult.getUpsertedId();

        System.out.println("-----------WZP.print-----------updateResult值=" + updateResult + "," + "当前类=TestMongDBJDBC.CrudUpdate()");
    }
}
