package com.mathew.corejava.string;

import java.util.HashSet;
import java.util.Set;

public class StringManipulator {

	public String normalizeString(String ipString) {
		String normalizedStr = ipString.replaceAll("[^a-zA-Z]", "");
		return normalizedStr.toUpperCase();
	}

	public boolean hasUniqueCharecters(String ipString) {
		String normalizedStr = ipString.replaceAll("[^a-zA-Z]", "").toUpperCase();
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
		String normalizedStr = ipString.replaceAll("[^a-zA-Z]", "").toUpperCase();
		char[] charArray = normalizedStr.toCharArray();
		for (char aChar : charArray) {
			weight += (int) aChar;
		}
		weight = weight / charArray.length;
		return weight;
	}

	public double getWeightV2(String ipString) {
		double weight = 0;
		String normalizedStr = ipString.replaceAll("[^a-zA-Z]", "").toUpperCase();
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
		StringManipulator stutil = new StringManipulator();
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
		System.out.println(stutil.getWeight(
				"ABCDEFGsasa0sasasasa1pewpewpewpewpdfjjkdfjdfjdjfkdfdjfbsnbansbanbsnabsansansbanbsnabsbasn212121212klksalskalksalskalsvcvcbvbnvnqpmbcsertuiasdfgjklvcxzbnm"));
		System.out.println(stutil.getWeightV2(
				"ABCDEFGsasa0sasasasa1pewpewpewpewpdfjjkdfjdfjdjfkdfdjfbsnbansbanbsnabsansansbanbsnabsbasn212121212klksalskalksalskalsvcvcbvbnvnqpmbcsertuiasdfgjklvcxzbnm"));

	}

}
