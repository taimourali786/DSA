// Complexity
//       Worst case	Average Case
// Search	O(n)	O(n)
// Insert	O(1)	O(1)
// Deletion	O(1)	O(1)

public class DLinkedList {

    public DLinkedListNode head;

    public DLinkedList() {
        this.head = null;
    }

    public DLinkedList(final DLinkedListNode head) {
        this.head = head;
    }

    // O(n)
    public Integer getIndex(int index) {
        DLinkedListNode current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // O(1)
    public void insertAtStart(int data) {
        DLinkedListNode node = new DLinkedListNode(data);
        node.next = head;
        head.prev = node;
        head = node;
    }

    // O(n)
    public void insertAtEnd(int data) {
        DLinkedListNode node = new DLinkedListNode(data);
        DLinkedListNode current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        node.next = null;
        node.prev = current;
    }

    // O(n)
    public void insertAtIndex(int data, int index) {
        if (index == 0) {
            this.insertAtStart(data);
            return;
        }
        if (index > this.length()) {
            return;
        }
        DLinkedListNode node = new DLinkedListNode(data);
        DLinkedListNode current = this.head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        DLinkedListNode temp = current.next;
        current.next = node;
        node.prev = current;
        node.next = temp;

    }

    // O(1)
    public void removeAtStart() {
        this.head = this.head.next;
        this.head.prev = null;
    }

    // O(n)
    public void removeAtEnd() {
        DLinkedListNode current = this.head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // O(n)
    public void removeAtIndex(int index) {
        if (index == 0) {
            removeAtStart();
            return;
        }
        if (index == length()) {
            removeAtEnd();
            return;
        }
        DLinkedListNode current = this.head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        current.next.prev = current;
    }

    public DLinkedList reversed() {
        DLinkedListNode current = this.head;
        DLinkedListNode prev = null;
        while (current != null) {
            DLinkedListNode temp = current.next;
            current.next = prev;
            if(prev!= null){

                prev.prev = current;
            }
            prev = current;
            current = temp;
        }
        return new DLinkedList(prev);
    }

    public static DLinkedList fromArray(int[] arr) {
        DLinkedListNode head = new DLinkedListNode();
        DLinkedListNode current = head;
        for (int i : arr) {
            DLinkedListNode newNode = new DLinkedListNode(i);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        return new DLinkedList(head.next);
    }

    public int[] toArray() {
        DLinkedListNode head = this.head;
        int[] arr = new int[this.length()];
        for (int i = 0; i < this.length(); i++) {
            arr[i] = head.data;
            head = head.next;
        }
        return arr;
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
            System.out.println(String.format("%s<-%s->%s",
            current.prev != null ? current.prev.data: null,
            current.data,
            current.next != null ? current.next.data : null));
            current = current.next;
        }
    }
}
