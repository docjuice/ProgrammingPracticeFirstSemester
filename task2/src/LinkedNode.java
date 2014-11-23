class Node {
    public Object element;
    public Node next;

    public Node(){
    }
}

public class LinkedNode{
    public Node top;
    public int size;

    public LinkedNode(){
        top = null;
        size = 0;
    }

    public boolean isEmpty(){
        return (top == null);
    }

    public void add(Object element){
        Node node = new Node();
        node.element = element;
        node.next = top;
        top = node;
        size++;
    }

    public Object pop(){
        Object object = top.element;
        top = top.next;
        size--;
        return object;
    }

	public Node reverse(Node head){
		Node answer = null;
		while(head != null){
			Node temp = head;
			head = head.next;
			temp.next = answer;
			answer = temp;
		}
		return answer;
	}
}


