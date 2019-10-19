import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    
	public static void topView(Node root) 
    {
        class queueobj
        {
            Node node;
            int hd;

            queueobj(Node node,int hd)
            {
                this.node=node;
                this.hd=hd;
            }
        }
        Queue<queueobj> q=new LinkedList<queueobj>();
        Map<Integer,Node>m=new TreeMap<Integer,Node>();

        if(root==null)
            return;
        else
            q.add(new queueobj(root,0));
        
        while(!q.isEmpty())
        {
            queueobj temp=q.poll();

            if(!m.containsKey(temp.hd))
            {
                m.put(temp.hd,temp.node);
            }
            if(temp.node.left!=null)
            {
                 q.add(new queueobj(temp.node.left,temp.hd-1));
            }
            if(temp.node.right!=null)
            {
                 q.add(new queueobj(temp.node.right,temp.hd+1));
            }
        }
        for(Map.Entry<Integer,Node> t:m.entrySet())
        {
            System.out.printf("%d ",t.getValue().data);
        }
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}