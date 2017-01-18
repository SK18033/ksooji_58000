
import java.util.HashMap;
import java.util.Stack;

public class RBT {

	RBTreeNode root;
	String R = "RED";
	String B = "BLACK";
	
	RBTreeNode nil ;
	
	public RBT() {
		nil = new RBTreeNode("NIL");
		nil.setLeft(nil);
		nil.setRight(nil);
		nil.setParent(nil);
		nil.setColor(B);
		
		root = nil;
	}
	
	private int RBT_Insert(RBTreeNode T, RBTreeNode z){
			
			RBTreeNode y = this.nil;
			RBTreeNode x = T;
			
			while (x != this.nil){
				y = x;
				if(z.nodevalue.compareTo(x.nodevalue) == 0){
					return 0;
				}
				else if (z.nodevalue.compareTo(x.nodevalue) < 0 ){
					x = x.getLeft();
				}
				else{
					x= x.getRight();
				}
			}
						
			z.setParent(y);
			if (y == this.nil){
				root = z;
			}
			else if(z.nodevalue.compareTo(y.nodevalue) < 0){
				y.setLeft(z);
			}
			else{
				y.setRight(z);
			}
			z.setLeft(this.nil);
			z.setRight(this.nil);
			z.setColor(R);
			RBT_Insert_FixUp(T,z);
			return 1;
		}

	private void RBT_Insert_FixUp(RBTreeNode T, RBTreeNode z) {

		RBTreeNode y = this.nil;

		while ( z.getParent().getColor().equals(R)){
			if (z.getParent() == z.getParent().getParent().getLeft()){
				
				y = z.getParent().getParent().getRight();
				
				if(y.getColor().equals(R) ){
					z.getParent().setColor(B);
					y.setColor(B);
					z.getParent().getParent().setColor(R);
					z = z.getParent().getParent();
				}
				else{ 
					if( z == z.getParent().getRight()){
						z = z.getParent();
						RBT_Left_Rotate(T,z);
					}
				
					z.getParent().setColor(B);
					z.getParent().getParent().setColor(R);
					RBT_Right_Rotate(T, z.getParent().getParent());
				}
			}
			else{
				y = z.getParent().getParent().getLeft();
					
				if(y.getColor() == R ){
					z.getParent().setColor(B);
					y.setColor(B);
					z.getParent().getParent().setColor(R);
					z = z.getParent().getParent();
				}
				else {
					if( z == z.getParent().getLeft()){
						z = z.getParent();
						RBT_Right_Rotate(T,z);
					}
					
					z.getParent().setColor(B);
					z.getParent().getParent().setColor(R);
					RBT_Left_Rotate(T, z.getParent().getParent());
				}
				
			}
		}
		root.setColor(B);
	}

	private void RBT_Left_Rotate(RBTreeNode T, RBTreeNode x) {
		
		RBTreeNode y = x.getRight();
		
		x.setRight(y.getLeft());
		
		if(y.getLeft() != this.nil){
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent());
		
		if( x.getParent()== this.nil){
			root = y;
		}
		else if ( x == x.getParent().getLeft()){
			x.getParent().setLeft(y);
		}
		else{
			x.getParent().setRight(y);
		}
		y.setLeft(x);
		x.setParent(y);
	}

	private void RBT_Right_Rotate(RBTreeNode T, RBTreeNode x) {
		
		RBTreeNode y = x.getLeft();
		
		x.setLeft(y.getRight());
		
		if(y.getRight() != this.nil){
			y.getRight().setParent(x);
		}
		y.setParent(x.getParent());
		if( x.getParent()== this.nil){
			root = y;
		}
		else if ( x == x.getParent().getRight()){
			x.getParent().setRight(y);
		}
		else{
			x.getParent().setLeft(y);
		}	
		y.setRight(x);
		x.setParent(y);
	}
	
	private void RBT_Transplant(RBTreeNode T, RBTreeNode u, RBTreeNode v) {
		
		if (u.getParent() == this.nil){
			root = v;
		}
		else if ( u == u.getParent().getLeft()){
			u.getParent().setLeft(v);
		}
		else{
			u.getParent().setRight(v);
		}
		v.setParent(u.getParent());		
	}
	
