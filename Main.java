public class Main {
    public static void main(String[] args) {
        customArrayList<String> list = new customArrayList<>();
    
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println("Lista inicial: " + list);

        System.out.println("elemento no índice 2: " + list.get(2));
        
        list.set(1, "X");
        System.out.println("set no índice 1: " + list);
        System.out.println("índice do elemento C: " + list.indexOf("C"));
        list.remove("C");
        System.out.println("elemento C removido: " + list);

        System.out.println("lista contém A: " + list.contains("A"));
        System.out.println("lista contém Z: " + list.contains("Z"));
        System.out.println("remover elemento Z: " + list.remove("Z")); //remover elemento não existente

        list.add("E");
        list.add(2, "H");
        System.out.println("Lista final: " + list);
    }
}
