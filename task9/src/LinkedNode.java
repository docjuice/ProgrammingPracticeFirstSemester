class Node {
    public Object element;
    public Node next;

    public Node(){
    }
}

public class LinkedNode{
    public Node first;
	public Node top;
    public int size;

    public LinkedNode(){
        first = null;
	    top = null;
        size = 0;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void add(Object element){
        Node node = new Node();
        node.element = element;
	    if (first != null){
		    node.next = top;
		    top = node;
	    } else{
		    first = node;
		    top = first;
	    }
        size++;
    }

    public Object pop(){
        Object object = top.element;
        top = top.next;
        size--;
        return object;
    }

	public boolean isHaveCycle(){
		Node a = first;
		Node b = first.next;

		while (a != b){
			if (a == null || b == null) return false;
			a = a.next;
			if (b.next != null) b = b.next.next; else
				return false;
		}
		return true;
	}
}


