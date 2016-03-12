// Name: Tyler Gauntlett
// Date: 2/11/2016
// Course: COP3503C-16Spring 0001
// NID: ty340586

public class BST {
	// This is the root node, which starts off as null
	// when the BST is empty.
	BSTNode m_objRootNode;

	// Class constructor.
	public BST() {
		// Not really necessary, provided for clarity.
		m_objRootNode = null;
	}

	// Method to see if the tree is empty.
	public boolean IsEmpty() {
		// Return a boolean indicating whether the
		// three is empty or not.
		return (m_objRootNode == null);
	}

	/* Functions to search for an element */
	public BSTNode Search(int nKeyValue) {
		return (Search(m_objRootNode, nKeyValue));
	}

	// Method to search for an element recursively.
	private BSTNode Search(BSTNode objNode, int nKeyValue) {
		if (objNode == null) {
			return (null);
		}

		// First, we get the key value for this node.
		int nThisKeyValue = objNode.GetKeyValue();

		// See if the passed in key value is less. If so,
		// this indicates that we need to go left.
		if (nKeyValue < nThisKeyValue) {
			// Get the left node object reference so we
			// can walk down it.
			objNode = objNode.GetLeftNode();
		}

		// See if the passed in key value is greater. If so,
		// this indicates that we need to go right.
		else if (nKeyValue > nThisKeyValue) {
			// Get the right node object reference so we
			// can walk down it.
			objNode = objNode.GetRightNode();
		}

		// Here we have found the node with the key
		// value that was passed in.
		else {
			return (objNode);
		}

		// Now call Search recursively.
		return (Search(objNode, nKeyValue));
	}

	// This method inserts a node based on the key value.
	public void Insert(int nKeyValue) {
		if (passKTimesTest(nKeyValue, m_objRootNode)) {
			// The root node is returned to m_objRootNode from Insert()
			m_objRootNode = Insert(nKeyValue, m_objRootNode);
		} else
			return;
	}

	// Class protected (internal) method to insert nodes. This method
	// will be called recursively.
	protected BSTNode Insert(int nKeyValue, BSTNode objNode) {

		// This node is null and simply needs to be allocated.
		if (objNode == null) {
			objNode = new BSTNode(nKeyValue);
		}

		// Here we need to walk left and check that the left node is within k
		// units of the
		// value being inserted.
		else if (nKeyValue < objNode.GetKeyValue() && passKTimesTest(nKeyValue, objNode.GetLeftNode())) {
			// Set the left node of this object by recursively walking left.
			objNode.SetLeftNode(Insert(nKeyValue, objNode.GetLeftNode()));
		}

		// Here we need to walk right and check that the right node is within k
		// units of the
		// value being inserted.
		else if (nKeyValue > objNode.GetKeyValue() && passKTimesTest(nKeyValue, objNode.GetRightNode())) {
			// Set the right node of this object by recursively walking right.
			objNode.SetRightNode(Insert(nKeyValue, objNode.GetRightNode()));
		}

		return (objNode);
	}

	// Helper function to access the subTreeSize from BSTNode class.
	public int getSubtreeSize() {
		return m_objRootNode.getSubtreeSize(m_objRootNode);
	}

	// Helper function to access the getMin from BSTNode class.
	public int getMin() {
		return m_objRootNode.getMin(m_objRootNode);
	}

	// Helper function to access the getM from BSTNode class.
	public int getMax() {
		return m_objRootNode.getMax(m_objRootNode);
	}

	// Returns the note in the root of the true.
	public BSTNode getRootNode() {
		return m_objRootNode;
	}

	// Print tree for testing purposes
	public void printTree() {
		m_objRootNode.printTree(m_objRootNode);
	}

	// Helper function for calling getParent.
	public BSTNode getParent(int nKeyValue) {
		return (getParent(nKeyValue, m_objRootNode));
	}

	// Function that calls the getParent function in the BSTNode class.
	public BSTNode getParent(int nKeyValue, BSTNode objNode) {
		return objNode.getParent(nKeyValue, objNode);
	}

	// Function that calls the setParent function in the BSTNode class.
	public BSTNode setParent(BSTNode objOriginalNode, BSTNode objReplacementNode) {
		return m_objRootNode = m_objRootNode.setParent(objOriginalNode, objReplacementNode, m_objRootNode);
	}

	// Function that returns true if all nodes are at least
	// k units away from each other.
	public boolean passKTimesTest(int nKeyValue, BSTNode objNode) {
		if (objNode == null)
			return true;
		else if (Math.abs(nKeyValue - objNode.GetKeyValue()) >= objNode.getkTime()) {
			return true;
		} else
			return false;
	}

	// Helper function that calls rank based on a int input.
	public int getRank(int nKeyValue) {
		return (getRank(m_objRootNode, nKeyValue));
	}

	// Helper function that calls rank based on a BSTNode input.
	public int getRank(BSTNode objNode) {
		return (getRank(m_objRootNode, objNode.GetKeyValue()));
	}

	// Rank function that returns the number of nodes smaller
	// than a given value or node. Returns 0 for the lowest element and so on.
	private int getRank(BSTNode m_objRootNode, int nKeyValue) {
		int rank = 0;
		// Iterate through while it still contains values.
		while (m_objRootNode != null) {
			// If value is smaller than current node, go left.
			if (nKeyValue < m_objRootNode.GetKeyValue()) {
				m_objRootNode = m_objRootNode.GetLeftNode();
				// If value is largest than current node, go left.
			} else if (nKeyValue > m_objRootNode.GetKeyValue()) {
				rank += 1 + m_objRootNode.getSubtreeSize(m_objRootNode.GetLeftNode());
				m_objRootNode = m_objRootNode.GetRightNode();
				// If its equal, return the subtree.
			} else
				return rank + m_objRootNode.getSubtreeSize(m_objRootNode.GetLeftNode());
		}
		return rank;
	}

	// Helper function using a int as a param.
	public void Delete(int nKeyValue) {
		m_objRootNode = Delete(m_objRootNode, nKeyValue);
	}

	// Helper function using a node as a param.
	public void Delete(BSTNode objNode) {
		m_objRootNode = Delete(m_objRootNode, objNode.GetKeyValue());
	}

	// Deletes a specified value from the tree.
	protected BSTNode Delete(BSTNode objNode, int nKeyValue) {
		if (objNode == null)
			return null;
		// If the value is too small, recursively set the left side using the
		// left node.
		if (nKeyValue < objNode.GetKeyValue()) {
			objNode.SetLeftNode(Delete(objNode.GetLeftNode(), nKeyValue));
		}
		// If the value is too large, recursively set the right side using the
		// right node.
		else if (nKeyValue > objNode.GetKeyValue()) {
			objNode.SetRightNode(Delete(objNode.GetRightNode(), nKeyValue));
		}
		// If the current node has 2 children
		else if (objNode.GetLeftNode() != null && objNode.GetRightNode() != null) {
			// Set the value equal to the minimum value of the right subtree.
			objNode.SetKeyValue(objNode.getMin(objNode.GetRightNode()));
			// Set the right tree equal to a recursive call.
			objNode.SetRightNode(Delete(objNode.GetRightNode(), objNode.GetKeyValue()));
		}
		// Ternary operator used to decide what to set the remain tree to before
		// returning.
		else
			objNode = (objNode.GetLeftNode() != null) ? objNode.GetLeftNode() : objNode.GetRightNode();

		return objNode;
	}
}
