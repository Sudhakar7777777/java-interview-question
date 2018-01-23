package com.sbk.easy;

import com.sbk.MeasureTime;

/**
 * Problem: https://leetcode.com/problems/reverse-integer
 *
 Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:
 Input: 123
 Output:  321

 Example 2:
 Input: -123
 Output: -321

 Example 3:
 Input: 120
 Output: 21

 Note: Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 */

public class ReverseInteger
{
    int reverse(int input)
    {
        long output = 0;
        for( ; input > 0; input /= 10)
        {
            output = output * 10 + input % 10;
        }

        return ( output > Integer.MAX_VALUE || output < Integer.MIN_VALUE ? 0 : (int) output );
    }

    public static void main(String args[])
    {
        ReverseInteger solution = new ReverseInteger();
        MeasureTime iterate = new MeasureTime("Iterate method");

        iterate.start();
        System.out.println("Reverse of [-123456] is " + solution.reverse(-123456));
        System.out.println("Reverse of [123456] is " + solution.reverse(123456));
        System.out.println("Reverse of [120120] is " + solution.reverse(120120));
        System.out.println("Reverse of [0] is " + solution.reverse(0));
        System.out.println("Reverse of [2145678909] is " + solution.reverse(2145678909));
        System.out.println("Reverse of [-2145678997] is " + solution.reverse(-2145678997));
        iterate.stop();

        iterate.showBestPerformance(iterate, iterate);
    }
}
