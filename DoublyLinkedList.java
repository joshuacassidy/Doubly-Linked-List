public class DoublyLinkedList {
    private Node first;
    private Node last;

    public DoublyLinkedList(){
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;

        if(isEmpty()){
            // if the list is empty last will refer to the new node being created.
            last = newNode;
        } else {
            // setting the old first to point to this node (was previously null)
            first.previous = newNode;
        }
        // the new node's next field will point to the old node first.
        newNode.next = first;
        // the node is being inserted into the first position
        this.first = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if(isEmpty()){
            first = newNode;
        } else{
            // Assigning the old last node to the new last node
            last.next = newNode;
            // setting the new nodes previous to the old last node
            newNode.previous = last;
        }
        // resetting the new node.
        last = newNode;
    }

    public Node deleteFirst(){
        if(!isEmpty()) {
            Node temp = first;
            // if there if only one item in the list.
            if(first.next == null){
                last = null;
            }else{
                // pointing the node to itself so saying the nexts nodes previous node is null
                first.next.previous = null;

            }
            // replacing the firsts pointer
            first = first.next;
            //return the deleted node.
            return temp;
        } else{
            return null;
        }

    }

    public Node deleteLast(){
        if(!isEmpty()) {
            Node temp = last;
            // if there if only one item in the list.
            if (first.next == null) {
                first = null;
            } else {
                // pointing the node to itself so saying the nexts nodes previous node is null
                last.previous.next = null;

            }
            // replacing the firsts pointer
            last = last.previous;
            //return the deleted node.
            return temp;
        } else{
            return null;
        }
    }

    public boolean insertBefore(int key, int data){
        Node current = first;
        while(current.data != key){
            current = current.next;
            if(current == null){
                return false;
            }
        }

        Node newNode = new Node();
        newNode.data = data;

        if(current == first){
            first = newNode;
        } else{
            newNode.previous = current.previous;
            current.previous.next = newNode;
        }
        newNode.next = current;

        current.previous = newNode;

        return true;
    }

    public boolean insertAfter(int key, int data){
        Node current = first;
        //start looping through the list
        while(current.data != key){
            current = current.next;
            // as long as we have not found the key in the node we are looking for continue searching
            if(current == null){
                // when the key is not found
                return false;
            }
        }
        Node newNode = new Node();
        newNode.data = data;

        if(current == last){
            current.next = null;
            last = newNode;
        } else{
            newNode.next = current.next;
            // new nodes next field should point to the node ahead of the current nodes
            current.next.previous = newNode;

        }
        newNode.previous = current;
        current.next = newNode;
        return true;
    }

    //deleting a node with a particualar key;
    public Node deleteKey(int key){
        Node current = first;
        while(current.data != key){
            current = current.next;
            if(current == null){
                return null;
            }
        }

        if(current == first){
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if(current == last){
            last = current.previous;
        } else {
            current.next.previous = current.next;
        }


        if(current.next != null && current.previous != null){
            current.next.previous = current.previous;
            current.previous = current.next;
        } else if(current.next == null){
            current.previous.next = null;
        } else {
            current.next = null;
        }
        return current;
    }

    public void displayForward(){
        System.out.println("first --> last");
        Node current = first;
        while (current != null){
            current.displayNode();
            current = current.next;
        }
    }

    public void displayBackWard(){
        System.out.println("last --> first");
        Node current = last;
        while (current != null){
            current.displayNode();
            current = current.previous;
        }
    }


}
