package ru.stqa.pfa.sandbox;

public class MergeTwoSortedListsSolution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l3 = new ListNode(0);
        ListNode l4 = l3;
        while (list1 != null || list2 != null){
            if (list1 == null) {
                ListNode l5 = new ListNode(list2.val);
                l4.next = l5;
                l4 = l4.next;
                list2 = (list2 != null) ? list2.next : null;
            } else if (list2 == null) {
                ListNode l5 = new ListNode(list1.val);
                l4.next = l5;
                l4 = l4.next;
                list1 = (list1 != null) ? list1.next : null;
            } else {
                if (list1.val > list2.val){
                    ListNode l5 = new ListNode(list2.val);
                    l4.next = l5;
                    l4 = l4.next;
                    list2 = (list2 != null) ? list2.next : null;
                } else if (list1.val < list2.val) {
                    ListNode l5 = new ListNode(list1.val);
                    l4.next = l5;
                    l4 = l4.next;
                    list1 = (list1 != null) ? list1.next : null;
                } else{
                    ListNode l5 = new ListNode(list1.val);
                    l4.next = l5;
                    l4 = l4.next;
                    l5 = new ListNode(list2.val);
                    l4.next = l5;
                    l4 = l4.next;
                    list1 = (list1 != null) ? list1.next : null;
                    list2 = (list2 != null) ? list2.next : null;
                }
            }
        }
        ListNode result = l3.next;
        l3.next = null;
        return result;
    }
}
