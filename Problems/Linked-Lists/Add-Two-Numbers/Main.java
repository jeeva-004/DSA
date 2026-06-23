class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while(l1!=null||l2!=null||carry!=0){
            int sum = carry;

            if(l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }

            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }

            System.out.print(sum%10+" ");

            carry = sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;
        }

        return dummyHead.next;
            
    }

}

public class Main {
    public static void main(String[] args) {
        ListNode nodes1 = new ListNode(2);
        ListNode nodes2 = new ListNode(5);
        int[] arr1 = {4,3}, arr2 = {6,4};
        ListNode temp1 = nodes1;
        ListNode temp2 = nodes2;
        for(int i: arr1){
            ListNode n = new ListNode(i, null);
                temp1.next = n;
                temp1 = temp1.next;
        }

        for(int j: arr2){
            ListNode n = new ListNode(j, null);
                temp2.next = n;
                temp2 = temp2.next;
        }    
        ListNode res = ListNode.addTwoNumbers(nodes1, nodes2);
        
        
    }
}