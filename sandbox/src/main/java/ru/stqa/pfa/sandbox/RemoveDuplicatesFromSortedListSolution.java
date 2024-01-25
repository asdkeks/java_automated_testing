package ru.stqa.pfa.sandbox;

public class RemoveDuplicatesFromSortedListSolution {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = l1;
        while (head != null){
            if (head.next == null) {
                ListNode l3 = new ListNode(head.val);
                l2.next = l3;
                l2 = l2.next;
                break;
            }
            if (head.val != head.next.val) {
                ListNode l3 = new ListNode(head.val);
                l2.next = l3;
                l2 = l2.next;
            }
            head = head.next;
        }
        ListNode result = l1.next;
        l1.next = null;
        return result;
    }
}
