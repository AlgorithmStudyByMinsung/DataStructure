public class SingleLinkedList<T>  {
    public Node head = null;
    class Node<T>{
        T data;
        Node next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void add(T value) {
        if(head == null) head = new Node(value);
        else {
            Node<T> node = head;

            while (node.next!=null) {
                node = node.next;
            }
            node.next = new Node(value);
        }
    }

    public void printAll(){
        if(head != null){
            Node node =head;

            System.out.println(node.data);
            while (node.next!=null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> search(int index) {
        if (head == null) return null;

        Node node =head;
        for (int i = 0; i < index ; i++) {
            node = node.next;
        }
        return node;
    }
    public void insert(int index, int data){

        Node<Integer> newNode = new Node<>(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        }

        Node<T> search = search(index - 1);

        Node nextNode = search.next;
        search.next = newNode;
        newNode.next = nextNode;

    }

    public void remove (int index) {

        if (index == 0) head = head.next;
        else {
            Node<T> prevNode = search(index - 1);

            Node nextNode = prevNode.next.next;
            prevNode.next = nextNode;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList=new SingleLinkedList<>();

        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        singleLinkedList.add(5);

        singleLinkedList.remove(0);

        singleLinkedList.printAll();

    }
}
