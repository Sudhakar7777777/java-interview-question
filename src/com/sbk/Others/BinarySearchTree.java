package com.sbk.Others;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Good reference doc: https://algs4.cs.princeton.edu/32bst/
 */

public class BinarySearchTree<Key extends Comparable<Key>, Value>
{
    private Node root;

    private class Node
    {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key k, Value v)
        {
            key = k;
            value = v;
            left = right = null;
        }
    }

    private Value get(Key k)
    {
        Node x = root;
        while ( x != null)
        {
            int cmp = k.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }
        return null;
    }

    public void put(Key k, Value v)
    {
        root = put(root, k, v);
    }

    private Node put(Node x, Key k, Value v)
    {
        if (x == null) return new Node(k,v);

        int cmp = k.compareTo(x.key);

        if (cmp < 0) x.left = put(x.left, k, v);
        else if (cmp > 0) x.right = put(x.right, k, v);
        else x.value = v;
        return x;
    }

    public void delete(Key k)
    {
        root = delete(root, k);
    }

    private Node delete(Node x, Key k)
    {
        if (x == null) return null;

        int cmp = k.compareTo(x.key);

        if (cmp < 0) x.left = delete(x.left, k);
        else if (cmp > 0) x.right = delete(x.right, k);
        else    // match found
        {
            //case1: no child
            //case2: 1 child
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            //case3: 2 child
            Node t = x;
            x = min(t.right);
            x.left = t.left;
            x.right = deleteMin(t.right);
        }
        return x;
    }

    public void deleteMin()
    {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x)
    {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public Node min()
    {
        return min(root);
    }

    private Node min(Node x)
    {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    public Iterable<Key> iterator()
    {
        Queue<Key> q = new LinkedList<>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, Queue<Key> q)
    {
        if (x == null) return;

        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }

    public static void main(String args[])
    {
        BinarySearchTree<Integer, String> myTree = new BinarySearchTree<>();
        myTree.put(1, "one");
        myTree.put(22, "two");
        myTree.put(3, "three");
        myTree.put(444, "four");
        myTree.put(55, "five");
        myTree.put(6, "six");
        myTree.put(77, "seven");
        myTree.put(8888, "eight");
        myTree.put(999999, "nine");
        myTree.put(0, "ten");

        for (int i : myTree.iterator())
            System.out.println(i + " " + myTree.get(i));

        System.out.println("Minimum node is :" + myTree.min().key);
        System.out.println("Is my Tree empty? " + myTree.isEmpty());

        System.out.println("Deleting min node");
        myTree.deleteMin();
        System.out.println("Current Minimum node is :" + myTree.min().key);

        System.out.println("Deleting node = 55");
        myTree.delete(55);

        for (int i : myTree.iterator())
            System.out.println(i + " " + myTree.get(i));
    }
}
