package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void insert(int key, int value) {
        Node newNode = new Node(key, value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void delete(int key) {
        if (head == null) {
            return;
        }

        if (head.key == key) {
            head = head.next;
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

class Hashing {
    private List<LinkedList> bucketArray;
    private int numBuckets;

    public Hashing(int numBuckets) {
        this.numBuckets = numBuckets;
        bucketArray = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(new LinkedList());
        }
    }

    private int hashFunction(int key) {
        return key % numBuckets;
    }

    public void put(int key, int value) {
        int index = hashFunction(key);
        bucketArray.get(index).insert(key, value);
    }

    public int get(int key) {
        int index = hashFunction(key);
        return bucketArray.get(index).get(key);
    }

    public void remove(int key) {
        int index = hashFunction(key);
        bucketArray.get(index).delete(key);
    }
}


public class HashCollision {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap(10);

        hashMap.put(1, "Apple");
        hashMap.put(2, "Banana");
        hashMap.put(3, "Orange");
        hashMap.put(11, "Kiwi");
        hashMap.put(12, "Strawberry");

        System.out.println("Value for key 1: " + hashMap.get(1));
        System.out.println("Value for key 11: " + hashMap.get(11));

        System.out.println();
        System.out.println("Value for key 2 Before deletion: " + hashMap.get(2));
        System.out.println("Value for key 12 Before deletion: " + hashMap.get(12));

        hashMap.remove(2);
        hashMap.remove(12);

        System.out.println("Value for key 2 after deletion: " + hashMap.get(2));
        System.out.println("Value for key 12 after deletion: " + hashMap.get(12));
    }
}


