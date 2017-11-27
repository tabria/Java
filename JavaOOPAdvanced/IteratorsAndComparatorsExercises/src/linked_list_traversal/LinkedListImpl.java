package linked_list_traversal;

import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedListImpl<T> implements LinkedList<T>, Iterable<T> {

    private Node<T> nodes;

    public LinkedListImpl() {
        this.nodes = null;
    }

    @Override
    public void add(T data){
        Node<T> newNode = new Node<>(data, null);
        if (this.nodes == null){
            this.nodes = newNode;
        } else {
            Node<T> prev = this.nodes;
            while(this.nodes.getNextNode() != null){
                this.nodes = this.nodes.getNextNode();
            }
            this.nodes.setNextNode(newNode);
            this.nodes = prev;
        }
    }

    @Override
    public boolean remove(T data){
        boolean isRemoved = false;
        if (this.nodes != null){
            Node<T> startNode = this.nodes;
            Node<T> prev = this.nodes;
            while(this.nodes != null){
                if (this.nodes.getData() == data){
                    if (this.nodes == prev){
                        startNode = this.nodes.getNextNode();
                    } else {
                        prev.setNextNode(this.nodes.getNextNode());
                    }
                    isRemoved = true;
                    break;
                }
                prev = this.nodes;
                this.nodes = this.nodes.getNextNode();
            }
            this.nodes = startNode;

        }
        return isRemoved;
    }


    @Override
    public int getSize(){
        int countNodes = 0;
        Iterator<T> itr = this.iterator();
        while(itr.hasNext()){
            itr.next();
            countNodes++;
        }
        return countNodes;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterator<T> itr = this.iterator();
        while(itr.hasNext()){
            action.accept(itr.next());
        }
    }


    private final class LinkedListIterator implements Iterator<T>{
        Node<T> currentNodes;

        public LinkedListIterator() {
            this.currentNodes = nodes;
        }

        @Override
        public boolean hasNext() {
            return this.currentNodes != null;
        }

        @Override
        public T next() {
            T data = this.currentNodes.getData();
            this.currentNodes = this.currentNodes.getNextNode();
            return data;
        }
    }
}
