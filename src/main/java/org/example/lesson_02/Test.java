package org.example.lesson_02;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        System.out.println("Task #1:");
        System.out.println();
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("F");
        linkedList.add("B");
        linkedList.add("D");
        linkedList.add("Е");
        linkedList.add("C");
        linkedList.addLast("Z");
        linkedList.addFirst("A");
        linkedList.add(1, "А2");
        System.out.println("1. linkedList: " + linkedList);
        linkedList.remove("F");
        linkedList.remove(2);
        System.out.println("2. linkedList: " + linkedList);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("3. linkedList: " + linkedList);
        String val = linkedList.get(2);
        linkedList.set(2, val + " изменено");
        System.out.println("4. linkedList: " + linkedList);


        System.out.println();
        System.out.println();
        System.out.println("Task #2:");
        System.out.println();
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.trimToSize();
        arrayList.add(1, "А0");
        System.out.println(arrayList);
        arrayList.remove("E");
        arrayList.remove(2);
        System.out.println(arrayList);
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        System.out.println(toString(arr));
    }

    public static String toString(Integer[] arr) {
        String s = "";
        for (Integer integer : arr) {
            s = s.concat(integer.toString()).concat(", ");
        }
        return (s.length()>1)?"[".concat(s.substring(0, s.length() - 2)).concat("]"):"[]";
    }


}
