package com.ontic;

import java.util.Scanner;

class LinkedList {

    int key, value;

    LinkedList next;

    public LinkedList(int key, int value) {

        this.key = key;
        this.value = value;
        this.next = next;
    }
}

class HashMap {

    static int size_of_list = 1000;
    static long multiply = 1258;

    LinkedList[] data;

    public HashMap() {

        data = new LinkedList[2000];
    }

    private int hashGenerate(int key) {

        int hash_value = (int)((long)key * multiply % size_of_list);

        return hash_value;
    }

    public int getValue(int key) {

        int hash_value = hashGenerate(key);
        LinkedList node = data[hash_value];
        //System.out.println("this is node value we are searching "+ node);
        //System.out.println("this is hashvalue of the key " + hash_value);

        while (node != null) {

            //System.out.println(node.key + "inside while");

            if (node.key == hash_value)
                return node.value;

            node = node.next;
        }

        return -1;
    }

    public void putValue(int key, int value) {

        if(check(key) == 1) {

            int hash_value = hashGenerate((key));
            LinkedList node = new LinkedList(hash_value, value);
            data[hash_value] = node;
        }

        else {

            System.out.println("key already present with value " + check(key));
        }

    }

    public void removeKey(int key) {

        int hash_value = hashGenerate(key);
        LinkedList node = data[hash_value];

        if(node == null) {

            System.out.println("key not exists");
            return;
        }

        if (node.key == hash_value) {

            data[hash_value] = node.next;
            System.out.println("key removed");
        }

        else {
            for (; node.next != null; node = node.next) {
                if (node.next.key == key) {
                    node.next = node.next.next;

                    System.out.println("key removed");

                    return;
                }
            }
        }

    }


    public int check(int key) {

        int hash_value = hashGenerate(key);

        //System.out.println("this is hash value "+ hash_value);

        LinkedList node = data[hash_value];

        //System.out.println("this is data "+ hash_value);

        if (node == null)
            return 1;

        else {

            while (node.next != null) {
                if (node.key == hash_value) {
                    return node.value;
                }

                node = node.next;
            }
        }

        return 1;
    }

}
public class Main {

    public static void main(String[] args) {

        int op;

        HashMap map = new HashMap();
        //LinkedList ll= new LinkedList();
        /*

        0: exit
        1: put
        2: get
        3: remove

         */

        while(true)
        {
            int key, value;

            Scanner s = new Scanner(System.in);

            op = s.nextInt();

            if(op == 0)
                break;

            else if(op == 1) {

                key = s.nextInt();

                value = s.nextInt();
                map.putValue(key, value);

                System.out.println("successfully inserted");
            }

            else if(op == 2) {

                key = s.nextInt();

                if(map.getValue(key) == -1)
                    System.out.println("key not exists");

                else
                    System.out.println("the value is " + map.getValue(key));
            }

            else if(op == 3) {

                key = s.nextInt();

                map.removeKey(key);
            }

        }
    }
}