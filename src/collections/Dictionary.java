package collections;

public class Dictionary {


    private Entry[] data;
    private int size = 0;

    public Dictionary() {
        data = new Entry[10];
    }

    private Dictionary(Entry[] data) {
        this.data = data.clone();
    }

    public boolean add(Object key, Object value) {
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
            add(entry);
        }
    }

    public boolean contains(Object key) {
        for (Entry entry : data)
            if (entry.getKey().equals(key)) return true;
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
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return true;
            }
        }

        return false;
    }

    public Object[] keys() {
        Object[] keys = new Object[size];

        for (int i = 0; i < data.length; i++) {
            keys[i] = data[i].getKey();
        }
        return keys;
    }

    public Object[] items() {
        Object[] values = new Object[size];

        for (int i = 0; i < data.length; i++) {
            values[i] = data[i].getValue();
        }
        return values;
    }

    public Object pop(Object key) {
        return remove(key);
    }

    public Entry popItem() {
        Entry entry = data[size];
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


}
