import java.util.Arrays;

public class customArrayList<E> {
    private Object[] data;
    private int size;
    private int capacity;

    {
        capacity = 10;
        size = 0;
        data = new Object[capacity];
    }
    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }
    
    private void checkIndex(int index) {
        if (!isValidIndex(index)) { 
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
    }

    private void checkCapacity(){
        if(size == data.length){
            data = Arrays.copyOf(data, data.length + 5); //aumenta em 5 o tamanho da lista
        }
    }

    public void set(int index, E e) {
        checkIndex(index);
        data[index] = e;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E)data[index];
    }
    
    public void add(E e){
        checkCapacity();
        data[size++] = e;
    }

    public void add(int index, E e){
        checkIndex(index);
        checkCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }


    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;  // garante que o último elemento é nulo
    }


    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;  // caso o objeto não tenha sido encontrado
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object o){
        for(int i = 0; i < size; i++){
            if (data[i].equals(o)){
                return i; //retorna a posição do elemento
            }
        }
        return -1;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }
}
