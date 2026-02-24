package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Dictionary implements Iterable<Entry> {


    private Entry[] data;
    private int size = 0;

    public Dictionary() {
        data = new Entry[10];
    }

    private Dictionary(Entry[] data) {
        this.data = data.clone();
    }

    public boolean add(Object key, Object value) {
        if (get(key) != null)
            return false;
        if (size >= data.length) {
            Entry[] cloned = data.clone();
            data = new Entry[size + 20];

            System.arraycopy(cloned, 0, data, 0, cloned.length);
        }


        data[size] = new Entry(key, value);
        size++;
        return true;
    }

    public boolean add(Entry entry) {
        return add(entry.getKey(), entry.getValue());
    }

    public Object remove(Object key) {
        for (int i = 0; i < size; i++) {
            if (data[i].getKey().equals(key)) {
                int numMoved = size - i - 1;
                Object object = data[i].getValue();

                if (numMoved > 0) {
                    System.arraycopy(data, i + 1, data, i, numMoved);
                }

                data[size] = null;
                size--;


                return object;
            }
        }
        return null;
    }


    public void update(Dictionary dictionary) {
        int nextSize = dictionary.len() + this.len();
        if (nextSize >= data.length) {
            Entry[] cloned = data.clone();
            data = new Entry[nextSize + 20];
            System.arraycopy(cloned, 0, data, 0, cloned.length);
        }

        for (Entry entry : dictionary.data) {
            if (entry == null) continue;
            add(entry);
        }
    }

    public boolean contains(Object key) {
        for (Entry entry : data) {
            if (entry == null) continue;
            if (entry.getKey().equals(key)) return true;
        }
        return false;
    }

    public boolean in(Object key) {
        return contains(key);
    }

    public int len() {
        return size;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        for (Entry entry : data) {
            if (entry == null) continue;
            if (entry.getKey().equals(key))
                return entry.getValue();
        }
        return null;
    }

    public boolean set(Object key, Object value) {
        if (get(key) == null) {
            add(key, value);
            return true;
        }

        for (Entry entry : data) {
            if (entry == null) continue;
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return true;
            }
        }

        return false;
    }

    public Object[] keys() {
        Object[] keys = new Object[size];

        for (int i = 0; i < size; i++) {
            keys[i] = data[i].getKey();
        }
        return keys;
    }

    public Object[] items() {
        Object[] values = new Object[size];

        for (int i = 0; i < size; i++) {
            values[i] = data[i].getValue();
        }
        return values;
    }

    public Object pop(Object key) {
        return remove(key);
    }

    public Entry popItem() {
        Entry entry = data[size-1];
        pop(entry.getKey());
        return entry;
    }

    public void clear() {
        data = new Entry[10];
    }

    public Object setDefault(Object key, Object def) {
        Object value = get(key);
        if (value == null) return null;
        if (def == null) {
            return value;
        }
        set(key, def);
        return def;
    }

    public Dictionary copy() {
        return new Dictionary(data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < len(); i++) {
            Entry entry = data[i];
            sb.append(entry.toString());
            if (i != size-1)
                sb.append(", ");
        }
        sb.append("}");

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dictionary dictionary) {
            if (dictionary.len() == this.len()) {
                for (Entry entry : this.data) {
                    Object otherValue = dictionary.get(entry.getKey());
                    if (!entry.getValue().equals(otherValue)) return false;
                }
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<Entry> iterator() {
        return new Iterator<Entry>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public Entry next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No hay más elementos en el diccionario");
                }
                return data[currentIndex++];
            }
        };
    }
}
