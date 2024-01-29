package deque;

public class LinkedListDeque<T> {
    private int size;
    private Node<T> root;

    public class Node<T> {
        public T item;
        public Node<T> next;
        public Node<T> last;
        public Node(T i) {
            item = i;
            next = null;
            last = null;
        }
    }

    public LinkedListDeque() {
        root = new Node<T>(null);
        root.next = root;
        root.last = root;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque<T> other) {
        root = new Node<T>(null);
        root.next = root;
        root.last = root;
        size = 0;
        for(int i = 0; i < other.size(); ++i) {
            addLast(other.get(i));
        }
    }
    public void addFirst(T item) {
        Node<T> n = new Node<T>(item);
        n.next = root.next;
        n.last = root;
        n.next.last = n;
        root.next = n;
        size++;
    }

    public void addLast(T item) {
        Node<T> n = new Node<T>(item);
        n.last = root.last;
        n.next = root;
        n.last.next = n;
        root.last = n;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<T> n = root.next;
        while(n != root){
            System.out.print(n.item + " ");
            n = n.next;
        }
    }

    public T removeFirst() {
        if(size == 0) {
            return null;
        }
        T ret = root.next.item;
        root.next.next.last = root;
        root.next = root.next.next;
        size--;
        return ret;
    }

    public T removeLast() {
        if(size == 0) {
            return null;
        }
        T ret = root.last.item;
        root.last.last.next = root;
        root.last = root.last.last;
        size--;
        return ret;
    }

    public T get(int index) {
        int k = 0;
        Node<T> n = root.next;
        while(k < index) {
            n = n.next;
            k++;
        }
        return n.item;
    }

    private T getRecursive(int index, Node<T> root) {
        if(index == 0) {
            return root.item;
        } else {
            return getRecursive(index-1, root.next);
        }
    }

    public T getRecursive(int index) {
        return getRecursive(index, root.next);
    }
}
