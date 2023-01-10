public class DoublyLinkedList<T> {
    public Node <T> head = null;
    public Node <T> tail = null;
    public int size;
    class Node<T> {
        T data;
        public Node <T> prev;
        public Node <T> next;

        public Node(T data){
            this.data =data;
        }

    }
    public void addNode(T data) {
        if(head == null){
            this.head = new Node<T>(data);
            this.tail = head;
        }else {
            Node<T> node =head;
            while (node.next!=null){
                node=node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            tail = node.next;
        }
        size++;
    }
    public void printAll(){
        if (head != null){
            Node<T> node = head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }
    public boolean isBiggerThanHalfSize(int index){
        // 절반보다 크다면 true
        return (size/2) <= index;
    }

    Node <T> searchFromHead (int index){
        Node <T> node =head;
        for (int i = 0; i <index ; i++) node= node.next;

        return node;
    }

    Node <T> searchFromTail (int index){
        if (index == 0) return head;

        Node <T> node =tail;
        for (int i = size; i > index ; i--) node= node.prev;

        return node.next;
    }
    public Node<T> search(int index){
        // 1. 전체 크기를 확인
        // 2. 전체 크기보다 큰지 작은 지 확인
        // 3. 크다면 처음 부터 찾기
        // 4. 작다면 뒤에서 부터 찾기

        return isBiggerThanHalfSize(index) ? searchFromTail(index) : searchFromHead(index);
    }

    public void insert (int index, T data) {
        // 기본로직
        // 1. index 를 찾는다.
        // 2. 인덱스 전에 있는 next 값이 새로운 Node 로 변해야한다.
        // 3. 기존 Node 의 prev 가 새로운 node
        // 4. 새로운 node 는 prev 와 next 가 새로 지정을 해줘야한다.

        // case
        // index 가 head 일 때 즉 0일 때 & index 가 마지막일 때 & 그 외 & 데이터가 없을 시

        if (size == 0) throw new IllegalArgumentException("No data");

        Node<T> node = new Node<>(data);

        if (index == 0) {
            head.prev = node;
            node.next = head;
            head = node;

            size++;
        } else if (index == size){
            addNode(data);
        } else if (index >0 && index< size) {
            Node<T> searchNode = search(index);

            node.prev = searchNode.prev;
            node.next = searchNode;

            searchNode.prev.next = node;
            searchNode.prev = node;

            size++;
        } else {
            throw new IllegalArgumentException("No search index");
        }
    }


    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(2);
        doublyLinkedList.addNode(3);

        doublyLinkedList.insert(2,0);

    }
}
