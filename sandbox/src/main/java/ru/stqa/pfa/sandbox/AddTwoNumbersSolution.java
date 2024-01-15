package ru.stqa.pfa.sandbox;

public class AddTwoNumbersSolution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode l4 = l3;
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0) {
            int d1 = (l1  != null) ? l1.val : 0;
            int d2 = (l2  != null) ? l2.val : 0;

            int sum = d1 + d2 + temp;
            int d = sum % 10;
            temp = sum / 10;

            ListNode l5 = new ListNode(d);
            l4.next = l5;
            l4 = l4.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        ListNode result = l3.next;
        l3.next = null;
        return result;
    }
}
