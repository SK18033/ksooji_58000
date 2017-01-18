
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ksooji {

	public static void main(String[] args) {

		String[] line;
		
		RBT rbt = new RBT();
		BST bst = new BST();
		SkipList skl = new SkipList();
		SplayTree spl = new SplayTree();

		
		long startTimeI, stopTimeI, runTimeI = 0;
		long startTimeD, stopTimeD, runTimeD = 0;
		int flagI = 0 , flagD = 0, h_flag = 0, p_flag = 0;
		String f_arg = "" , d_arg = "" ;

		try {

			for (int i = 0 ; i<args.length; i++){

				if (args[i].equals("-f")){
					f_arg = args[i+1]; 
				}
				else if (args[i].equals("-d")){	
					d_arg = args[i+1];
				}
				else if (args[i].equals("-h")){
					h_flag = 1;
				}
				else if (args[i].equals("-p")){
					p_flag = 1;
				}

			}

			FileInputStream file = new FileInputStream( f_arg);

			InputStreamReader in = new InputStreamReader(file);
			BufferedReader br = new BufferedReader(in);

			line = br.readLine().split("\t");

			switch(d_arg){

			case "bst":

				while (line != null ){

					String key="";

					for(int i=1; i < line.length ;i++){
						key = key + line[i] + "\t";
					}
					key.trim();


					switch(line[0]){

					case "0" :
						startTimeD = System.currentTimeMillis();
						flagD = bst.BST_Delete(key);
						stopTimeD = System.currentTimeMillis(); 
						runTimeD += stopTimeD - startTimeD;
						if(h_flag == 1){
							System.out.println(bst.Height());
						}
						break;
						
					case "1" :
						startTimeI = System.currentTimeMillis();
						flagI = bst.BST_insert(key);
						stopTimeI = System.currentTimeMillis(); 
						runTimeI += stopTimeI - startTimeI;
						if(h_flag == 1){
							System.out.println(bst.Height());
						}
						break;
						
					default :
						System.out.println("Invalid Option, Please check the input file\n");
					}

					String s = br.readLine();

					if(s == null)
						break;
					line = s.split("\t");

				}

				if(p_flag == 1){
					System.out.println("BST In-Order Traversal : \n" );
					int count = bst.InOrderTraverse();
					System.out.println("Node Count : " + count + "\n");

				}

				if(h_flag == 1){
					System.out.println("Height is : " + bst.Height());
				}

				System.out.println("\n Binary Search Tree Run time is : " + (runTimeI + runTimeD) + " MilliSeconds\n" ); 
				
				in.close();
				break;

			case "rbtree":

				while (line != null ){

					String key="";

					for(int i=1; i < line.length ;i++){
						key = key + line[i] + "\t";
					}
					key.trim();


					switch(line[0]){

					case "0" :
						startTimeD = System.currentTimeMillis();
						flagD = rbt.RBT_Delete(key);
						stopTimeD = System.currentTimeMillis(); 
						runTimeD += stopTimeD - startTimeD;
						if(h_flag == 1){
							System.out.println(rbt.Height());
						}
						break;
						
					case "1" :
						startTimeI = System.currentTimeMillis();
						flagI = rbt.RBT_insert(key);
						stopTimeI = System.currentTimeMillis(); 
						runTimeI += stopTimeI - startTimeI;
						if(h_flag == 1){
							System.out.println(rbt.Height());
						}
						break;
						
					default :
						System.out.println("Invalid Option, Please check the input file\n");
					}

					String s = br.readLine();

					if(s == null)
						break;
					line = s.split("\t");

				}

				if(p_flag == 1){
					System.out.println("RBT In-Order Traversal : \n" );
					rbt.InOrderTraverse();
				}

				if(h_flag == 1){
					System.out.println("Height is : " + rbt.Height());
				}

				System.out.println("\n Red Black Tree Run time is : " + (runTimeI + runTimeD) + " MilliSeconds\n" ); 

				in.close();
				break;
			

			case "skiplist":

				while (line != null ){

					String key="";

					for(int i=1; i < line.length ;i++){
						key = key + line[i] + "\t";
					}
					key.trim();


					switch(line[0]){

					case "0" :
						startTimeD = System.currentTimeMillis();
						skl.Skip_Delete(key);
						stopTimeD = System.currentTimeMillis(); 
						runTimeD += stopTimeD - startTimeD;
						break;
						
					case "1" :
						startTimeI = System.currentTimeMillis();
						skl.Skip_Insert(key);
						stopTimeI = System.currentTimeMillis(); 
						runTimeI += stopTimeI - startTimeI;
						break;
						
					default :
						System.out.println("Invalid Option, Please check the input file\n");
					}

					String s = br.readLine();

					if(s == null)
						break;
					line = s.split("\t");

				}

				if (p_flag == 1){
					skl.Skip_Print();
					skl.NodeCount();
				}

				if(h_flag == 1){
					skl.Height();
				}
				
				System.out.println("\n Skip List Run time is : " + (runTimeI + runTimeD) + " MilliSeconds\n" ); 
				
				in.close();
				break;
				
			case "splaytree" :
				
				while (line != null ){
					
					String key="";
					
					for(int i=1; i < line.length ;i++){
						key = key + line[i] + "\t";
					}
					key.trim();				
				
					switch(line[0]){
					
					case "0" :
						startTimeD = System.currentTimeMillis();
						spl.Splay_Delete(key);
					    stopTimeD = System.currentTimeMillis(); 
					    runTimeD += stopTimeD - startTimeD;
					    if(h_flag == 1){
							System.out.println(spl.Height());
						}
						break;
						
					case "1" :
						startTimeI = System.currentTimeMillis();
						spl.Splay_Insert(key);
					    stopTimeI = System.currentTimeMillis(); 
					    runTimeI += stopTimeI - startTimeI;
					    if(h_flag == 1){
							System.out.println(spl.Height());
						}
						break;
						
					default :
						System.out.println("Invalid Option, Please check the input file\n");
					}

					String s = br.readLine();
					if(s == null)
						break;
					line = s.split("\t");

				}	
				
				System.out.println("SPL In-Order Traversal : \n" );
				int count = spl.InOrderTraverse();
				
				System.out.println("Number of Nodes : " + count );
				System.out.println("\nSplay Tree Tree Run time is : " + (runTimeI + runTimeD) + " MilliSeconds\n" );
				
				in.close();
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found , Please check the input file\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception\n");
			e.printStackTrace();
		} catch (NullPointerException e){
			e.printStackTrace();
		}
	}

}