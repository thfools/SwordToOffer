import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
	static public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length != in.length || pre.length == 0){
        	return null;
        }
        TreeNode tree = new TreeNode(pre[0]);
        int root_index;
        for(root_index = 0; root_index < in.length; root_index++){
        	if(in[root_index] == pre[0]){
        		tree.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + root_index), Arrays.copyOfRange(in, 0, root_index));
                tree.right = reConstructBinaryTree(Arrays.copyOfRange(pre, root_index + 1, in.length), Arrays.copyOfRange(in, root_index + 1, in.length));
                break;
        	}
        }
        return tree;
    }
	static List<Integer> list = new ArrayList<Integer>();
	static public List<Integer> inorderTraversal(TreeNode root) {
        
        if(root != null){
        	if(root.left != null){
        		inorderTraversal(root.left);
        	}
        	list.add(root.val);
        	if(root.right != null){
        		inorderTraversal(root.right);
        	}
        }
        return list;
    }
	
	static public List<Integer> preorderTraversal(TreeNode root) {
        
        if(root != null){
        	list.add(root.val);
        	
        	if(root.left != null){
        		preorderTraversal(root.left);
        	}
        	
        	if(root.right != null){
        		preorderTraversal(root.right);
        	}
        }
        return list;
    }
	
	static public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
        	return null;
        }
		
		postorderTraversal(root.left);
		postorderTraversal(root.right);
    	list.add(root.val);
        return list;
    }
	
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		System.out.println(postorderTraversal(reConstructBinaryTree(pre,in)));
	}
}
