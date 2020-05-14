package com.jay.demo.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Arrays;

/**
 * author JayNing
 * created by 2020/3/17 15:05
 **/
public class MongoDemo {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoCollection<Document> collection
                = mongoClient.getDatabase("de_local").getCollection("de_test1_data");


        AggregateIterable<Document> aggregate = collection.aggregate(Arrays.asList(
                //对集合进行条件过滤
                Aggregates.match(Filters.and(
                        Filters.in("_id", "B77APg3ZBK0rKk_Cx3XomP")
                        )
                )

        ));

    }
}
