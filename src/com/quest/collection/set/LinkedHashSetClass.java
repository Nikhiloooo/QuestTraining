package com.quest.collection.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetClass {
    public static void main(String[] args) {
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        hashSet.add("hello");
        hashSet.add("how");
        hashSet.add("are");
        hashSet.add("you");
        hashSet.add(null);
        for (String string : hashSet) {
            System.out.println(string);
        }

        System.out.println(hashSet.remove("hello"));
        System.out.println(hashSet);
        System.out.println(hashSet.contains("how"));
        System.out.println(hashSet.isEmpty());
        System.out.println(hashSet.size());
        hashSet.clear();
        System.out.println(hashSet.isEmpty());
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
