public class DLinkedList {

    public DLinkedListNode head;

    public DLinkedList() {
        this.head = null;
    }

    public DLinkedList(final DLinkedListNode head) {
        this.head = head;
    }

    public static DLinkedList fromArray(int[] arr) {
        DLinkedListNode head = new DLinkedListNode();
        DLinkedListNode current = head;
        DLinkedListNode prev = null;
        for(int i : arr){
            DLinkedListNode newNode = new DLinkedListNode(i);
            current.next = newNode;
            current.prev = prev;
            prev =  newNode;
            current = current.next;
        }
        return new DLinkedList(head.next);
    }


    public int length() {
        int l = 0;
        DLinkedListNode current = this.head;
        while (current != null) {
            l++;
            current = current.next;
        }
        return l;
    }

    public void printList() {
        DLinkedListNode current = this.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
