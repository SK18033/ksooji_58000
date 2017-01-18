
import java.util.HashMap;
import java.util.Stack;

public class BST {

	BSTreeNode root;
	
	private int BST_Insert(BSTreeNode T, BSTreeNode z){
		
		BSTreeNode y = null;
		BSTreeNode x = root;
				
		while (x!=null){
			y = x;
			if(z.nodevalue.compareTo(x.nodevalue) == 0){
				return 0;
			}
			else if (z.nodevalue.compareTo(x.nodevalue) < 0){
				x = x.getLeft();	
			}
			else{
				x = x.getRight();
			}
		}
		
		z.setParent(y);
		if (y == null){
			root = z;
		}
		else if(z.nodevalue.compareTo(y.nodevalue) < 0){
			y.setLeft(z);
		}
		else{
			y.setRight(z);
		}
		return 1;
	}
	
	
	private int BST_Delete (BSTreeNode T,BSTreeNode z){
		
		BSTreeNode y=null;
		if(z == null){
			return 0;
		}
		else if(z.getLeft() == null ){
			BST_Transplant(T, z, z.getRight());
		}
		else if( z.getRight() == null ){
			BST_Transplant(T, z, z.getLeft());
		}
		else{
			y = BST_Minimum(z.getRight());
			if (y.getParent() != z){
				BST_Transplant(T, y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}
			BST_Transplant(T, z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
		}
		return 1;
	}
	

	private BSTreeNode BST_Minimum(BSTreeNode x) {
		
		while(x.getLeft() != null){
			x = x.getLeft();
		}
		return x;
	}


	private void BST_Transplant(BSTreeNode T, BSTreeNode u, BSTreeNode v) {
		
		if (u.getParent() == null){
			root = v;
		}
		else if ( u == u.getParent().getLeft()){
			u.getParent().setLeft(v);
		}
		else{
			u.getParent().setRight(v);
		}
		if (v!=null){
			v.setParent(u.getParent());
		}
		
	}


	public BSTreeNode BST_Search(BSTreeNode x, String str) {

		if (x== null || (str.compareTo(x.nodevalue) == 0)){
			return x;
		}
		if (str.compareTo(x.nodevalue) < 0 ){
			return BST_Search(x.getLeft(),str);
		}
		else{
			return BST_Search(x.getRight(),str);
		}
	}	
	
	public int Search(BSTreeNode x, String str) {

		while (x!= null ){
			if (str.equals(x.nodevalue)){
				return 1;
			}
			else if(str.compareTo(x.nodevalue) < 0){
				x = x.getLeft();
			}
			else{
				x = x.getRight();
			}
		}
		return 0;
	}	
	
	private int InOrder(BSTreeNode n,int i){

		if(n!= null){
			i = InOrder(n.getLeft(),i);
			System.out.println(n.nodevalue);
			i++;
			i = InOrder(n.getRight(),i);
		}
		return i;
	}
	
	public int InOrderTraverse(){
		return InOrder(root,0);
	}


	public int BST_insert(String str) {
		
		BSTreeNode z= new BSTreeNode(str);
		z.setLeft(null);
		z.setRight(null);
		z.setParent(null);
		
		return BST_Insert(root, z);

	}


	public int BST_Delete(String str) {
		
		BSTreeNode z= BST_Search(root,str);
		return BST_Delete(root, z);
	}

    public int Height()
    {
    	int hgt = 0;	
    	HashMap<BSTreeNode, Integer> visit = new HashMap<BSTreeNode, Integer>();
    	Stack<BSTreeNode> st = new Stack<BSTreeNode>(); 
    	Stack<Integer> st1 = new Stack<Integer>(); 
    	BSTreeNode cur = root;
    	st.push(cur);
    	st1.push(0);

    	while( !st.empty() ){
    		
    		cur = st.peek();
    		Integer cur_h = st1.peek();
    		if(cur.getRight() == null || visit.containsKey(cur.getRight())){
    			if(cur.getLeft() == null || visit.containsKey(cur.getLeft())){
    				st.pop();
    				st1.pop();
    				visit.put(cur,1);
    			}
    			else{
    				st.push(cur.getLeft());
    				st1.push(cur_h+1);
    				if(hgt < cur_h+1)
    					hgt = cur_h+1;
    			}
    		}
    		else{
    			st.push(cur.getRight());
				st1.push(cur_h+1);
				if(hgt < cur_h+1)
					hgt = cur_h+1;
    			if(cur.getLeft() != null && !visit.containsKey(cur.getLeft())){
    				st.push(cur.getLeft());  
    				st1.push(cur_h+1);
    				if(hgt < cur_h+1)
    					hgt = cur_h+1;
    			}
    		}
    	}
    	return hgt;
    }
    
}