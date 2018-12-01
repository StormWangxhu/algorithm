* [数据结构相关](#数据结构相关)
   * [树](#树)
        * [递归](#递归)


## 树
### 递归
一颗树,要么是空树,要么有两个指针,每个指针指向一棵树.树是一种递归结构,很多树的问题可以使用递归来解决!

**树的高度**

[leetcode104.二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/)

```java
 public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
        }
```

**平衡二叉树**

[leetcode110.平衡二叉树 ](https://leetcode-cn.com/problems/balanced-binary-tree/description/)

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