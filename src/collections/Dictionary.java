package collections;


import java.util.Arrays;

public class Dictionary<T, K> {

    private Node<T, K>[] data;
    private int size;
    
    private Node<T, K> firstNode = null;
    
    public Dictionary() {
        data = new Node[10];
        size = 0;
    }
    
    public int len() {
        return size;
    }
    
    public void add(T key, K value) {
        Node<T,K> node = new Node<>(key, value);
        if (firstNode == null)
            firstNode = node;
        
        if (data.length <= this.size) {
            Node<T,K>[] copied = data.clone();
            int nextSize = size + 10;
            data = new Node[nextSize];

            for (int i = 0; i < copied.length; i++) {
                data[i] = copied[i];
            }
        }

        data[size] = new Node<>(key, value);
        size++;
    }

    public K remove(T key) {
        for (Node<T, K> node : data) {
            if (node.getKey().equals(key)) {
                //Remove
            }
        }

        return null;
    }

    public void print() {
        System.out.println(Arrays.toString(data));
    }
}
