
public class BSTreeNode {

	private BSTreeNode left;
	private BSTreeNode right;
	private BSTreeNode parent;
	String nodevalue;
	
	public BSTreeNode(String nodevalue){
		this.nodevalue = nodevalue;
	}

	public BSTreeNode getLeft() {
		return left;
	}

	public void setLeft(BSTreeNode left) {
		this.left = left;
	}

	public BSTreeNode getRight() {
		return right;
	}

	public void setRight(BSTreeNode right) {
		this.right = right;
	}

	public BSTreeNode getParent() {
		return parent;
	}

	public void setParent(BSTreeNode parent) {
		this.parent = parent;
	}
}
