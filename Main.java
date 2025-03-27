public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        for (int i = 1; i <= 10; i++) {
            list.add(i - 1, i);
        }
        list.display();

        System.out.println("\níndice 2: " + list.get(2)); 
        list.set(2, 35); 
        System.out.println("novo valor na posição 2: " + list.get(2));
        list.display();

        System.out.println("\nAdicionando novo valor ao índice 1:");
        list.add(1, 25); 
        list.display();

        System.out.println("\nremovendo valor na posição 3:");
        list.remove(3); 
        list.display();

        System.out.println("\nposição do valor 25: " + list.find(25)); 
        System.out.println("\nlista cheia? " + list.isFull()); 
        System.out.println("\ntamanho da lista: " + list.getSize());

        System.out.println("\nlimpando lista..");
        list.clear();
        list.display(); 
        
        System.out.println("lista vazia? " + list.isEmpty()); 
    }
}
