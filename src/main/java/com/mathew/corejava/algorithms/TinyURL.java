package com.mathew.corejava.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TinyURL {
	private static final String ALPHABET_NUM_MAP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int ALPHABET_NUM_BASE = ALPHABET_NUM_MAP.length();

	private static final String ALPHABET_MAP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int ALPHABET_BASE = ALPHABET_MAP.length();

	public String encodeAlphNum(long IndexNum) {
		if (IndexNum < 0) {
			IndexNum = IndexNum * -1;
		}
		StringBuffer urlBuffer = new StringBuffer();
		while (IndexNum > 0) {
			urlBuffer.append(ALPHABET_NUM_MAP.charAt((int) IndexNum % ALPHABET_NUM_BASE));
			IndexNum /= ALPHABET_NUM_BASE;
		}
		return urlBuffer.reverse().toString();
	}

	public long decodeAlphNum(String url) {
		long indexNum = 0;
		for (int ii = 0; ii < url.length(); ii++) {
			indexNum = indexNum * ALPHABET_NUM_BASE + ALPHABET_NUM_MAP.indexOf(url.charAt(ii));
		}
		return indexNum;
	}

	public String encodeAlph(long identifier) {
		StringBuffer encodeBuffer = new StringBuffer();
		if (identifier < 0)
			identifier = identifier * -1;
		while (identifier > 0) {
			encodeBuffer.append(ALPHABET_MAP.charAt((int) identifier % ALPHABET_BASE));
			identifier = identifier / ALPHABET_BASE;
		}
		return encodeBuffer.reverse().toString();
	}

	public long decodeAlph(String url) {
		long identifier = 0;
		for (int ii = 0; ii < url.length(); ii++) {
			identifier = identifier * ALPHABET_BASE + ALPHABET_MAP.indexOf(url.charAt(ii));
		}
		return identifier;
	}

	public static void testencodedecodeAlphNum(String[] args) {
		TinyURL urlService = new TinyURL();
		UUID uid = UUID.randomUUID();
		String url = urlService.encodeAlphNum(uid.hashCode());
		System.out.println("UUID.randomUUID.hashCode -->" + uid.hashCode());
		System.out.println("Encoded URL-->" + url);
		System.out.println("Decoded URL-->" + urlService.decodeAlphNum(url));
	}

	public static void test2(String[] args) {
		TinyURL urlService = new TinyURL();
		List<String> urls = new ArrayList<String>();
		for (int i = 1000000; i < 1200000; i++) {
			String url = urlService.encodeAlphNum(i);
			System.out.println("Id--> " + i + "  URL--> " + url);
			urls.add(url);

		}
		for (String astr : urls) {
			System.out.println("URL " + astr + "--> Id " + urlService.decodeAlphNum(astr));
		}
	}

	public static void main1(String[] args) {
		TinyURL urlService = new TinyURL();
		for (int i = 0; i < 10000; i++) {
			UUID uid = UUID.randomUUID();
			long id = uid.hashCode();
			if (id < 0)
				id = id * -1;
			String url = urlService.encodeAlph(id);
			long decodeId = urlService.decodeAlph(url);
			// System.out.println("Id-->" + id + " URL-->" + url + " decodeId -->" +
			// decodeId);
			if (decodeId != id) {
				System.out.println("===========WRONG DECODING=============" + id + "-----" + decodeId);
			}

		}
	}

	public static void main(String[] args) {
		test2(args);
	}
}
