package com.sbk.easy;

import com.sbk.MeasureTime;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem: https://leetcode.com/problems/two-sum/description/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 *  Example:
 *  Given nums = [2, 7, 11, 15], target = 9,
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 *
 */
public class TwoSum
{
    public int[] twoSum(int[] nums, int target)
    {
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i+1; j < nums.length; j++)
            {
                if( nums[i] + nums[j] == target)
                    return new int[]{i,j};
                // add this optimization check, if assumption includes Array of numbers is always sorted
                // if( nums[i] + nums[j] > target ) return null;
            }
        }
        return null;
    }

    public int[] twoSumHash(int[] nums, int target)
    {
        // Beware this method consumes Memory, contrary to above solution
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]), i};
            map.put( (target - nums[i]), i);
        }
        return null;
    }

    public static void main(String args[])
    {
        TwoSum solution = new TwoSum();
        int[] numbers = new int[]{2, 7, 11, 15};

        MeasureTime iter = new MeasureTime("Iteration method");
        MeasureTime hash = new MeasureTime("HashMap method");

        System.out.println("Sum of 2 integers Problem:");

        iter.start();
        System.out.println("Output for Target 5 is " + Arrays.toString(solution.twoSum(numbers, 5)));
        System.out.println("Output for Target 9 is " + Arrays.toString(solution.twoSum(numbers, 9)));
        System.out.println("Output for Target 17 is " + Arrays.toString(solution.twoSum(numbers, 17)));
        iter.stop();

        hash.start();
        System.out.println("Output for Target 5 is " + Arrays.toString(solution.twoSumHash(numbers, 5)));
        System.out.println("Output for Target 9 is " + Arrays.toString(solution.twoSumHash(numbers, 9)));
        System.out.println("Output for Target 17 is " + Arrays.toString(solution.twoSumHash(numbers, 17)));
        hash.stop();

        iter.showBestPerformance(iter, hash);
    }
}
