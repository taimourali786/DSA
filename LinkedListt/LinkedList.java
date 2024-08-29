// Complexity
//       Worst case	Average Case
// Search	O(n)	O(n)
// Insert	O(1)	O(1)
// Deletion	O(1)	O(1)
public class LinkedList {
    LinkedListNode head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(final LinkedListNode head) {
        this.head = head;
    }

    public Integer getIndex(int index) {
        if (head == null) {
            return null;
        }
        LinkedListNode head = this.head;
        // As we are updating the next in the loop in each iteration the head will be at
        // iteration + 1 if we start from zero
        for (int i = 1; i <= index; i++) {
            head = head.next;
        }
        return head.data;
    }

    // O(1)
    public void insertAtStart(int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.next = this.head;
        this.head = newNode;

    }

    // O(n)
    public void insertAtEnd(int data) {
        LinkedListNode current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        LinkedListNode newNode = new LinkedListNode(data);
        current.next = newNode;
    }

    // O(n)
    public void insertAtIndex(int data, int index) {
        if (index > length() - 1) {
            return;
        }
        LinkedListNode head = this.head;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        LinkedListNode node = new LinkedListNode(data);
        node.next = head.next;
        head.next = node;
    }

    // O(1)
    public void removeAtStart() {
        if (head == null) {
            return;
        }
        LinkedListNode head = this.head;
        this.head = head.next;
    }

    // O(n)
    public void removeAtEnd() {
        if (head == null) {
            return;
        }
        LinkedListNode head = this.head;
        while (head.next.next != null) {
            head = head.next;
        }
        head.next = null;
    }

    // O(n)
    public void removeAtIndex(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            removeAtStart();
            return;
        }
        LinkedListNode head = this.head;
        for (int i = 0; i < index - 1; i++) {
            head = head.next;
        }
        head.next = head.next.next;
    }

    public LinkedList reversed() {
        LinkedListNode current = this.head;
        LinkedListNode prev = null;
        while (current != null) {
            LinkedListNode next = current.next;
            current.next =prev;
            prev =current;
            current = next;
        }

        return new LinkedList(current);
    }

    public static LinkedList fromArray(final int[] arr) {
        LinkedListNode head = new LinkedListNode();
        if (arr != null) {
            LinkedListNode current = head;
            for (int i : arr) {
                LinkedListNode newNode = new LinkedListNode(i);
                current.next = newNode;
                current = current.next;
            }
        }
        return new LinkedList(head.next);
    }

    public int[] toArray() {
        int[] arr = new int[this.length()];
        LinkedListNode current = this.head;
        for (int i = 0; i < this.length(); i++) {
            arr[i] = current.data;
            current = current.next;
        }
        return arr;
    }

    public int length() {
        int l = 0;
        LinkedListNode current = this.head;
        while (current != null) {
            l++;
            current = current.next;
        }
        return l;
    }

    public void printList() {
        LinkedListNode current = this.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}