	public int RBT_Delete(RBTreeNode T, RBTreeNode z){
		RBTreeNode x = this.nil, y = z;
		String ycolor = y.getColor();
		
		if (z.getLeft() == this.nil){
			x = z.getRight();
			RBT_Transplant(T,z,z.getRight());
		}
		else if(z.getRight() == this.nil){
			x = z.getLeft();
			RBT_Transplant(T,z,z.getLeft());
		}
		else{
			y = RBT_Minumum(z.getRight());
			ycolor = y.getColor();
			x = y.getRight();
			if(y.getParent() == z){
				x.setParent(y);
			}
			else{
				RBT_Transplant(T,y,y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}
			RBT_Transplant(T,z,y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
			y.setColor(z.getColor());
		}
		if(ycolor == B){
			RBT_Delete_FixUp(T,x);
		}
		return 1;
	}

	private void RBT_Delete_FixUp(RBTreeNode T, RBTreeNode x) {
		
		while (x != root && x.getColor() == B ){
			if (x == x.getParent().getLeft()){
				
				RBTreeNode w = x.getParent().getRight();
				
				if (w.getColor() == R ){
					w.setColor(B);
					x.getParent().setColor(R);
					RBT_Left_Rotate(T, x.getParent());
					w = x.getParent().getRight();
				}
				
				if (w.getLeft().getColor() == B && w.getRight().getColor() == B){
					w.setColor(R);
					x = x.getParent();
				}
				
				else{ 
					if( w.getRight().getColor() == B ){
						w.getLeft().setColor(B);
						w.setColor(R);
						RBT_Right_Rotate(T, w);
						w = x.getParent().getRight();
					}
					
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(B);
					w.getRight().setColor(B);
					RBT_Left_Rotate(T, x.getParent());
					x = root;
				}
			}
			else {
				RBTreeNode w = x.getParent().getLeft();
				
				if (w.getColor() == R ){
					w.setColor(B);
					x.getParent().setColor(R);
					RBT_Right_Rotate(T, x.getParent());
					w = x.getParent().getLeft();
				}
				
				if (w.getRight().getColor() == B && w.getLeft().getColor() == B){
					w.setColor(R);
					x = x.getParent();
				}
				
				else {
					if( w.getLeft().getColor() == B ){
						w.getRight().setColor(B);
						w.setColor(R);
						RBT_Left_Rotate(T, w);
						w = x.getParent().getLeft();
					}
				
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(B);
					w.getLeft().setColor(B);
					RBT_Right_Rotate(T, x.getParent());
					x = root;
				}
			}
		}
		x.setColor(B);
	}

	private RBTreeNode RBT_Minumum(RBTreeNode x) {
		
		while(x.getLeft() != this.nil){
			x = x.getLeft();
		}
		return x;
	}

	public int RBT_Delete(String str) {
		
		RBTreeNode z= RBT_Search(root, str);
		if(z == this.nil)
			return 0;
		else
			return RBT_Delete(root, z);

	}

	public int RBT_insert(String str) {

		RBTreeNode z= new RBTreeNode(str);
		return RBT_Insert(root, z);	
		
	}

	public int InOrderTraverse() {
		return InOrder(root, 0);
	}

	private int InOrder(RBTreeNode n, int i) {
		

		if(n!= this.nil){
			i = InOrder(n.getLeft(),i);
			System.out.println(n.nodevalue);
			i++;
			i = InOrder(n.getRight(),i);
		}
		return i;
	}
	
	private RBTreeNode RBT_Search(RBTreeNode x, String str) {

		if (x== this.nil || (str.compareTo(x.nodevalue) == 0)){
			return x;
		}
		if (str.compareTo(x.nodevalue) < 0 ){
			return RBT_Search(x.getLeft(),str);
		}
		else{
			return RBT_Search(x.getRight(),str);
		}
	}	
	
	public int Search(RBTreeNode x, String str) {

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
	
	public int Height() {
    	int hgt = 1;	
    	HashMap<RBTreeNode, Integer> visit = new HashMap<RBTreeNode, Integer>();
    	Stack<RBTreeNode> st = new Stack<RBTreeNode>(); 
    	Stack<Integer> st1 = new Stack<Integer>(); 
    	RBTreeNode cur = root;
    	st.push(cur);
    	st1.push(0);

    	while( !st.empty() ){
    		
    		cur = st.peek();
    		Integer cur_h = st1.peek();
    		if (cur == this.nil){
    			return 0;
    		}
    		if(cur.getRight() == this.nil || visit.containsKey(cur.getRight())){
    			if(cur.getLeft() == this.nil || visit.containsKey(cur.getLeft())){
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
    			if(cur.getLeft() != this.nil && !visit.containsKey(cur.getLeft())){
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