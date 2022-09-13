package org.training.java.CollectionsImpl.setImpl;

import java.util.HashSet;
import java.util.Set;

public class HashSetImpl {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet();
        hashSet.add("123");
        hashSet.add("123");
        hashSet.add("123");
        hashSet.add("1425");
        hashSet.add("234");
        for (String e : hashSet) {
            System.out.println(e);
        }
    }
}
