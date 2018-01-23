package com.sbk.medium;

import com.sbk.helper.ListNode;

/**
 * Problem: https://leetcode.com/problems/add-two-numbers
 *
 You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.  Single digits only.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 *
 */

public class AddTwoNumbers
{
    ListNode addTwoNumbers(ListNode first, ListNode second)
    {
        ListNode result = new ListNode(0);
        ListNode f = first, s = second, r = result;
        int sum = 0;
        while(f != null && s != null)
        {
            sum /= 10;

            if (f != null) {
                sum += f.val;
                f = f.next;
            }
            if (s != null) {
                sum += s.val;
                s = s.next;
            }
            r.next = new ListNode(sum % 10);
            r = r.next;
        }
        if (sum / 10 != 0) r.next = new ListNode(1);
        return result.next;
    }

    public static void main (String[] args)
    {
        AddTwoNumbers numbers = new AddTwoNumbers();
        ListNode.print(numbers.addTwoNumbers(
                ListNode.createTestData("[2,4,3]"),
                ListNode.createTestData("[5,6,4]")
        ));
    }
}
