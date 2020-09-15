package com.sbk.Others;

/*
	Needle in the haystack problem.  Solution more like linux grep command.

	List<Integer> grep(String haystack, String needle)
	hayStack = "abadbabcajsjbabcks"
	needle = "abc"

	Response ==> [5, 13]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NeedleInHaystack {

	public static Boolean subStringCompare(String s1, String s2, int index1) {
//		System.out.println("DEBUG: subStringCompare(" + s1 + "," + s2 + "," + index1 + ")");
		for(int i = 0; i < s2.length();) {
			if(s1.charAt(index1++) != s2.charAt(i++))
				return false;
		}
		return true;
	}

	public static List<Integer> grep(String hayStack, String needle) {
		List<Integer> matches = new ArrayList<>();

		if(null == hayStack || null == needle || "".equals(hayStack) || "".equals(needle)) {
			System.out.println("ERROR: Null arguments not allowed");
			return matches;
		}
		if(needle.length() > hayStack.length()) {
			System.out.println("ERROR: Needle size greater than HayStack.");
			return matches;
		}

		for(int i = 0; i < hayStack.length() - needle.length(); i++) {
//			System.out.println("DEBUG: Comparing : " + hayStack.charAt(i) + ":" + needle.charAt(1));
			if(hayStack.charAt(i) == needle.charAt(0)) {
				if(subStringCompare(hayStack, needle, i)) {
					matches.add(i);
				}
			}
		}
		return matches;
	}

	public static void main(String[] args) {
		System.out.println("Testcase 1 : " + grep("abadbabcajsjbabcks", "axe"));
		System.out.println("Testcase 2 : " + grep("abadbabcajsjbabcks", "abc"));
		System.out.println("Testcase 3 : " + grep("abc", "abadbabcajsjbabcks"));
		System.out.println("Testcase 4 : " + grep("", "abc"));
		System.out.println("Testcase 5 : " + grep("abc", ""));
	}
}
