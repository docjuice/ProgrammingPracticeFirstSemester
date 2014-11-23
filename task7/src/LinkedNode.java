class Node {
    public byte element;
    public Node next;

    public Node(){
    }
}

public class LinkedNode{
    public Node top;

    public LinkedNode(){
        top = null;
    }

    public boolean isEmpty(){
        return (top == null);
    }

    public void add(byte element){
        Node node = new Node();
        node.element = element;
        node.next = top;
        top = node;
    }

    public byte pop(){
        byte object = top.element;
        top = top.next;
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


