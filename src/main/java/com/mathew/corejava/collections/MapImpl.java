package com.mathew.corejava.collections;

import java.util.HashSet;
import java.util.Set;

public class MapImpl<K, V> {

	private MapItem<K, V>[] table;
	private int bucketSize;
	private static final int DEFAULT_BUCKET_SIZE = 10;
	private int count;

	public MapImpl() {
		bucketSize = DEFAULT_BUCKET_SIZE;
		table = new MapItem[bucketSize];
	}

	public boolean put(K key, V value) {
		int hash = key.hashCode();
		int index = hash % bucketSize;
		MapItem<K, V> anItem = table[index];
		if (anItem == null) {
			anItem = new MapItem<K, V>(hash, key, value, null);
			table[index] = anItem;
		} else {
			MapItem<K, V> mapItem = anItem;
			while (mapItem != null) {
				if (mapItem.hash == key.hashCode() && mapItem.key.equals(key)) {
					mapItem.value = value;
					return true;
				}
				mapItem = mapItem.getNext();
			}
			MapItem<K, V> newItem = new MapItem<K, V>(hash, key, value, null);
			anItem.next = newItem;
		}
		count++;
		return true;
	}

	public V get(K key) {
		int hash = key.hashCode();
		int index = hash % bucketSize;
		MapItem<K, V> anItem = table[index];
		if (anItem == null) {
			return null;
		}
		MapItem<K, V> mapItem = anItem;
		while (mapItem != null) {
			if (mapItem.hash == key.hashCode() && mapItem.key.equals(key)) {
				return mapItem.value;
			}
			mapItem = mapItem.getNext();
		}
		return null;
	}

	public boolean remove(K key) {
		int hash = key.hashCode();
		int index = hash % bucketSize;
		MapItem<K, V> head = table[index];
		if (head == null) {
			return false;
		}
		MapItem<K, V> previous = null;
		while (head != null) {
			if (head.hash == key.hashCode() && head.key.equals(key)) {
				break;
			}
			previous = head;
			head = head.getNext();
		}
		if (previous == null) {
			table[index] = previous;
		} else {
			previous.next = head.next;
		}
		return true;
	}

	public Set<K> keySet() {
		Set<K> keys = new HashSet<K>();
		for (int ii = 0; ii < bucketSize; ii++) {
			MapItem<K, V> mapItem = table[ii];
			while (mapItem != null) {
				keys.add(mapItem.key);
				mapItem = mapItem.getNext();
			}
		}
		return keys;
	}

	public Set<V> valueSet() {
		Set<V> values = new HashSet<V>();
		for (int ii = 0; ii < bucketSize; ii++) {
			MapItem<K, V> mapItem = table[ii];
			while (mapItem != null) {
				values.add(mapItem.value);
				mapItem = mapItem.getNext();
			}
		}
		return values;
	}

	public static void main(String[] args) {
		MapImpl<Integer, String> map = new MapImpl<Integer, String>();
		map.put(1, "ONE");
		System.out.println(map.get(1));
		System.out.println(map.remove(1));
		System.out.println(map.remove(1));
	}

}

class MapItem<K, V> {

	int hash;
	K key;
	V value;
	MapItem<K, V> next;

	public MapItem(int h, K k, V v, MapItem<K, V> n) {
		hash = h;
		key = k;
		value = v;
		next = n;
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public MapItem<K, V> getNext() {
		return next;
	}

	public void setNext(MapItem<K, V> next) {
		this.next = next;
	}
}
