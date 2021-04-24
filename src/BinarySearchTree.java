import javax.naming.PartialResultException;

public class BinarySearchTree <E extends Comparable> {

    private ListNode<E> head = new ListNode<>();
    public int size;

    public BinarySearchTree() {
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private class ListNode<E> {
        public E value;
        public ListNode<E> next;

        public ListNode() {
        }

        public ListNode(E o) {
            this.value = o;
        }
    }

    //Todo: Verificar que la palabra no este duplicada
    //Todo: Si no esta duplicada return false y verdadero si esta duplicada
    //Agregar valores
     boolean insert(E value) {
        ListNode<E> node = new ListNode<>(value);
        ListNode<E> current = head.next;
        ListNode<E> previous = head;

        while(current != null && current.value.compareTo(value) <0){
            previous = current;
            current = current.next;
            return true;
        }

        previous.next = node;
        node.next = current;
        this.size++;
        return false;
    }

    //TODO: Verificar que cuando el valor sea borrado return true
    boolean remove(E value){
        ListNode<E> node = head.next;
        ListNode<E> previous = head;
        boolean deleted = true;

        while(node.value.compareTo(value) !=0 ){
            previous = node;
            node = node.next;
            deleted = false;
        }
        previous.next = node.next;
        this.size--;
        return deleted;
    }

    boolean search(E value){
        ListNode<E> current = head.next;
        boolean found = false;

        while(current != null && !found){
            if(current.value.compareTo(value) == 0){
                found = true;
            }else{
                current = current.next;
            }
        }
        return found;
    }

    //Todo: verificar que la funcion este bien :)
    //Todo: Modificar funcion que busque en base a los argumentos de la funcion
    void display(String message){
        ListNode<E> current = head.next;

        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }

    int numberNodes(){
        return 2;
    }

    int numberLeafNodes(){
        return 2;
    }

    int height(){
        return 1;
    }
}