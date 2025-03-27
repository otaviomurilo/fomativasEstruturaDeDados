import java.util.Objects;

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
    private int size;

    public DoubleLinkedList() {
        this.top = null;
        this.base = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.base == null;
    }

    public boolean isFull(){
        return false; //lista sem limite fixo
    }

    public int getSize(){
        return size;
    }

    private void isPosValid(int pos) {
        Objects.checkIndex(pos, size);
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);

        if (this.base == null) {
            this.top = node;
            this.base = node;
        } else {
            node.previous = this.top; // O nó novo aponta para o topo atual
            this.top.next = node; // O topo atual aponta para o novo nó
            this.top = node; // O topo é atualizado para o novo nó
        }
        size++;
    }

    private Node<T> getNode(int pos) {
        isPosValid(pos);
    
        Node<T> current; //meio da lista
    
        if (pos < size / 2) { //posição inferior ao meio
            current = this.base; // percorre a partir da base
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
        } else {
            current = this.top; // percorre a partir do topo
            for (int i = size - 1; i > pos; i--) {
                current = current.previous;
            }
        }
        return current; // retorna o nó na posição requisitada
    }
    

    public void display() {
        Node<T> current = this.base;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void add(int pos, T value){
        if (pos < 0 || pos > size) { //permite uma inserção no final da lista, por isso não chama o método isPosValid
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        
        if (pos == size) {
            add(value);
        }
        else{

            Node<T> newNode = new Node<>(value);
            Node<T> nextNode = getNode(pos); //armazena o nó que atualmente está na posição que deseja inserir
            Node<T> prevNode = nextNode.previous; //nó anterior ao que atualmente está no que deseja inserir

            newNode.previous = prevNode;
            newNode.next = nextNode;


            if (prevNode != null) {
                prevNode.next = newNode; //atualiza o próx do anterior
            } else {
                base = newNode;
            }

            nextNode.previous = newNode; //atualiza o anterior do próx
            size++;

        }
    }

    private void removeNode(Node<T> node){
        if(node.previous != null) {
            node.previous.next = node.next;
        }
        else {
            base = node.next; //caso seja o primeiro nó, a base é o próximo nó
        }

        if(node.next != null) {
            node.next.previous = node.previous;

        }
        else {
            top = node.previous; //último nó --> topo é o anterior
        }
        size--;
        
    }

    public void remove(int pos) {
        isPosValid(pos);
        Node<T> delNode = getNode(pos); //baseando na posição, encontra o nó
        removeNode(delNode);
    }

    public void clear(){
        top = base = null;
        size = 0;
    }

    public T get(int pos) {
        isPosValid(pos);
        Node<T> node = getNode(pos);
        return node.data;
    }

    public void set(int pos, T value) {
        isPosValid(pos);
        Node<T> node = getNode(pos);
        node.data = value;
    }

    public int find(T value) {
        Node<T> current = base;
        int index = 0;
        while (current != null) {
            if (current.data.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

}