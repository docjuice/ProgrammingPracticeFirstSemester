public class BinTree{

	static class Item {
		public char element;
		public StringBuffer string = new StringBuffer();
		public Item left, right, parent;

		public Item(Item parent, char element){
			this.element = element;
			left = null;
			right = null;
			this.parent = parent;
		}
	}

	public Item root = null;

	private boolean isMathSymbol(char x){
		return (x == '+' || x == '-' || x == '*' || x == '/');
	}

    public void add(char element){
	    if (root == null){
		    root = new Item(null, element);
	    } else {
		    add(root, element);
	    }
    }

	private boolean isFull(Item x){
		if (x == null) return false;
		if (!isMathSymbol(x.element)) return true;
		return (isFull(x.left) && isFull(x.right));
	}

	public void add(Item node, char element){
		if (isMathSymbol(element)){
			if (node.left == null || !isFull(node.left)){
				if (node.left == null) node.left = new Item(node, element); else add(node.left, element);
			} else {
				if (node.right == null) node.right = new Item(node, element); else add(node.right, element);
			}
		} else {
			if ((node.left == null || isMathSymbol(node.left.element)) && !isFull(node.left)){
				if (node.left == null) node.left = new Item(node, element); else add(node.left, element);
			} else {
				if (node.right == null) node.right = new Item(node, element); else add(node.right, element);
			}
		}
	}

	public void recPreOrder(Item x){
		if (!isMathSymbol(x.element)) x.string.append(x.element);

		if (x.left != null) recPreOrder(x.left);
		if (x.right != null) recPreOrder(x.right);

		if (isMathSymbol(x.element)){
			boolean isNeedBrackets = false;
			if (x.parent != null) isNeedBrackets = (x.element != x.parent.element);

			if (isNeedBrackets) x.string.append("(");
			x.string.append(x.left.string);
			x.string.append(x.element);
			x.string.append(x.right.string);
			if (isNeedBrackets) x.string.append(")");
		}
	}
}


