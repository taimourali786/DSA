public class LinkedListUtil {

    public static LinkedList mergeLinkedList(LinkedList l1, LinkedList l2) {
        LinkedListNode n1 = l1.head;
        LinkedListNode n2 = l2.head;

        if (n1 == null) {
            return new LinkedList(n2);
        } else if (n2 == null) {
            return new LinkedList(n1);
        }

        LinkedListNode newNode = new LinkedListNode();
        LinkedListNode current = newNode;

        while (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                current.next = new LinkedListNode(n1.data);
                n1 = n1.next;
            } else {
                current.next = new LinkedListNode(n2.data);
                n2 = n2.next;
            }
            current = current.next;
        }
        if (n1 != null) {
            current.next = n1;
        } else if (n2 != null) {
            current.next = n2;
        }
        return new LinkedList(newNode.next);
    }
}
