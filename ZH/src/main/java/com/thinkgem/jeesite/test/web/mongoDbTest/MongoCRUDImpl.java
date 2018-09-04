package com.thinkgem.jeesite.test.web.mongoDbTest;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

public class MongoCRUDImpl implements MongoDao {
    @Override
    public Map<String, Integer> queryByID(MongoDatabase db, String table, Object Id) throws Exception {
        MongoCollection<Document> collection = db.getCollection(table);
        BasicDBObject query = new BasicDBObject("_id", Id);
        //  DBObject接口和BasicDBObject对象：表示一个具体的记录，BasicDBObject实现了DBObject，是key-value的数据结构，用起来和HashMap是基本一致的。
        FindIterable<Document> iterable = collection.find(query);

//      for (Document dd : iterable) {
//          int dudu = dd.getInteger("上海"); // 读取响应的数据
//          System.out.println("dudududu:"+dudu);
//      }

        Map<String, Integer> jsonStrToMap = null;
        MongoCursor<Document> cursor = iterable.iterator();
        while (cursor.hasNext()) {
            Document user = cursor.next();
            String jsonString = user.toJson();
            jsonStrToMap = jsonStrToMap(jsonString);//这里用到我自己写的方法,主要是包json字符串转换成map格式,为后面做准备,方法放在后面
        }
        System.out.println("检索ID完毕");

        return jsonStrToMap;
    }
    public  Map<String, Integer> jsonStrToMap(String jsonString) {
        Object parseObj = JSON.parse(jsonString); // 反序列化 把json 转化为对象
        Map<String, Integer> map = (HashMap<String, Integer>) parseObj; // 把对象转化为map
        return map;
    }
    @Override
    public boolean insert(MongoDatabase db, String table, Document doc) {
        MongoCollection<Document> collection = db.getCollection(table);
        collection.insertOne(doc);
        long count = collection.count(doc);
        System.out.println("count: "+count);
        if(count == 1){
            System.out.println("文档插入成功");
            return true;
        }else{
            System.out.println("文档插入成功");
            return false;
        }
    }

    @Override
    public boolean delete(MongoDatabase db, String table, BasicDBObject doc) {
        return false;
    }

    @Override
    public boolean update(MongoDatabase db, String table, BasicDBObject oldDoc, BasicDBObject newDoc) {
        return false;
    }
}
