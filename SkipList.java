
public class SkipList {

	public static final double P = 0.5;
	public static final int MAX = 16;
	public final SLNode header = new SLNode(MAX, null);

	public int level = 0;

	public static int Random() {
		int rlevel = (int)(Math.log(1.-Math.random())/Math.log(1.-P));
		return Math.min(rlevel, MAX);
	}


	public void Skip_Insert(String str){
		SLNode x = header;	
		SLNode[] updt = new SLNode[MAX + 1];

		for (int i = level; i >= 0; i--) {
			while (x.getFwd()[i] != null && x.getFwd()[i].getNodevalue().compareTo(str) < 0) {
				x = x.getFwd()[i];
			}
			updt[i] = x; 
		}
		x = x.getFwd()[0];

		if (x == null || !x.getNodevalue().equals(str)) {        
			int rlevel = Random();

			if (rlevel > level) {
				for (int i = level + 1; i <= rlevel; i++) {
					updt[i] = header;
				}
				level = rlevel;
			}
			x = new SLNode(rlevel, str);
			for (int i = 0; i <= rlevel; i++) {
				x.getFwd()[i] = updt[i].getFwd()[i];
				updt[i].getFwd()[i] = x;
			}
		}
	}

	public void Skip_Delete(String str){
		SLNode x = header;	
		SLNode [] updt = new SLNode[MAX + 1];

		for (int i = level; i >= 0; i--) {
			while (x.getFwd()[i] != null && x.getFwd()[i].getNodevalue().compareTo(str) < 0) {
				x = x.getFwd()[i];
			}
			updt[i] = x; 
		}
		x = x.getFwd()[0];

		if (x.getNodevalue().equals(str)) {
			for (int i = 0; i <= level; i++) {
				if (updt[i].getFwd()[i] != x)
					break;
				updt[i].getFwd()[i] = x.getFwd()[i];
			}
			while (level > 0 && header.getFwd()[level] == null) {
				level--;
			}
		}
	}

	public boolean Skip_Search(String str){
		SLNode x = header;
		for (int i = level; i >= 0; i--) {
			while (x.getFwd()[i] != null && x.getFwd()[i].getNodevalue().compareTo(str) < 0) {
				x = x.getFwd()[i];
			}
		}
		x = x.getFwd()[0];
		return x != null && x.getNodevalue().equals(str);
	}

	public void Skip_Print()
	{
		StringBuilder strbld = new StringBuilder();
		SLNode n = header.getFwd()[0];
		while (n != null) {
			strbld.append(n.getNodevalue());
			n = x.getFwd()[0];
			if (n != null)
				strbld.append("\n");
		}    
		System.out.println(strbld.toString());
	}
	
	public void NodeCount()
	{
		int i=1;
		SLNode n = header.getFwd()[0];
		while (n != null) {
			n = n.getFwd()[0];
			if (n != null){
				i++;
			}
		}    
		System.out.println("The SKIP LIST Node Count is : " + i);
	}
	
	public void Height() {
		System.out.println("Height is the Skip List is :" + level);
	}
}
