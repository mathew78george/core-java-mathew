package com.mathew.corejava.general;

import java.util.Hashtable;

public class FirstNonRepCharInString {

  public static void main(String[] args) {
    String input = "AliveIsAwesome ";
    Hashtable<Character, Integer> charFreqMap = new Hashtable<Character, Integer>();
    for(int ii = 0; ii < input.length(); ii++) {
      char aChar = input.charAt(ii);
      if(charFreqMap.containsKey(aChar)) {
        Integer freq = charFreqMap.get(aChar);
        freq = freq + 1;
        charFreqMap.put(aChar, freq);
      } else {
        charFreqMap.put(aChar, new Integer(1));
      }
    }
    for(int ii = 0; ii < input.length(); ii++) {
     if((charFreqMap.get(input.charAt(ii)) == 1)){
       System.out.println(input.charAt(ii));
       break;
     }
    }
//    System.out.println(charFreqMap);
  }

}
