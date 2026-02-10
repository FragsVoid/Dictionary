import collections.Dictionary;

public class Main {

    public static void main(String[] args) {
        Dictionary<Integer, Integer> dictionary = new Dictionary<>();

        for (int i = 0; i < 21; i++) {
            dictionary.add(i, i+1);
        }

        dictionary.print();
    }
}