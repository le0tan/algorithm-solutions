/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode t = head;
    ListNode tt = head;
    for(int i=0;i<n;i++) {
      t=t.next;
    }
    if(t==null) {
      head=head.next;
      return head;
    }
    while(t.next!=null) {
      t=t.next;
      tt=tt.next;
    }
    tt.next=tt.next.next;
    return head;
  }
}