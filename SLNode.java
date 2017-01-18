
public class SLNode {
	
	private SLNode[] fwd;	
	private String nodevalue;
		
	public SLNode(int max, String str) {		
		this.fwd = new SLNode[max+1];
		this.nodevalue = str;
	}
	public SLNode[] getFwd() {
		return fwd;
	}
	public void setFwd(SLNode[] fwd) {
		this.fwd = fwd;
	}
	public String getNodevalue() {
		return nodevalue;
	}
	public void setNodevalue(String nodevalue) {
		this.nodevalue = nodevalue;
	}

}
