public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        int last1 = -1;
        int last2 = -1;

        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root1);
        Stack<TreeNode> s2 = new Stack<>();
        s2.push(root2);

        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()){
                TreeNode cur = s1.pop();
                while(cur != null){

                    if(cur.left != null){
                        s1.push(cur.left);
                    }
                    if(cur.left == null && cur.right == null){
                        last1 = cur.val;
                        break;
                    }
                    if(cur.right != null){
                        s1.push(cur.right);
                    }
                    cur = s1.pop();
                }
            }
            if(!s2.isEmpty()){
                TreeNode cur = s2.pop();
                while(cur != null){
                    if(cur.left != null){
                        s2.push(cur.left);
                    }
                    if(cur.left == null && cur.right == null){
                        last2 = cur.val;
                        // System.out.println("last1 : " + last1 + " last2 : " + last2);
                        if(last1 != last2){
                            return false;
                        }else{
                            last1 = -1;
                            last2 = -1;
                            break;
                        }
                    }
                    if(cur.right != null){
                        s2.push(cur.right);
                    }
                    cur = s2.pop();
                }
            }
        }

        return last1 == last2;
    }
}
