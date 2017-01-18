----------------------
Command Line Arguments
----------------------
1) Open a Terminal
2) Change your directory to ksooji. 
3) Type "./build.sh" - Contains a statement to compile all the Java files under "ksooji" folder. (without the "")
4) Run the Program with the following arguments.
	
	java Ksooji -f inputfile.txt -d data-structure -h -p
	
	inputfile (Mandatory Argument)- Provide the file name as the input file for the program.
	
	data-structure (Mandatory Argument)- The program implements the following data structure.
		bst - Binary Search Tree.
		rbtree - Red Black Tree.
		skiplist - Skip List.
		splaytree - Splay Tree.
		
	-h (Optional Argument) - Include the option in the command line to get the height of the Tree. (This option is not valid for Skip List)
	
	-p (Optional Argument) - Include the option in the command line to print the Elements.


----------------
Design Decisions
----------------

The data structures that are implemented are :

1) Binary Search Tree : 
	
	BSTreeNode.java - Java file that creates the node and operations over the tree object.
	
	BST.java - Java file that implements binary search tree and its functionalities.
		BST_Insert : Inserts a node into the Binary Tree. Also, validates the inserting node with the duplications.
		BST_Delete : Deletes a node into the Binary Tree. Also, validates the deleting node with the duplications.
		BST_Minimum : Returns the minimum leaf of the tree.
		BST_Transplant : Transplantation is required after deleting a node which is performed. 
		BST_Search : The node in interest is being searched and returned.
		InOrder : To print the nodes, Tree needs to be traversed.
		Height : Returns the height of the tree.
	
2) Red Black Tree : 
	
	RBTreeNode.java - Java file that creates the tree node and operations over the tree object.
	
	RBT.java - Java file that implements binary search tree and its functionalities.
		RBT_Insert : Inserts a node into the Tree. Also, validates the inserting node with the duplications.
		RBT_Delete : Deletes a node into the Tree. Also, validates the deleting node with the duplications.
		RBT_Left_Rotate : Rotations needs to be performed in RB tree after insertion or deletion.
		RBT_Right_Rotate : Rotations needs to be performed in RB tree after insertion or deletion.
		RBT_Minimum : Returns the minimum leaf of the tree.
		RBT_Transplant : Transplantation is required after deleting a node which is performed. 
		RBT_Insert_FixUp : Insertion needs to be fixed in order to have the colours of the node reset.
		RBT_Delete_FixUp : Deletion needs to be fixed in order to have the colours of the node reset.		
		RBT_Search : The node in interest is being searched and returned.
		InOrder : To print the nodes, Tree needs to be traversed.
		Height : Returns the height of the tree.
	
	
3) Skip List : 
	
	SLNode.java - Java file that creates the node and operations over the List object.
	
	SkipList.java - Java file that implements binary search tree and its functionalities.
		Skip_Insert : Inserts a node into the List. Also, validates the inserting node with the duplications.
		Skip_Delete : Deletes a node into the List. Also, validates the deleting node with the duplications.
		Skip_Search : The node in interest is being searched and returned.
		Print : To print the nodes, List needs to be traversed.
		NodeCount : Returns the number of nodes of the list.
		Height : Returns the height of the tree.

		
4) Splay Tree : 
	
	SplayTreeNode.java - Java file that creates the tree node and operations over the tree object.
	
	SplayTree.java - Java file that implements splay tree and its functionalities.
		Splay_Insert : Inserts a node into the Splay Tree. Also, validates the inserting node with the duplications.
		Splay_Delete : Deletes a node into the Splay Tree. Also, validates the deleting node with the duplications.
		Tree_Minimum : Returns the minimum leaf of the tree.
		Tree_Maximum : Returns the maximum leaf of the tree.
		BST_Transplant : Transplantation is required after deleting a node which is performed. 
		Splay_Search : The node in interest is being searched and returned.
		InOrder : To print the nodes, Tree needs to be traversed.
		Height : Returns the height of the tree.
		
--------------		
Program Output
--------------		

The programs provides the output as per the input given through the command line.
The Running time of each program will be printed in MILLISECONDS.