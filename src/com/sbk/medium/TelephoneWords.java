package com.sbk.medium;

import java.util.*;

public class TelephoneWords
{
    public static Map<Integer, String> wordMap = new TreeMap<>(){{put(1,""); put(2,"abc"); put(3,"def"); put(4,"ghi"); put(5,"jkl"); put(6,"mno"); put(7,"pqrs"); put(8,"tuv"); put(9,"wxyz"); put(0,"");}};

    //Arrays.asList("","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz")

    public static void main(String[] args) {
        ArrayList<Integer> phoneNumber = new ArrayList<>(Arrays.asList(4,0,8));
        printWords(phoneNumber, phoneNumber.size());
    }

    public static void printWords(ArrayList<Integer> phoneNumber, int size) {
        String aWord = new String("");
        printWordsUtil(phoneNumber, 0, aWord, size);
    }

    public static void printWordsUtil(ArrayList<Integer> phoneNumber, int currPosition, String aWord, int size) {
        if(currPosition == size) {
            System.out.println(aWord);
            return;
        }
        int number = phoneNumber.get(currPosition);
        String keyWord = wordMap.get(number);

        System.out.println("Lookup for Number : " + number);
        System.out.println("Map for Number : " + wordMap.get(number));

        for(int i=0; i < wordMap.get(number).length(); i++) {
            aWord += keyWord.charAt(i);
            printWordsUtil(phoneNumber, ++currPosition, aWord, size);
            if(number == 0 || number == 1)
                return;
        }
    }
}
