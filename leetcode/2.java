/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
		ListNode start = res;
       	do {
			int t = l1.val + l2.val;
			boolean created = false;
            l1 = l1.next; l2 = l2.next;
            if(res.val + t >= 10) {
                res.val = (res.val + t) % 10;
				created = true;
                res.next = new ListNode(1);
            } else {
				res.val += t;
			}
            if(l1 == null && l2 == null) break;
            if(!(l1 != null && l2 != null)) {
                if(!created) res.next = new ListNode(0);
            	res = res.next;
				break;
            }
            if(!created) res.next = new ListNode(0);
            res = res.next;
        } while(l1 != null && l2 != null);
		if(l1 != null) {
			while(l1 != null) {
				boolean created = false;
				if(res.val + l1.val >= 10){
					res.val = (res.val + l1.val) % 10;
					created = true;
					res.next = new ListNode(1);
				} else {
					res.val += l1.val;
				}
				l1 = l1.next;
				if(l1 == null) break;
				if(!created) res.next = new ListNode(0);
				res = res.next;
			}
		}
		if(l2 != null) {
			while(l2 != null) {
				boolean created = false;
				if(res.val + l2.val >= 10){
					res.val = (res.val + l2.val) % 10;
					created = true;
					res.next = new ListNode(1);
				} else {
					res.val += l2.val;
				}
				l2 = l2.next;
				if(l2 == null) break;
				if(!created) res.next = new ListNode(0);
				res = res.next;
			}
		}
		return start;
    }
}
