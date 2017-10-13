public class Node<T extends Comparable<T>> {
    public T data;
    public Node<T> next;
    public Node<T> previous;

    public void displayNode(){
        System.out.println(data);
    }

}
