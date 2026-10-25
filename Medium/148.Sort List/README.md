# 148. Sort List

https://leetcode.com/problems/sort-list/

Given the head of a linked list, return the list after sorting it in ascending order.

 
Example 1:

Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:

Input: head = []
Output: []

 
Constraints:

	The number of nodes in the list is in the range [0, 5 * 104].
	-105 <= Node.val <= 105

 
Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }

        ListNode dummy = new ListNode(0, head);

        for (int size = 1; size < n; size <<= 1) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;

            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, size);
                cur = split(right, size);
                prev = merge(left, right, prev);
            }
        }

        return dummy.next;
    }

    private ListNode split(ListNode start, int size) {
        if (start == null) return null;
        for (int i = 1; i < size && start.next != null; i++) {
            start = start.next;
        }
        ListNode rest = start.next;
        start.next = null;
        return rest;
    }

    private ListNode merge(ListNode l1, ListNode l2, ListNode prev) {
        ListNode cur = prev;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }
}
```
