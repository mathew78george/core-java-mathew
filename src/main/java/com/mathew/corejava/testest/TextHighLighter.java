package com.mathew.corejava.testest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class TextHighLighter {

	public static String doHighlightText(String text, Map<String, List<String>> config) {
		StringBuffer response = new StringBuffer();
		StringTokenizer tokenizer = new StringTokenizer(text, " ");
		Map<String, String> invIndex = createInvertedIndex(config);
		while (tokenizer.hasMoreTokens()) {
			String aToken = tokenizer.nextToken();
			String color = invIndex.get(aToken);
			if (color != null) {
				response.append("<" + color + "> " + aToken + " </" + color + "> ");
			} else {
				response.append(aToken+" ");
			}

		}
		return response.toString();
	}

	private static String getColor(Map<String, List<String>> config, String aToken) {
		Set<String> colors = config.keySet();
		for (String aColor : colors) {
			List<String> words = config.get(aColor);
			if (words.contains(aToken)) {
				return aColor;
			}
		}
		return null;
	}

	private static Map<String, String> createInvertedIndex(Map<String, List<String>> config) {
		Map<String, String> invertedIndex = new HashMap<String, String>();
		Set<String> colors = config.keySet();
		for (String aColor : colors) {
			List<String> words = config.get(aColor);
			for (String aWord : words) {
				invertedIndex.put(aWord, aColor);
			}
		}
		return invertedIndex;
	}

	public static void main(String[] args) {
		String input = " This is a dangerous disecase. This needs immedaiete attention"
				+ " also it is very difficult to assess this impact on the fly please. Please take care of immedaiete effect. Otherwise it will be dangerous situation."
				+ "All is well explanied situation as is. Hey hello how are you";
		Map<String, List<String>> conf = new HashMap<String, List<String>>();
		conf.put("RED", Arrays.asList("dangerous", "immedaiete"));
		conf.put("BLUE", Arrays.asList("attention", "impact"));
		conf.put("GREEN", Arrays.asList("hello", "fly", "situation"));
		System.out.println(doHighlightText(input, conf));
	}

}
