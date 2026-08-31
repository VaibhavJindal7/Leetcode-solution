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
        TreeSet<Integer> ht = new TreeSet<>();
        ListNode temp = head.next;
        ListNode prev=head;
        int i =2;
        while(temp!=null && temp.next!=null){
            if(temp.val>prev.val && temp.val>temp.next.val) ht.add(i);
            if(temp.val<prev.val && temp.val<temp.next.val) ht.add(i);
            prev=temp;
            temp=temp.next;
            i++;
        }
        int[] arr = new int[2];
        arr[0]=-1;
        arr[1]=-1;
        if(ht.size()<2) return arr;
        int min=Integer.MAX_VALUE;
        int max =-ht.first()+ht.last();
        int p = ht.first();
        for(int x :ht){
            if(x==p) continue;
            min = Math.min(min,x-p);
            p=x;
        }
        arr[0]=min;
        arr[1]=max;
        return arr;
    }
}