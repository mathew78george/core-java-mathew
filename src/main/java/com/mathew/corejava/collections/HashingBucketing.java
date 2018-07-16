package com.mathew.corejava.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class HashingBucketing {

  public static void main1(String[] args) {
    Set<UUID> uuids = new HashSet<UUID>();
    for(int ii = 0; ii < 10000; ii++) {
      uuids.add(UUID.randomUUID());
    }
    int BUCKET = 10;
    Map<Integer, List> buckets = new HashMap<Integer, List>();
    for(UUID auuid : uuids) {
      int bucketNumber = auuid.hashCode() % BUCKET;
      if(bucketNumber < 0) bucketNumber = bucketNumber * -1;
      if(buckets.containsKey(bucketNumber)) {
        buckets.get(bucketNumber).add(auuid);
      } else {
        List<UUID> uidList = new ArrayList<UUID>();
        uidList.add(auuid);
        buckets.put(bucketNumber, uidList);
      }
    }
    int totalItems = 0;
    for(Integer bucketId : buckets.keySet()) {
      totalItems += buckets.get(bucketId).size();
      System.out.print("bucketId --->" + bucketId + " bucket size -->" + buckets.get(bucketId).size());
      System.out.println();
    }
    System.out.println("totalItems -->" + totalItems);
    System.out.println("buckets size -->" + uuids.size());

  }

  public static void main(String[] args) {
    Set<String> uuids = new HashSet<String>();
    for(int ii = 0; ii < 1000; ii++) {
      uuids.add("String" + ii);
    }
    int BUCKET = 5;
    Map<Integer, List> buckets = new HashMap<Integer, List>();
    for(String auuid : uuids) {
      int bucketNumber = auuid.hashCode() % BUCKET;
      if(bucketNumber < 0) bucketNumber = bucketNumber * -1;
      if(buckets.containsKey(bucketNumber)) {
        buckets.get(bucketNumber).add(auuid);
      } else {
        List<String> uidList = new ArrayList<String>();
        uidList.add(auuid);
        buckets.put(bucketNumber, uidList);
      }
    }
    int totalItems = 0;
    for(Integer bucketId : buckets.keySet()) {
      totalItems += buckets.get(bucketId).size();
      System.out.print("bucketId --->" + bucketId + " bucket size -->" + buckets.get(bucketId).size());
      System.out.println();
    }
    System.out.println("totalItems -->" + totalItems);
    System.out.println("buckets size -->" + uuids.size());

  }

}
