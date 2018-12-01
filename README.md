* [数据结构相关](#数据结构相关)
   * [树](#树)
        * [递归](#递归)
        * [层次遍历](#层次遍历)


## 树
### 递归
一颗树,要么是空树,要么有两个指针,每个指针指向一棵树.树是一种递归结构,很多树的问题可以使用递归来解决!

**二叉树的中序遍历**

[leetcode94.二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/)

难度级别: 中等

递归实现
```java
        public static List<Integer> res;

        public List<Integer> inorderTraversal(TreeNode root) {
            res = new ArrayList<>();
            inOrderTraversal(root);
            return res;
        }

        private void inOrderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrderTraversal(root.left);
            res.add(root.val);
            inOrderTraversal(root.right);
        }
```

二叉树中序遍历非递归实现,数据结构:栈
```java
        public static List<Integer> res;
        public List<Integer> inorderTraversal(TreeNode root) {
            res = new ArrayList<>();
            inOrderTraversal(root);
            return res;
        }

        private void inOrderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    res.add(root.val);
                    root = root.right;
                }
            }
            System.out.println();
        }
```


**对称二叉树**

[leetcode101.对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/description/)

[对称二叉树的讲解](https://leetcode-cn.com/articles/symmetric-tree/)

难度级别: 简单

对称二叉树的递归实现
```java
  public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return true;
            }
            if (t1 == null || t2 == null) {
                return false;
            }

            if (t1.val != t2.val) {
                return false;
            }

            return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
        }
```

对称二叉树的非递归实现,数据结构:队列(bfs)

```java
public boolean isSymmetric(TreeNode root) {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode t1 = queue.poll();
                TreeNode t2 = queue.poll();
                if (t1 == null && t2 == null) {
                    continue;
                }
                if (t1 == null || t2 == null) {
                    return false;
                }

                if (t1.val != t2.val) {
                    return false;
                }

                queue.add(t1.left);
                queue.add(t2.right);
                queue.add(t1.right);
                queue.add(t2.left);
            }
            return true;
        }
```
两种实现方法的时间复杂度为: O(n),空间复杂度: O(n)


**树的高度**

[leetcode104.二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/)

[二叉树的最大深度讲解](https://leetcode-cn.com/articles/maximum-depth-of-binary-tree/)

难度级别: 简单


求二叉树的最大深度递归实现
```java
 public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
        }
```

求二叉树最大深度的非递归实现,用栈来实现,其中用到了Pair<K,V>,键值对映射.在javafx.util.Pair包中,需要导入!
```java
 private int depth = 0;

        public int maxDepth(TreeNode root) {

            Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
            if (root != null) {
                stack.add(new Pair<>(root, 1));
            }

            int depth = 0;
            while (!stack.isEmpty()) {
                Pair<TreeNode, Integer> current = stack.poll();
                root = current.getKey();
                int cur_depth = current.getValue();
                if (root != null) {
                    depth = Math.max(depth, cur_depth);
                    stack.add(new Pair<>(root.left, cur_depth + 1));
                    stack.add(new Pair<>(root.right, cur_depth + 1));
                }
            }
            return depth;
        }
```

**平衡二叉树**

[leetcode110.平衡二叉树 ](https://leetcode-cn.com/problems/balanced-binary-tree/description/)

难度级别: 简单

```html
    3
   / \
  9  20
    /  \
   15   7
```
> true

```html
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```
> false

平衡树左右子树的高度差的绝对值不超过1,即小于等于1

```java
private boolean res = true;

        public boolean isBalanced(TreeNode root) {
            maxDepth(root);
            return res;
        }

        private int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            if (Math.abs((left - right)) > 1) {
                res = false;
            }
            return 1 + Math.max(left, right);
        }
```

**平衡二叉树**

[leetcode110.平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/description/)

难度级别: 简单

平衡二叉树: 平衡树的左右子树的高度差的绝对值小于等于1

平衡二叉树的递归实现
```java
        private boolean res = true;

        public boolean isBalanced(TreeNode root) {
            maxDepth(root);
            return res;
        }

        private int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            if (Math.abs((left - right)) > 1) {
                res = false;
            }
            return 1 + Math.max(left, right);
        }
```

**求二叉树的最小深度**

[leetcode111.二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/)

二叉树的最小深度递归实现

难度级别: 简单

写法一
```java
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (left == 0 || right == 0) {
                return left + right + 1;
            }
            return Math.min(left, right) + 1;
        }
```
写法二
```java
        public int minDepth(TreeNode root) {
            return dfs(root);
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //若不考虑以下两种情况,leetcode测试用例只能过去一部分
            if (root.left == null) {
                return 1 + minDepth(root.right);
            }
            if (root.right == null) {
                return 1 + minDepth(root.left);
            }
            return 1 + Math.min(dfs(root.left), dfs(root.right));
        }
```
时间复杂度:O(n) ,n为节点的个数;
空间复杂度:O(n) 


**路径的和**

[leetcode112.路径的和(判断是否存在路径和等于一个数)](https://leetcode-cn.com/problems/path-sum/description/)

难度级别: 简单

路径总和递归实现
```java
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null && root.val == sum) {
                return true;
            }

            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
```

**二叉树的前序遍历**

[leetcode144.二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/)

难度级别: 中等

递归实现
```java
        static List<Integer> res;

        public List<Integer> preorderTraversal(TreeNode root) {
            res = new ArrayList<>();
            preOrderTraversal(root);
            return res;
        }

        private void preOrderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }

            res.add(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
```

非递归实现,数据结构:栈
```java
        static List<Integer> res;

        public List<Integer> preorderTraversal(TreeNode root) {
            res = new ArrayList<>();
            preOrderTravsersal(root);
            return res;
        }

        private void preOrderTravsersal(TreeNode root) {
            if (root == null) {
                return;
            }

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                res.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
            System.out.println();
        }
```

**翻转二叉树**

[leetcode226.翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/description/)

难度级别:简单

递归实现
```java
        public TreeNode invertTree(TreeNode root) {
            if (root==null){
                return null;
            }

            TreeNode left = root.left;
            root.left = invertTree(root.right);
            root.right =invertTree(left);
            return root;
        }
```


**打家劫舍III**

[leetcode337.打家劫舍III(即间隔遍历)](https://leetcode-cn.com/problems/house-robber-iii/description/)

难度级别: 中等

递归实现

```java
        public int rob(TreeNode root) {

            if (root == null) {
                return 0;
            }
            int val1 = root.val;
            if (root.left != null) {
                val1 += rob(root.left.left) + rob(root.left.right);
            }
            if (root.right != null) {
                val1 += rob(root.right.left) + rob(root.right.right);
            }
            int val2 = rob(root.left) + rob(root.right);
            return Math.max(val1, val2);
        }
```

**左叶子之和**

[leetcode404.左叶子之和(即求左子树叶子节点的和)](https://leetcode-cn.com/problems/sum-of-left-leaves/description/)

难度级别: 简单

递归实现
```java
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (isLeaf(root.left)) {
                return root.left.val + sumOfLeftLeaves(root.right);
            }

            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }

        private boolean isLeaf(TreeNode root) {
            if (root == null) {
                return false;
            }
            return root.left == null && root.right == null;
        }
```

**路径总和**

[leetcode437.路径总和(即找出路径和等于给定数值的路径总数)](https://leetcode-cn.com/problems/path-sum-iii/description/)

难度级别: 简单

递归实现
```java
        public int pathSum(TreeNode root, int sum) {

            if (root == null) {
                return 0;
            }
            int res = pathSumWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
            return res;
        }

        private int pathSumWithRoot(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            int res = 0;
            if (root.val == sum) {
                res++;
            }
            res += pathSumWithRoot(root.left, sum - root.val) + pathSumWithRoot(root.right, sum - root.val);
            return res;
        }
```

**二叉树的直径**

[leetcode543.二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/description/)

难度级别: 简单

递归实现
```java
        private int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            maxDepth(root);
            return max;
        }

        private int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            max = Math.max(max, (leftDepth + rightDepth));
            return Math.max(leftDepth, rightDepth) + 1;
        }
```

**另一个树的子树**

[leetcode572.另一个树的子树(即在一个树中找另个一个树 )](https://leetcode-cn.com/problems/subtree-of-another-tree/description/)

难度级别: 简单

递归实现
```java
        public boolean isSubtree(TreeNode s, TreeNode t) {

            if (s == null) {
                return false;
            }
            if (t == null) {
                return false;
            }
            return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {

            if (s == null && t == null) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }
            if (t.val != s.val) {
                return false;
            }

            return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
        }
```

**合并两个二叉树**

[leetcode617.合并两个二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees/description/)

难度级别: 简单

递归实现
```java
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            return mergeTwoTrees(t1, t2);
        }

        private TreeNode mergeTwoTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            }
            if (t1 == null && t2 != null) {
                return t2;
            }
            if (t1 != null && t2 == null) {
                return t1;
            }

            TreeNode root = new TreeNode((t1.val + t2.val));
            root.left = mergeTwoTrees(t1.left, t2.left);
            root.right = mergeTwoTrees(t1.right, t2.right);
            return root;
        }
``` 

**求二叉树中的第二小的节点**

[leetcode671.二叉树中的第二小的节点](https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/description/)

难度级别: 简单

递归实现
```java
        public int findSecondMinimumValue(TreeNode root) {

            if (root == null) {
                return -1;
            }
            if (root.left == null && root.right == null) {
                return -1;
            }

            int leftVal = root.left.val;
            int rightVal = root.right.val;
            if (leftVal == root.val) {
                leftVal = findSecondMinimumValue(root.left);
            }
            if (rightVal == root.val) {
                rightVal = findSecondMinimumValue(root.right);
            }
            if (leftVal != -1 && rightVal != -1) {//左右节点都有第二最小值,求最小值
                return Math.min(leftVal, rightVal);
            }
            if (leftVal != -1) {//只有左边有,否则返回右边
                return leftVal;
            }
            return rightVal;

        }
```

**最长同值路径**

[leetcode687.最长同值路径](https://leetcode-cn.com/problems/longest-univalue-path/description/)

难度级别: 简单

递归实现
```java
        private int path = 0;

        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return path;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
            int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
            path = Math.max(path, (leftPath + rightPath));
            return Math.max(leftPath, rightPath);
        }
```


### 层次遍历

使用 BFS 进行层次遍历。不需要使用两个队列来分别存储当前层的节点和下一层的节点，因为在开始遍历一层的节点时，当前队列中的节点数就是当前层的节点数，只要控制遍历这么多节点数，就能保证这次遍历的都是当前层的节点。

**一棵树每层节点的平均数**






