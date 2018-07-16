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
  
	static int[] solve(int[] a, int[] b) {
		int scoreA = 0;
		int scoreB = 0;
		int arrayLengn = a.length;
		if (arrayLengn != b.length) {
			System.out.println("Array Lengnth are not matching");
			return null;
		}
		for (int ii = 0; ii < arrayLengn; ii++) {
			if (a[ii] > b[ii]) {
				scoreA++;
			} else if (b[ii] > a[ii]) {
				scoreB++;
			}
		}
		return new int[] { scoreA, scoreB };
	}


}
