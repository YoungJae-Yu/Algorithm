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