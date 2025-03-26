public class DoubleLinkedList<T> {
    private class Node<T> {
        T data;
        Node<T> previous;
        Node<T> next;

        public Node(T value) {
            this.data = value;
            this.previous = null;
            this.next = null;
        }
    }

    
    private Node<T> top;
    private Node<T> base;

    public DoubleLinkedList(){
        this.top = null;
        this.base = null;
    }
}
