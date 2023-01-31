package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        boolean rsl = false;
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            rsl = true;
            count++;
            modCount++;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private int getIndex(K key) {
        return (key == null) ? 0 : indexFor(hash(key.hashCode()));
    }

    private boolean checkElement(K key) {
        return Objects.nonNull(table[getIndex(key)]) && Objects.hashCode(key)
                == Objects.hashCode(table[getIndex(key)].key) && Objects.equals(table[getIndex(key)].key, key);
    }

    private void expand() {
        MapEntry<K, V>[] old = table;
        capacity *= 2;
        table = new MapEntry[capacity];
        for (MapEntry<K, V> entry : old) {
            if (entry != null) {
                table[getIndex(entry.key)] = entry;
            }
        }
    }

    @Override
    public V get(K key) {
        V rsl = null;
        if (checkElement(key)) {
            rsl = table[getIndex(key)].value;
        }
        return rsl;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        if (checkElement(key)) {
            table[getIndex(key)] = null;
            rsl = true;
            count--;
            modCount++;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private final int expectedModCount = modCount;
            private int point = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (point < capacity && table[point] == null) {
                    point++;
                }
                return point < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[point++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
