public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insertFirst(2);
        doublyLinkedList.insertLast(3);
        doublyLinkedList.insertAfter(3,4);
        doublyLinkedList.insertBefore(3,5);
        doublyLinkedList.deleteLast();
        doublyLinkedList.deleteFirst();
        doublyLinkedList.deleteKey(3);
        doublyLinkedList.displayForward();
        doublyLinkedList.displayBackWard();
    }
}
