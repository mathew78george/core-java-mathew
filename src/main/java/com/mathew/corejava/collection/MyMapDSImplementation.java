package com.mathew.corejava.collection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyMapDSImplementation<K, V> implements Map<K, V> {

	Node<K, V>[] table;
	private int bucketSize;
	private int threshold;
	private float loadFactor = 0.75f;
	// private static final int MAX_ARRAY_SIZE = 64;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	int count = 0;

	public MyMapDSImplementation() {
		bucketSize = 11;
		table = new Node[bucketSize];
		threshold = (int) Math.min(bucketSize * loadFactor, MAX_ARRAY_SIZE + 1);
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public boolean containsKey(Object key) {
		return (get(key) == null);
	}

	private void reSize() {
		Node<K, V>[] oldTab = table;
		int oldBucketSize = oldTab.length;
		int newBucketSize = oldBucketSize << 1;
		if (oldBucketSize >= MAX_ARRAY_SIZE || newBucketSize >= MAX_ARRAY_SIZE) {
			return;
		}
		Node<K, V>[] newTab = new Node[newBucketSize];
		bucketSize = newBucketSize;
		for (Node<K, V> entry : oldTab) {
			if (entry != null) {
				int index = entry.key.hashCode() % newBucketSize;
				newTab[index] = entry;
			}
		}
		table = newTab;
		threshold = (int) Math.min(newBucketSize * loadFactor, MAX_ARRAY_SIZE + 1);
	}

	@Override
	public boolean containsValue(Object value) {
		if (count == 0) {
			return false;
		}
		for (Node<K, V> entry : table) {
			Node<K, V> aNode = entry;
			while (aNode != null) {
				if (aNode.value == value) {
					return true;
				}
				aNode = entry.next;
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		K castedKey = (K) key;
		int hash = castedKey.hashCode();
		int index = hash % bucketSize;
		Node<K, V> node = (Node<K, V>) table[index];
		if (node == null) {
			return null;
		}
		Node<K, V> aNode = node;
		while (aNode != null) {
			if (hash == aNode.hash && castedKey.equals(aNode.key)) {
				return aNode.value;
			}
			aNode = aNode.next;
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		if (count >= threshold) {
			reSize();
		}
		int hash = key.hashCode();
		int index = hash % bucketSize;
		Node<K, V> existingNode = (Node<K, V>) table[index];
		if (existingNode == null) {
			Node<K, V> newNode = new Node<K, V>(hash, key, value, null);
			table[index] = newNode;
			count++;
			return value;
		}
		Node<K, V> aNode = existingNode;
		while (aNode != null) {
			if (hash == aNode.hash && key.equals(aNode.key)) {
				aNode.value = value;
				return value;
			}
			aNode = aNode.next;
		}
		Node<K, V> newNode = new Node<K, V>(hash, key, value, existingNode);
		table[index] = newNode;
		count++;
		return value;
	}

	public V put1(K key, V value) {
		int hash = key.hashCode();
		int index = hash % bucketSize;
		if (count == 0) {
			System.out.println("Zero");
			Node<K, V> node = new Node<K, V>(hash, key, value, null);
			table[index] = node;
		} else {
			Node<K, V> existingNode = (Node<K, V>) table[index];
			if (existingNode != null) {
				Node<K, V> aNode = existingNode;
				while (aNode != null) {
					if (hash == aNode.hash && key.equals(aNode.key)) {
						aNode.value = value;
						return null;
					}
					aNode = aNode.next;
				}
				Node<K, V> newNode = new Node<K, V>(hash, key, value, existingNode);
				table[index] = newNode;
			} else {
				Node<K, V> newNode = new Node<K, V>(hash, key, value, existingNode);
				table[index] = newNode;
			}
		}
		count++;
		return null;
	}

	@Override
	public V remove(Object key) {
		int hash = key.hashCode();
		int index = hash % bucketSize;
		Node<K, V> head = table[index];
		if (head == null) {
			System.out.println("Element not found");
			return null;
		}
		Node<K, V> previous = null;
		while (head != null) {
			if (hash == head.hash) {
				break;
			}
			previous = head;
			head = head.next;
		}
		if (head == null) {
			System.out.println("Element not found");
			return null;
		}
		if (previous != null) {
			previous.next = head.next;
		} else {
			table[index] = head.next;
		}
		count--;
		return head.value;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		for (int ii = 0; ii < bucketSize; ii++) {
			table[ii] = null;
		}
		count = 0;
	}

	@Override
	public Set<K> keySet() {
		Set<K> keySet = new HashSet<K>();
		for (int ii = 0; ii < bucketSize; ii++) {
			Node<K, V> aNode = (Node<K, V>) table[ii];
			while (aNode != null) {
				keySet.add((K) aNode.key);
				aNode = aNode.next;
			}
		}
		return keySet;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {

		return null;
	}

	public Iterator<Node<K, V>> entrySetIter() {
		return new EntrySetIter();
	}

	class EntrySetIter implements Iterator<Node<K, V>> {
		Node<K, V> current;
		int counter = 0;
		int currentIndex = 0;

		public EntrySetIter() {
			current = table[counter++];
		}

		@Override
		public boolean hasNext() {
			return (currentIndex < count);
		}

		@Override
		public Node<K, V> next() {
			if (current == null && counter < bucketSize) {
				current = table[counter++];
			}
			if (current == null) {
				System.out.println("returning null");
				return null;
			}
			Node<K, V> node = current;
			current = node.next;
			currentIndex++;
			return node;
		}

	}

	static class Node<K, V> {
		K key;
		V value;
		int hash;
		Node<K, V> next;

		Node(int h, K k, V v, Node<K, V> n) {
			key = k;
			value = v;
			hash = h;
			next = n;
		}

		@Override
		public String toString() {
			return "[key = " + key + " + value =" + value + "]";
		}
	}

	public static void main(String[] args) {
		MyMapDSImplementation<Integer, String> maps = new MyMapDSImplementation<Integer, String>();
		for (int ii = 0; ii < 100; ii++) {
			maps.put(new Integer(ii), "Value" + ii);
		}
		System.out.println("maps bucket size" + maps.table.length);
		Path pathtoFile = Paths.get("mapoutput.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(pathtoFile, StandardCharsets.US_ASCII,
				StandardOpenOption.CREATE)) {
			Set<Integer> keys = maps.keySet();
			for (Integer aKey : keys) {
				String value = (String) maps.get(aKey);
				writer.write(aKey + "  " + value + "\n");
			}
			writer.close();
		} catch (IOException ioe) {

		}
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Float.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);

	}

}
