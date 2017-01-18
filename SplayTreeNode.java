
public class SplayTreeNode {

	private SplayTreeNode left;
	private SplayTreeNode right;
	private SplayTreeNode parent;
	String nodevalue;
	
	public SplayTreeNode(String nodevalue){
		this.nodevalue = nodevalue;
		this.setLeft(null);
		this.setRight(null);
		this.setParent(null);
	}

	public SplayTreeNode getLeft() {
		return left;
	}

	public void setLeft(SplayTreeNode left) {
		this.left = left;
	}

	public SplayTreeNode getRight() {
		return right;
	}

	public void setRight(SplayTreeNode right) {
		this.right = right;
	}

	public SplayTreeNode getParent() {
		return parent;
	}

	public void setParent(SplayTreeNode parent) {
		this.parent = parent;
	}

}
