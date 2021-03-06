package DoubleEndedList;

public class DoublyLinkedList {
    private Node Head;
    private Node Tail;

    public DoublyLinkedList() {
        Head = null;
        Tail = null;
    }
    // This function checks whether the doublyLinkedList is empty or not
    public boolean isEmpty(){
        return Head == null;
    }
    // It inserts the data in 1st position.
    public void InsertFirst(int data){
        Node node = new Node(data);
        if(isEmpty ()){
            Tail = node;
        }else{
            Head.prev =node;
        }
        node.next = Head;
        Head = node;
    }
    // It inserts the data in last position.
    public void InsertLast(int data){
        Node node = new Node(data);
        if(isEmpty ()){
            InsertFirst ( data );
        }else{
            Tail.next = node;
            node.prev = Tail;
        }
        Tail = node;
    }
    // this function means to add data in any specified index.
    public void InsertAfter(int index, int data){
        Node node = new Node(data);
        if(index ==0){
            InsertFirst ( data );
        }else{
            Node n = Head;
            for (int i = 0; i <index-1 ; i++) {
                n=n.next;
            }
            node.next = n.next;
            node.prev = n;
            n.next = node;
            n.next.prev = node;
            Tail = node;
        }
    }
    // it deletes the 1st data
    public Node DeleteFirst(){
        Node temp = Head;
        if (Head.next == null)
            Tail = null;
        else
            Head.next.prev = null;
        Head = Head.next;
        return temp;
    }
    public Node DeleteLast(){
        Node temp = Tail;
        if (Head.next == null)
            Head = null;
        else
            Tail.prev.next = null;
        Tail = Tail.prev;
        return temp;
    }
    // it delete the specified data
    public Node  deleteKey(int data){
        Node n = Head;
        while (n.data != data){
            n=n.next;
            if(n == null)
                return null;
        }
        if (n == Head){
            Head = n.next;
        }else
            n.prev.next = n.next;
        if(n == Tail)
            Tail = n.prev;
        else
            n.next.prev = n.prev;
        return n;
    }

    public void DisplayForward(){
        System.out.print("List(first --> last): ");
        Node node = Head;
        while(node != null){
            node.displayNode ();
            node= node.next;
        }
        System.out.println ("");
    }
    public void DisplayBackward(){
        System.out.print("List(Last --> First): ");
        Node node = Tail;
        while (node != null){
            node.displayNode ();
            node= node.prev;
        }
        System.out.println ("");
    }
}
