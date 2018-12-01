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