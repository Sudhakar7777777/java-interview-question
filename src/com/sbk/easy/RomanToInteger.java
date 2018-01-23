package com.sbk.easy;

import com.sbk.MeasureTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: https://leetcode.com/problems/roman-to-integer/description/
 *
 Given a roman numeral, convert it to an integer.
 Input is guaranteed to be within the range from 1 to 3999.

 Example:
 Input:     XV
 Output:    15

 Assumption: Invalid string returns 0.
 *
 */

public class RomanToInteger
{
    int romanToInt(String s)
    {
        int len = s.length();
        if (len == 0)
        {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        s = s.toUpperCase();
        int result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; --i)
        {
            if (map.containsKey(s.charAt(i)))
            {
                if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
                {
                    result -= map.get(s.charAt(i));
                }
                else
                {
                    result += map.get(s.charAt(i));
                }
            }
            else
            {
                return 0;
            }
        }

        return result;
    }

    public static void main(String args[])
    {
        RomanToInteger solution = new RomanToInteger();
        MeasureTime iterate = new MeasureTime("Iterate method");

        iterate.start();
        System.out.println("Integer of Roman [X] is " + solution.romanToInt("X"));
        System.out.println("Integer of Roman [XV] is " + solution.romanToInt("XV"));
        System.out.println("Integer of Roman [CCXXii] is " + solution.romanToInt("CCXXIi"));
        System.out.println("Integer of Roman [DCXIX] is " + solution.romanToInt("DCXIX"));
        System.out.println("Integer of Roman [DCAIX] is " + solution.romanToInt("DCAIX"));
        System.out.println("Integer of Roman [] is " + solution.romanToInt(""));

        iterate.stop();

        iterate.showBestPerformance(iterate, iterate);
    }
}
