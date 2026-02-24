import collections.Dictionary;
import collections.Entry;

public class Main {

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        dictionary.add("Test", 2);
        dictionary.add("test2", false);
        dictionary.add("test3", 235);
        System.out.println(dictionary.toString());

        dictionary.set("test2", true);
        System.out.println(dictionary.toString());

        /*dictionary.popItem();
        System.out.println(dictionary.toString());

        dictionary.pop("Test");
        System.out.println(dictionary.toString());

         */

        for (Entry entry : dictionary) {
            System.out.println(entry);
        }

    }
}