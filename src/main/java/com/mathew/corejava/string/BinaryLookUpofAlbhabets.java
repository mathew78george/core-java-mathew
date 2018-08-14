package com.mathew.corejava.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BinaryLookUpofAlbhabets {

	static Character[] albhabets = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'

	};

	static Map<Character, String> chartoBinaryMap = new HashMap<Character, String>();

	public static void main(String[] args) {
		for (Character aChar : albhabets) {
			int intVal = (int) aChar;
			System.out.println(intVal);
			String binVal = Integer.toBinaryString(intVal);
			chartoBinaryMap.put(aChar, binVal);
		}
		for (Iterator<Character> iter = chartoBinaryMap.keySet().iterator(); iter.hasNext();) {
			Character key = iter.next();
			String value = chartoBinaryMap.get(key);
			System.out.println("key -->" + key + " Value -->" + value);
		}
	}

}
