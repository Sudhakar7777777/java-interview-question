package com.sbk.easy;

import com.sbk.MeasureTime;

/**
 * Problem: https://leetcode.com/problems/palindrome-number/description/
 *
 Determine whether an integer is a palindrome. Do this without extra space.

 Example: 16461, 5, 11, 101

 Note: Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 */
public class PalindromeNumber
{
    boolean isPalindrome(int num)
    {
        if (num < 0 || (num != 0 && num % 10 == 0))
        {
            return false;
        }
        int reverse = 0, original = num;
        for (; num > 0; num /= 10)
        {
            reverse = reverse * 10 + num % 10;
        }
        return (reverse == original);
    }

    boolean isPalindromeHalf(int x)
    {
        if (x < 0 || (x != 0 && x % 10 == 0))
        {
            return false;
        }
        int halfReverseX = 0;
        while (x > halfReverseX)
        {
            halfReverseX = halfReverseX * 10 + x % 10;
            x /= 10;
        }
        return (halfReverseX == x || halfReverseX / 10 == x);
    }

    public static void main(String args[])
    {
        PalindromeNumber solution = new PalindromeNumber();
        MeasureTime iterate = new MeasureTime("Iterate method");
        MeasureTime half = new MeasureTime("Half-Iterate method");

        iterate.start();
        System.out.println("isPalindrome of [-123456] is " + solution.isPalindrome(-123456));
        System.out.println("isPalindrome of [5] is " + solution.isPalindrome(5));
        System.out.println("isPalindrome of [22] is " + solution.isPalindrome(22));
        System.out.println("isPalindrome of [121] is " + solution.isPalindrome(121));
        System.out.println("isPalindrome of [16461] is " + solution.isPalindrome(16461));
        System.out.println("isPalindrome of [12352343] is " + solution.isPalindrome(12352343));
        iterate.stop();

        half.start();
        System.out.println("isPalindrome of [-123456] is " + solution.isPalindromeHalf(-123456));
        System.out.println("isPalindrome of [5] is " + solution.isPalindromeHalf(5));
        System.out.println("isPalindrome of [22] is " + solution.isPalindromeHalf(22));
        System.out.println("isPalindrome of [121] is " + solution.isPalindromeHalf(121));
        System.out.println("isPalindrome of [16461] is " + solution.isPalindromeHalf(16461));
        System.out.println("isPalindrome of [12352343] is " + solution.isPalindromeHalf(12352343));
        half.stop();

        iterate.showBestPerformance(iterate, half);
    }
}
