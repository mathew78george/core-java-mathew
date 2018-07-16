package com.mathew.corejava.collections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MapKeyAndValueSorting {

  public static void main(String[] args) {
    // keySortingUsingTreeMap();
    // valueSorting1();
    // basicinsertionAndIterationOfMaps();
    StringBuilder builder = readFiletoStringBuilder();
    buildWorldFrequencyMap(builder);
  }

  static void keySortingUsingTreeMap() {
    Map<String, Integer> input = new HashMap<String, Integer>();
    input.put("B", 8);
    input.put("M", 0);
    input.put("S", 5);
    input.put("A", 6);
    input.put("C", 4);
    input.put("E", 1);
    input.put("D", 9);
    input.put("K", 2);

    Map<String, Integer> output = new TreeMap<String, Integer>(input);
    for(Map.Entry<String, Integer> entry : output.entrySet()) {
      System.out.println(entry.getKey() + "-->" + entry.getValue());
    }
  }

  static void valueSorting1() {
    Map<String, Integer> input = new HashMap<String, Integer>();
    input.put("B", 8);
    input.put("M", 0);
    input.put("S", 5);
    input.put("A", 6);
    input.put("C", 4);
    input.put("E", 1);
    input.put("D", 9);
    input.put("K", 2);
    List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(input.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
        return obj1.getValue().compareTo(obj2.getValue());
      }
    });
    Map<String, Integer> output = new LinkedHashMap<String, Integer>();
    for(Map.Entry<String, Integer> enrty : list) {
      output.put(enrty.getKey(), enrty.getValue());
    }
    for(Map.Entry<String, Integer> entry : output.entrySet()) {
      System.out.println(entry.getKey() + "-->" + entry.getValue());
    }
  }

  static void basicinsertionAndIterationOfMaps() {
    Map<String, String> m1 = new HashMap<String, String>();
    m1.put("map", "HashMap");
    m1.put("schildt", "java2");
    m1.put("mathew", "Hyden");
    m1.put("schildt", "java2s");
    m1.put("abc", "test");
    printMap(m1);
    System.out.println("--------------------");
    Map<String, String> sm = new TreeMap<String, String>();
    sm.put("map", "TreeMap");
    sm.put("schildt", "java2");
    sm.put("mathew", "Hyden");
    sm.put("schildt", "java2s");
    sm.put("abc", "test");
    printMap(sm);
    System.out.println("--------------------");
    Map<String, String> lm = new LinkedHashMap<String, String>();
    lm.put("map", "LinkedHashMap");
    lm.put("schildt", "java2");
    lm.put("mathew", "Hyden");
    lm.put("schildt", "java2s");
    lm.put("abc", "test");
    printMap(lm);

  }

  static void printMap(Map<String, String> map) {
    for(Map.Entry<String, String> entry : map.entrySet()) {
      System.out.println(entry.getKey() + "-->" + entry.getValue());
    }
  }

  static StringBuilder readFiletoStringBuilder() {
    BufferedReader br = null;
    StringBuilder builder = null;
    try {
      builder = new StringBuilder();
      String workingDir = System.getProperty("user.dir");
      File file = new File(workingDir + "\\src", "words.txt");
      br = new BufferedReader(new FileReader(file));
      String line = br.readLine();
      while(line != null) {
        builder.append(line);
        builder.append(System.lineSeparator());
        line = br.readLine();
      }
    } catch(FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch(IOException ioe) {

    } finally {
      try {
        br.close();
      } catch(IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }    
    return builder;
  }

  static void buildWorldFrequencyMap(StringBuilder builder) {
    String str = builder.toString();
    String strnew = str.replaceAll("\""," ");
    strnew = strnew.replaceAll("\'"," ");
    Map<String, Integer> wordFreqMap = new TreeMap<String, Integer>();
    StringTokenizer tokenozer = new StringTokenizer(strnew);
    while(tokenozer.hasMoreElements()) {
      String aToken = (String) tokenozer.nextElement();
      if(wordFreqMap.containsKey(aToken)) {
        int freq = wordFreqMap.get(aToken);
        freq++;
        wordFreqMap.put(aToken, freq);
      } else {
        wordFreqMap.put(aToken, 1);
      }
    }
    for(Map.Entry<String, Integer> entry : wordFreqMap.entrySet()) {
      System.out.println(entry.getKey() + "-->" + entry.getValue());
    }
  }
}
