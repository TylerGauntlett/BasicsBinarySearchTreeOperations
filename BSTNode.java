// Name: Tyler Gauntlett
// Date: 2/11/2016
// Course: COP3503C-16Spring 0001
// NID: ty340586

public class BSTNode {
	BSTNode m_objLeftNode, m_objRightNode;
	int m_nKeyValue;
	private int kTime;

	public BSTNode() {
		// Explicit set to null may not be necessary,
		// but provided for clarity.
		m_objLeftNode = m_objRightNode = null;

		// Set this node's key value to default of 0.
		m_nKeyValue = 0;

		// Set the kTime test default.
		setkTime(3);
	}

	public BSTNode(int nKeyValue) {
		// Explicit set to null may not be necessary,
		// but provided for clarity.
		m_objLeftNode = m_objRightNode = null;

		// Set this node's key value
		m_nKeyValue = nKeyValue;

		// Set the kTime test default.
		setkTime(3);
	}

	// Accessor method to set the left node.
	public void SetLeftNode(BSTNode objLeftNode) {
		// Assign the left node object reference.
		m_objLeftNode = objLeftNode;
	}

	// Accessor method to set the right node.
	public void SetRightNode(BSTNode objRightNode) {
		// Assign the right node object reference.
		m_objRightNode = objRightNode;
	}

	// Accessor method to get the left node object.
	public BSTNode GetLeftNode() {
		// Return the object.
		return (m_objLeftNode);
	}

	// Accessor method to get the right node object.
	public BSTNode GetRightNode() {
		// Return the object.
		return (m_objRightNode);
	}

	// Accessor method to set the node's key value.
	public void SetKeyValue(int nKeyValue) {
		// Set the value.
		m_nKeyValue = nKeyValue;
	}

	// Accessor method to get the node's key value.
	public int GetKeyValue() {
		// Return the value.
		return (m_nKeyValue);
	}

	// Accessor method to get the kTime.
	int getkTime() {
		return kTime;
	}

	// Accessor method to set the kTime.
	void setkTime(int kTime) {
		this.kTime = kTime;
	}

	// Function that returns the size of the subtree at a given node.
	public int getSubtreeSize(BSTNode objNode) {
		if (objNode == null)
			return 0;

		return 1 + getSubtreeSize(objNode.GetLeftNode()) + getSubtreeSize(objNode.GetRightNode());
	}

	// Function that returns the minimum value of a tree.
	public int getMin(BSTNode objNode) {
		if (objNode.GetLeftNode() == null)
			return objNode.GetKeyValue();

		return getMin(objNode.GetLeftNode());
	}

	// Function that returns the minimum value of a tree.
	public int getMax(BSTNode objNode) {
		if (objNode.GetRightNode() == null)
			return objNode.GetKeyValue();

		return getMax(objNode.GetRightNode());
	}

	// Print tree for testing purposes.
	public void printTree(BSTNode objNode) {
		if (objNode == null)
			return;

		printTree(objNode.GetLeftNode());
		System.out.print(objNode.GetKeyValue() + " ");
		printTree(objNode.GetRightNode());
	}

	// Finds and returns the parent node based on a given value.
	public BSTNode getParent(int nKeyValue, BSTNode objNode) {
		// Check if the tree has no elements.
		if (objNode == null)
			return null;
		// This is for the condition when the tree has 1 value.
		if (objNode.GetKeyValue() == nKeyValue) {
			return null;
		}
		// Checks if the left child is existent and equal to the search value.
		else if (objNode.GetLeftNode() != null && objNode.GetLeftNode().GetKeyValue() == nKeyValue) {
			return objNode;
		}
		// Checks if the right child is existent and equal to the search value.
		else if (objNode.GetRightNode() != null && objNode.GetRightNode().GetKeyValue() == nKeyValue) {
			return objNode;
		}
		// Recursive call left.
		else if (objNode.GetKeyValue() > nKeyValue) {
			return objNode.getParent(nKeyValue, objNode.GetLeftNode());
		}
		// Recursive call right.
		else {
			return objNode.getParent(nKeyValue, objNode.GetRightNode());
		}
	}

	// Set the first node to be the second node.
	public BSTNode setParent(BSTNode objOriginalNode, BSTNode objReplacementNode, BSTNode objRoot) {
		// Check if either nodes are null.
		if (objOriginalNode == null || objReplacementNode == null)
			return null;
		// Check if its a acceptable fit for the location.
		if (objOriginalNode.GetLeftNode().GetKeyValue() > objReplacementNode.GetKeyValue()
				|| objOriginalNode.GetRightNode().GetKeyValue() < objReplacementNode.GetKeyValue()) {
			return objRoot;
		}
		// Recursively search for the value.
		if (objOriginalNode.GetKeyValue() < objRoot.GetKeyValue()) {
			objRoot.SetLeftNode(setParent(objOriginalNode, objReplacementNode, objRoot.GetLeftNode()));
		} else if (objOriginalNode.GetKeyValue() > objRoot.GetKeyValue()) {
			objRoot.SetRightNode(setParent(objOriginalNode, objReplacementNode, objRoot.GetRightNode()));
		}
		// Check if the current root node is equal to the original node.
		if (objRoot.GetKeyValue() == objOriginalNode.GetKeyValue()) {
			// Replace the value at the current node with the replacement value.
			objRoot.SetKeyValue(objReplacementNode.GetKeyValue());
		}

		return objRoot;

	}
}
