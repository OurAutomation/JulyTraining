package CollectionsImpl.listImpl;

import java.util.ArrayList;
import java.util.Collections;

public class SortingInList {
    static ArrayList<Integer> intList = new ArrayList<>();

    public static void main(String[] args) {
        intList.add(100);
        intList.add(1);
        intList.add(0);
        intList.add(100);
        intList.add(32);
        intList.add(25);
        intList.add(56);
        intList.add(13);
        intList.add(8);
        System.out.println(intList.indexOf(32));
        System.out.println(intList.get(4));
        Collections.sort(intList);
        Collections.reverse(intList);
        for (int i:intList
             ) {
            System.out.println(i);
        }
    }
}
