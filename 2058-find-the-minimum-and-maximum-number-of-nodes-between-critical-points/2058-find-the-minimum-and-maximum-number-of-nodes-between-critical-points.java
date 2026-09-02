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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = {-1, -1};
        if(head == null || head.next == null || head.next.next == null) return res;
        
        int minDis = Integer.MAX_VALUE;
        int first = -1;
        int last = -1;

        int ind = 1;

        ListNode prev = head;
        ListNode curr = head.next;      

        while(curr.next != null){
            ListNode n = curr.next;

            if((curr.val > prev.val && curr.val > n.val) || (curr.val < prev.val && curr.val < n.val)){
                if(first == -1) first = ind;
                else{
                    minDis = Math.min(minDis, ind - last);
                }
                last = ind;
            }

            prev = curr;
            curr = n;
            ind++;
        }  

        if(first == -1 || first == last) return res;

        res[0] = minDis;
        res[1] = last - first;

        return res;
    }
}