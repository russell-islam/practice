package practice;

import java.util.ArrayList;

public class NAryTree {
	public NAryNode root;

    public NAryTree(int kArity)
    {
        root.maxNrOfChildren=kArity;        
    }

    public void addRoot(int info)
    {
        root=new NAryNode(info);
        root.parent=null;
        root.children=new ArrayList<NAryNode>(root.maxNrOfChildren);
    }

    public void addNewNodeVasithChildOfNodeU(NAryNode u, int info, int i)
    {
    	NAryNode child=new NAryNode(info);
        u.addChild(child, i);
    }
    public int numberOfNodesInTree(NAryNode rootNode){
        int count=0;

        count++;
        if(rootNode.children.size()!=0) {
            for(NAryNode ch : rootNode.children)
                count=count+numberOfNodesInTree(ch);
        }

        return count;
    }

    public int numberOfNodesInTree()
    {
        return numberOfNodesInTree(this.root);
    }

    public void changeRoot(NAryNode newRoot, int i)
    {
    	NAryNode oldRoot=this.root;
        newRoot.parent=null;
        newRoot.addChild(oldRoot, i);
        oldRoot.parent=newRoot;
        this.root=newRoot;
    }
    
}
class NAryNode {
	public NAryNode parent; // The parent of the current node
    public ArrayList<NAryNode> children; // The children of the current node
    public int key;

    public int maxNrOfChildren; // Equal to the k-arity; 

    public NAryNode (int k)
    {
        this.key=k; 
        children  = new ArrayList<NAryNode>(maxNrOfChildren);
    }

    public void addChild(NAryNode childNode, int position)
    // You must take care so that future insertions don't override a child on i-th position
    {
        if(position>=maxNrOfChildren-1)
        {
            // Throw some error
        }

        else
        {
            System.out.println("this.children="+this.children);
            if(this.children.get(position)!=null)
            {
                // There is alerady a child node on this position; throw some error;
            }
            else
            {
                childNode.parent=this;
                this.children.set(position, childNode);
            }
        }
    }
    public void addChild(NAryNode child) {
    	for (int i = 0; i < maxNrOfChildren; i++)
    	{
    		if (this.children.get(i) == null)
    		{
    			this.children.set(i, child);
    		}
    	}
    }
    public boolean isMostRight(NAryNode child) {
    	int ind = this.children.indexOf(child);
    	int total = this.children.size();
    	if (ind >= total -1)
    	{
    		for(int i = ind + 1; i < maxNrOfChildren; i++)
    		{
    			if(this.children.get(i) != null)
    				return false;
    		}
    		return true;
    	}
    	return false;
    }
    public boolean hasMoreRight(NAryNode child) {
    	return !this.isMostRight(child);
    }
    public NAryNode getRight(NAryNode left)
    {
    	int ind = this.children.indexOf(left);
    	int total = this.children.size();
    	if (ind >= total -1)
    	{
    		for(int i = ind + 1; i < maxNrOfChildren; i++)
    		{
    			if(this.children.get(i) != null)
    				return this.children.get(i);
    		}
    		return null;
    	}
    	return null;
    }
}
