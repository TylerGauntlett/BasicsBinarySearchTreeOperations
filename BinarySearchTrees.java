
// Name: Tyler Gauntlett
// Date: 2/11/2016
// Course: COP3503C-16Spring 0001
// NID: ty340586

public class BinarySearchTrees 
{
	
	static BST m_objBST = new BST();
	
	public static void main(String[] args) 
	{
		BSTNode ogNode = new BSTNode();
		BSTNode replaceNode = new BSTNode(14);
		
		m_objBST.Insert(12);
		m_objBST.Insert(6);
		m_objBST.Insert(3);
		m_objBST.Insert(9);
		m_objBST.Insert(20);
		
		ogNode = m_objBST.Search(12);
		
		
//		if(newNode != null)
//		System.out.println(newNode.GetKeyValue());
//
//		if(newNode != null)
//		System.out.println(m_objBST.getRank(newNode));
		
//		m_objBST.printTree();
		
		System.out.println();
//		System.out.println(m_objBST.getRank(newNode));
		
//		m_objBST.setParent(ogNode, replaceNode);
		
		System.out.println(m_objBST.getRank(12));
		
		if(m_objBST == null){
			System.out.println("The entire tree is null.");
		}
		else{
			m_objBST.printTree();
		}
		
	}
	
	
}
