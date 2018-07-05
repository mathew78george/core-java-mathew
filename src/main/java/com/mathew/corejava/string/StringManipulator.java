package com.mathew.corejava.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StringManipulator {

	public String normalizeString(String ipString) {
		String normalizedStr = ipString.replaceAll("[^a-zA-Z]", "");
		return normalizedStr.toUpperCase();
	}

	public boolean hasUniqueCharecters(String ipString) {
		String normalizedStr = normalizeString(ipString);
		if (normalizedStr.length() > 26) {
			return false;
		}
		Set<Character> uniqueChars = new HashSet<Character>();
		for (char aChar : normalizedStr.toCharArray()) {
			boolean isUnique = uniqueChars.add(aChar);
			if (!isUnique)
				return false;

		}
		return true;
	}

	public double getWeight(String ipString) {
		double weight = 0;
		String normalizedStr = normalizeString(ipString);
		char[] charArray = normalizedStr.toCharArray();
		for (char aChar : charArray) {
			weight += (int) aChar;
		}
		weight = weight / charArray.length;
		return weight;
	}

	public double getWeightV2(String ipString) {
		double weight = 0;
		String normalizedStr = normalizeString(ipString);
		char[] charArray = normalizedStr.toCharArray();
		Set<Character> uniqueCharSet = new HashSet<Character>();
		for (char aChar : charArray) {
			uniqueCharSet.add(aChar);
			if (uniqueCharSet.size() == 26) {
				break;
			}
		}
		for (char aChar : uniqueCharSet) {
			weight += (int) aChar;
		}
		weight = weight / uniqueCharSet.size();
		return weight;
	}

	public static void main(String[] args) {
		System.out.println(1 << 30);
		StringManipulator stutil = new StringManipulator();
		Set<StringWrapper> wrappedWords = new TreeSet<StringWrapper>();
		try {
			List<String> words = readData("challenge_tests.csv");
			for (String aword : words) {
				String ns = stutil.normalizeString(aword);
				boolean unique = stutil.hasUniqueCharecters(aword);
				double strngth = stutil.getWeightV2(aword);
				wrappedWords.add(new StringWrapper(ns, unique, strngth));
			}
			writeData("challenge_result.csv", wrappedWords);
			System.out.println("Done-->compare cout" + StringWrapper.compareCount);
		} catch (IOException ioe) {

		}
		/*
		 * System.out.println(stutil.
		 * normalizeString("@!@!@sasasasasas; sasasa9021021212sasasasakkkksasasasa***Q!sasa"
		 * )); System.out.println(stutil.hasUniqueCharecters("a2p’}}pl66e"));
		 * System.out.println(stutil.hasUniqueCharecters("co%m$Puter"));
		 * System.out.println(stutil.hasUniqueCharecters(
		 * "@!@!@abcdefghijklmnopqrstuvwxyz"));
		 * System.out.println(stutil.hasUniqueCharecters(
		 * "@!@!@abcdefghijklmnopqrstuvwxyz@!@!@!@!@A"));
		 * System.out.println(stutil.hasUniqueCharecters(
		 * "@!@!@abcdefghijklmnopqrstuvwxyz-1-2-12-12-1-2121---"));
		 * System.out.println(stutil.hasUniqueCharecters(
		 * "@!@!@abcdefghijklmnopqrstuvwxyz-1-2-12-12-1-2121---AB"));
		 */
		// System.out.println(stutil.getWeight(
		// "ABCDEFGsasa0sasasasa1pewpewpewpewpdfjjkdfjdfjdjfkdfdjfbsnbansbanbsnabsansansbanbsnabsbasn212121212klksalskalksalskalsvcvcbvbnvnqpmbcsertuiasdfgjklvcxzbnm"));
		// System.out.println(stutil.getWeightV2(
		// "ABCDEFGsasa0sasasasa1pewpewpewpewpdfjjkdfjdfjdjfkdfdjfbsnbansbanbsnabsansansbanbsnabsbasn212121212klksalskalksalskalsvcvcbvbnvnqpmbcsertuiasdfgjklvcxzbnm"));
		// readData("challenge_sorted.csv");
		// writeData("challenge_sorted1.csv");

	}

	private static List<String> readData(String fileName) throws IOException {
		List<String> words = new ArrayList<String>();
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				words.add(line);
				line = br.readLine();
			}
			br.close();
		}
		return words;
	}

	private static void writeData(String fileName, Set<StringWrapper> wrappedWords) throws IOException {
		Path pathToFile = Paths.get(fileName);
		try (BufferedWriter writer = Files.newBufferedWriter(pathToFile, StandardCharsets.US_ASCII,
				StandardOpenOption.CREATE)) {
			writer.write("Word,Unique,Strenth");
			writer.write("\n");
			for (StringWrapper aword : wrappedWords) {
				writer.write(aword.getNormalizedString() + "," + aword.isUniqueCharecter() + "," + aword.getStrenth());
				writer.write("\n");
			}
			writer.flush();
			writer.close();
		}
	}
}

class StringWrapper implements Comparable<StringWrapper> {
	static int compareCount = 0;
	private String normalizedString;
	private boolean isUniqueCharecter;
	private double strenth;

	public StringWrapper(String ns, boolean unique, double strngth) {
		normalizedString = ns;
		isUniqueCharecter = unique;
		strenth = strngth;
	}

	public String getNormalizedString() {
		return normalizedString;
	}

	public boolean isUniqueCharecter() {
		return isUniqueCharecter;
	}

	public double getStrenth() {
		return strenth;
	}

	@Override
	public int compareTo(StringWrapper o) {
		compareCount++;
		Double strenth = getStrenth();
		Double strenthOther = o.getStrenth();
		return (strenthOther.compareTo(strenth));
	}
}
