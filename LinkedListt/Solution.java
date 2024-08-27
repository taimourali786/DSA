public class Solution {

    public static void main(String[] args) {
        LinkedList l = LinkedList.fromArray(new int[]{1,2,3});
        LinkedList l2 = LinkedList.fromArray(new int[]{1,2,3});
        // l.printList();
        // System.out.println(l.length());
        // int[] arr = l.toArray();
        // for(int i = 0; i< arr.length ; i++){
        //     System.out.println(arr[i]);
        // }

        // l.insertAtIndex(10, 3);
        // l.removeAtEnd();
        // l.removeAtIndex(0);
        // l.printList();
        // Integer s = l.getIndex(1);
        LinkedList list = LinkedListUtil.mergeLinkedList(l, l2);
        list.printList();

    }
}
