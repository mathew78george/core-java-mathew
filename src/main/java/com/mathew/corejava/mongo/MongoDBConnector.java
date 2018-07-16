package com.mathew.corejava.mongo;

import com.mongodb.Mongo;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;

public class MongoDBConnector {

  public static void main(String[] args) {
    try {
      MongoClient mongo = MongoClients.create();
      MongoIterable<String> dbds = mongo.listDatabaseNames();
      System.out.println(dbds.first());
    } catch(Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();

    }
  }

}
