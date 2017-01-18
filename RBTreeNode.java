
public class RBTreeNode {
	private RBTreeNode left;
	private RBTreeNode right;
	private RBTreeNode parent;
	String color;
	String nodevalue;
	
	public RBTreeNode(String nodevalue){
		this.nodevalue = nodevalue;
	}
	

	public RBTreeNode getLeft() {
		return left;
	}

	public void setLeft(RBTreeNode left) {
		this.left = left;
	}

	public RBTreeNode getRight() {
		return right;
	}

	public void setRight(RBTreeNode right) {
		this.right = right;
	}

	public RBTreeNode getParent() {
		return parent;
	}

	public void setParent(RBTreeNode parent) {
		this.parent = parent;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}