
import java.util.HashMap;
import java.util.Stack;

public class SplayTree {

	private SplayTreeNode root;
	private static SplayTreeNode header = new SplayTreeNode(null); 

	public void Splay_Insert(String str) {
		
		SplayTreeNode x;

		if (root == null) {
			root = new SplayTreeNode(str);
			return;
		}
		Splay(str);
		if (str.compareTo(root.nodevalue) == 0) {
			return;
		}
		x = new SplayTreeNode(str);
		if (str.compareTo(root.nodevalue) < 0) {
			x.setLeft(root.getLeft());
			x.setRight(root);
			root.setLeft(null);
		} 
		else{
			x.setRight(root.getRight());
			x.setLeft(root);
			root.setRight(null);
		}
		root = x;
	}

	public void Splay_Delete(String str) {
		SplayTreeNode x;

		Splay(str);

		if (str.compareTo(root.nodevalue) != 0) {
			return;
		}


		if (root.getLeft() == null) {
			root = root.getRight();
		} 
		else {
			x = root.getRight();
			root = root.getLeft();
			Splay(str);
			root.setRight(x);
		}
	}

	public String Tree_Minimum() {
		SplayTreeNode x = root;
		if(root == null) return null;
		while(x.getLeft() != null) x = x.getLeft();
		Splay(x.nodevalue);
		return x.nodevalue;
	}


	 public String Tree_Maximum() {
		SplayTreeNode x = root;
		if(root == null) return null;
		while(x.getRight() != null) x = x.getRight();
		Splay(x.nodevalue);
		return x.nodevalue;
	 }


	 public String Splay_Search(String str) {
		 if (root == null) return null;
		 Splay(str);
		 if(root.nodevalue.compareTo(str) != 0) return null;
		 return root.nodevalue;
	 }


	 private void Splay(String str) {
		 SplayTreeNode left, right, T, y;
		 left = right = header;
		 T = root;
		 header.setLeft(null);
		 header.setRight(null);
		 for (;;) {
			 if (str.compareTo(T.nodevalue) < 0) {
				 if (T.getLeft() == null)
					 break;
				 if (str.compareTo(T.getLeft().nodevalue) < 0) {
					 y = T.getLeft();                            
					 T.setLeft(y.getRight());
					 y.setRight(T);
					 T = y;
					 if (T.getLeft() == null) 
						 break;
				 }
				 right.setLeft(T);                                 
				 right = T;
				 T = T.getLeft();
			 } else if (str.compareTo(T.nodevalue) > 0) {
				 if (T.getRight() == null) 
					 break;
				 if (str.compareTo(T.getRight().nodevalue) > 0) {
					 y = T.getRight();                            
					 T.setRight(y.getLeft());
					 y.setLeft(T);
					 T = y;
					 if (T.getRight() == null) 
						 break;
				 }
				 left.setRight(T);                                
				 left = T;
				 T = T.getRight();
			 } 
			 else 
				 break;
		 }
		 left.setRight(T.getLeft());                                   
		 right.setLeft(T.getRight());
		 T.setLeft(header.getRight());
		 T.setRight(header.getLeft());
		 root = T;
	 }

	 private int InOrder(SplayTreeNode n,int i){

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
	 
	 public int Height()
	    {
	    	int hgt = 0;	
	    	HashMap<SplayTreeNode, Integer> visit = new HashMap<SplayTreeNode, Integer>();
	    	Stack<SplayTreeNode> st = new Stack<SplayTreeNode>(); 
	    	Stack<Integer> st1 = new Stack<Integer>(); 
	    	SplayTreeNode cur = root;
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
