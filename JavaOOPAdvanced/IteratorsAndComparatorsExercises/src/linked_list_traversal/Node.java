package linked_list_traversal;

public class Node<T> {

    private T data;
    private Node<T> nextNode;

    public Node(T data, Node<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    T getData() {
        return this.data;
    }

    void setData(T data) {
        this.data = data;
    }

    Node<T> getNextNode() {
        return this.nextNode;
    }

    void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getData());
    }
}
