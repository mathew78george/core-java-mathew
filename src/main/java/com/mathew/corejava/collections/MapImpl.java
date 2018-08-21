package com.mathew.corejava.collections;

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
			}
			MapItem<K, V> newItem = new MapItem(hash, key, value, null);
			anItem.next = newItem;
		}
		count++;
		return true;
	}
	
	public static void main(String[] args) {
		MapImpl <Integer, String> map = new MapImpl<Integer, String>();
		map.put(1, "ONE");
		map.put(2, "TW0");
		map.put(3, "THREE");
		map.put(1, "FOUR");
		System.out.println("Done");
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
