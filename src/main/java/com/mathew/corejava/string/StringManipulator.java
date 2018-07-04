package com.mathew.corejava.string;

public class StringManipulator {

	public String normalizeString(String ipString) {
		String normalizedStr = ipString.replaceAll("[^a-zA-Z]", "");
		System.out.println(normalizedStr);
		return normalizedStr.toUpperCase();
	}

	public static void main(String[] args) {
		StringManipulator stutil = new StringManipulator();
		System.out.println(stutil.normalizeString("@!@!@sasasasasas; sasasa9021021212sasasasakkkksasasasa***Q!sasa"));
	}

}
