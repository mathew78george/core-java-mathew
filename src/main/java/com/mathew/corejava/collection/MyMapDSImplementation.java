package com.mathew.corejava.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyMapDSImplementation<K, V> implements Map<K, V> {

	Node<K, V>[] table;
	static final int BUCKET_SIZE = 6;
	int count = 0;

	public MyMapDSImplementation() {
		table = new Node[BUCKET_SIZE];
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

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		K castedKey = (K) key;
		int hash = castedKey.hashCode();
		int index = hash % BUCKET_SIZE;
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
		int hash = key.hashCode();
		int index = hash % BUCKET_SIZE;
		Node<K, V> existingNode = (Node<K, V>) table[index];
		if (existingNode == null) {
			Node<K, V> newNode = new Node<K, V>(hash, key, value, null);
			table[index] = newNode;
			count++;
			return value;
		}
		Node<K, V> aNode = existingNode;
		count++;
		while (aNode != null) {
			if (hash == aNode.hash && key.equals(aNode.key)) {
				aNode.value = value;
				return value;
			}
			aNode = aNode.next;
		}
		Node<K, V> newNode = new Node<K, V>(hash, key, value, existingNode);
		table[index] = newNode;
		return value;
	}

	public V put1(K key, V value) {
		int hash = key.hashCode();
		int index = hash % BUCKET_SIZE;
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
		int index = hash % BUCKET_SIZE;
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
		return head.value;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<K> keySet() {
		Set<K> keySet = new HashSet<K>();
		for (int ii = 0; ii < BUCKET_SIZE; ii++) {
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
		// TODO Auto-generated method stub
		return null;
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
	}

	public static void main(String[] args) {
		MyMapDSImplementation<Integer, String> maps = new MyMapDSImplementation<Integer, String>();
		for (int ii = 0; ii < 30; ii++) {
			maps.put(new Integer(ii), "Value" + ii);
		}
		maps.put(new Integer(16), "New Value 16");
		maps.put(new Integer(15), "New Value 15");
		maps.put(new Integer(20), "New Value 20");
		maps.put(new Integer(21), "New Value 21");
		maps.put(new Integer(29), "New Value 29");
		Set<Integer> keys = maps.keySet();
		Iterator<Integer> iter = keys.iterator();
		while (iter.hasNext()) {
			System.out.println(maps.get(iter.next()));
		}

	}

}
