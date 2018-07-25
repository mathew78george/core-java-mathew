package com.mathew.corejava.general;

import java.util.ArrayList;
import java.util.List;

public class DecimaltoBinaryAndViceVersa {
	static final int BASE_BINARY = 2;
	static final int BASE_OCT = 8;
	static final int BASE_DEC = 10;
	static final int BASE_HEX = 16;
	static final Character[] HEX_CHAR = new Character[] { 'F', 'E', 'D', 'C', 'B', 'A' };
	static final String HEXDIGITS = "0123456789ABCDEF";

	public static void main(String[] args) {
		convertToHex();
	}

	public static void convertToBinary() {
		long decimal = 898989;
		List<Long> binary = new ArrayList<Long>();
		while (decimal > 0) {
			long reminder = decimal % BASE_BINARY;
			binary.add(reminder);
			decimal = decimal / BASE_BINARY;
		}
		long newDecimal = 0;
		for (int ii = binary.size() - 1; ii >= 0; ii--) {
			System.out.print(binary.get(ii));
			newDecimal = newDecimal + binary.get(ii) * (long) Math.pow(BASE_BINARY, ii);
		}
		System.out.println();
		System.out.println(newDecimal);
	}

	public static void convertToHex() {
		long decimal = 898989;
		String result = "";
		while (decimal > 0) {
			long reminder = decimal % BASE_HEX;
			if (reminder > 9) {
				result = HEX_CHAR[15 - (int) reminder] + result;
			} else {
				result = reminder + result;
			}
			decimal = decimal / BASE_HEX;
		}
		System.out.println(result);
		long newDecimal = 0;
		for (int ii = 0; ii < result.toCharArray().length; ii++) {
			char aChar = result.charAt(ii);
			int index = HEXDIGITS.indexOf(aChar);
			newDecimal = newDecimal * BASE_HEX + index;
			System.out.println(newDecimal);
			// String

			// newDecimal = newDecimal + binary.get(ii) * (long) Math.pow(BASE_BINARY, ii);
		}
		System.out.println();
		System.out.println(newDecimal);
		System.out.println(Integer.parseInt(result, 16));
	}
}
