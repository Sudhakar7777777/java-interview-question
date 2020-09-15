package com.sbk.Others;

import java.util.HashMap;
import java.util.Map;

/*
	char firstNonRepeatingChar(String s);

	Method to take an input String and return the first char which is non-repeating one.
	Eg:	Assume input string is a valid string with size >= 1 and is all lower case letters, no digits or special chars.
		"aaabcccdeeef" ==> 'b'
		"abcbad" ==> 'c'
		"abcabcabc" ==> '_'
 */
public class FirstNonRepeatingChar {

	public static char firstNonRepeatingChar(String s) {
		Map<Character, Integer> charMap = new HashMap<>();
		for(int i=0; i<s.length(); i++) {
			if(charMap.containsKey(s.charAt(i))) {
				charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
			} else {
				charMap.put(s.charAt(i), 1);
			}
		}
		System.out.println("DEBUG: charMap : " + charMap);
		for(int i=0; i<s.length(); i++) {
			if(charMap.get(s.charAt(i)) == 1) {
				return s.charAt(i);
			}
		}
		return '_';
	}

	public static char firstNonRepeatingChar2(String s) {
		int[] charCount = new int[26];
		for(char c : s.toCharArray()) {
			charCount[c - 'a']++;
		}
		for(char c : s.toCharArray()) {
			if(charCount[c - 'a'] == 1) return c;
		}
		return '_';
	}

	public static void main(String[] args) {
		System.out.println("Solution 1");
		System.out.println("Testcase 1: " + firstNonRepeatingChar("aaabcccdeeef"));
		System.out.println("Testcase 2: " + firstNonRepeatingChar("abcbad"));
		System.out.println("Testcase 3: " + firstNonRepeatingChar("abcabcabc"));
		System.out.println("Testcase 4: " + firstNonRepeatingChar(""));
		System.out.println("Solution 2");
		System.out.println("Testcase 1: " + firstNonRepeatingChar2("aaabcccdeeef"));
		System.out.println("Testcase 2: " + firstNonRepeatingChar2("abcbad"));
		System.out.println("Testcase 3: " + firstNonRepeatingChar2("abcabcabc"));
		System.out.println("Testcase 4: " + firstNonRepeatingChar2(""));
	}
}
