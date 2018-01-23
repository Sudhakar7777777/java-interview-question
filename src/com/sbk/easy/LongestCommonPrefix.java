package com.sbk.easy;

import com.sbk.MeasureTime;

/**
 * Problem: https://leetcode.com/problems/longest-common-prefix/description/
 *
 Write a function to find the longest common prefix string amongst an array of strings.

 Example :
 Input:     {"abc", "abcd", "ab"}
 Output:    "ab"

 Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
 Output : "gee"

 Note: https://leetcode.com/articles/longest-common-prefix/
 *
 */

public class LongestCommonPrefix
{
    public String getLongestCommonPrefixHorizontal(String[] strs)
    {
        if (strs.length == 0)
        {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
        {
            while (strs[i].indexOf(prefix) != 0)
            {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                {
                    return "";
                }
            }
        }
        return prefix;
    }

    String getLongestCommonPrefixVertical(String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++)
        {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++)
            {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public String getLongestCommonPrefixDivideNConquer(String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r)
    {
        if (l == r)
        {
            return strs[l];
        }
        else
        {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private String commonPrefix(String left, String right)
    {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++)
        {
            if (left.charAt(i) != right.charAt(i))
            {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    public String getLongestCommonPrefixBinarySearch(String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
        {
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;
        while (low <= high)
        {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
            {
                low = middle + 1;
            }
            else
            {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len)
    {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
        {
            if (!strs[i].startsWith(str1))
            {
                return false;
            }
        }
        return true;
    }

    public String getLongestCommonPrefixTrie(String q, String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return "";
        }
        if (strs.length == 1)
        {
            return strs[0];
        }
        Trie trie = new Trie();
        for (int i = 1; i < strs.length; i++)
        {
            trie.insert(strs[i]);
        }
        return trie.searchLongestPrefix(q);
    }

    class TrieNode
    {

        private final int R = 26;
        // R links to node children
        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        // number of children non null links
        private int size;

        public int getLinks()
        {
            return size;
        }

        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }
        public TrieNode get(char ch) {
            return links[ch -'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch -'a'] = node;
            size++;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }

    public class Trie
    {

        private TrieNode root;

        public Trie()
        {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        // search a prefix or whole key in trie and
        // returns the node where search ends
        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter)) {
                    node = node.get(curLetter);
                } else {
                    return null;
                }
            }
            return node;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        private String searchLongestPrefix(String word)
        {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < word.length(); i++)
            {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter) && (node.getLinks() == 1) && (!node.isEnd()))
                {
                    prefix.append(curLetter);
                    node = node.get(curLetter);
                }
                else
                {
                    return prefix.toString();
                }

            }
            return prefix.toString();
        }
    }

    public static void main(String args[])
    {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        
        String[] data1 = new String[]{"abc", "abcd", "ab"};
        String[] data2 = new String[]{"monterrey", "monteolivos", "montgomery", "montreal","montar"};
        String[] data3 = new String[]{"def", "default", "ab"};
        
        MeasureTime horizontal = new MeasureTime("Horizontal method");

        horizontal.start();
        System.out.println("Longest Common Prefix of {"+data1+"} is " + solution.getLongestCommonPrefixHorizontal(data1));
        System.out.println("Longest Common Prefix of {"+data2+"} is " + solution.getLongestCommonPrefixHorizontal(data2));
        System.out.println("Longest Common Prefix of {"+data3+"} is " + solution.getLongestCommonPrefixHorizontal(data3));
        horizontal.stop();

        MeasureTime vertical = new MeasureTime("Vertical method");

        vertical.start();
        System.out.println("Longest Common Prefix of {"+data1+"} is " + solution.getLongestCommonPrefixVertical(data1));
        System.out.println("Longest Common Prefix of {"+data2+"} is " + solution.getLongestCommonPrefixVertical(data2));
        System.out.println("Longest Common Prefix of {"+data3+"} is " + solution.getLongestCommonPrefixVertical(data3));
        vertical.stop();

        MeasureTime divide = new MeasureTime("Divide n Conquer method");

        divide.start();
        System.out.println("Longest Common Prefix of {"+data1+"} is " + solution.getLongestCommonPrefixDivideNConquer(data1));
        System.out.println("Longest Common Prefix of {"+data2+"} is " + solution.getLongestCommonPrefixDivideNConquer(data2));
        System.out.println("Longest Common Prefix of {"+data3+"} is " + solution.getLongestCommonPrefixDivideNConquer(data3));
        divide.stop();

        MeasureTime binary = new MeasureTime("Binary Search method");

        binary.start();
        System.out.println("Longest Common Prefix of {"+data1+"} is " + solution.getLongestCommonPrefixBinarySearch(data1));
        System.out.println("Longest Common Prefix of {"+data2+"} is " + solution.getLongestCommonPrefixBinarySearch(data2));
        System.out.println("Longest Common Prefix of {"+data3+"} is " + solution.getLongestCommonPrefixBinarySearch(data3));
        binary.stop();

        MeasureTime trie = new MeasureTime("Trie method");

        trie.start();
        System.out.println("Longest Common Prefix of {"+data1+"} is " + solution.getLongestCommonPrefixTrie(data1[0], data1));
        System.out.println("Longest Common Prefix of {"+data2+"} is " + solution.getLongestCommonPrefixTrie(data2[0], data2));
        System.out.println("Longest Common Prefix of {"+data3+"} is " + solution.getLongestCommonPrefixTrie(data3[0], data3));
        trie.stop();

        horizontal.showBestPerformance(divide, binary);
    }
}
