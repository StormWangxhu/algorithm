* [数据结构相关](#数据结构相关)
   * [树](#树)
        * [递归](#递归)


## 树
### 递归
一颗树,要么是空树,要么有两个指针,每个指针指向一棵树.树是一种递归结构,很多树的问题可以使用递归来解决!

**树的高度**

[leetcode104.二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/)

[二叉树的最大深度讲解](https://leetcode-cn.com/articles/maximum-depth-of-binary-tree/)

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

**对称二叉树**

[leetcode101.对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/description/)

[对称二叉树的讲解](https://leetcode-cn.com/articles/symmetric-tree/)

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

对称二叉树的非递归实现,采用队列数据结构

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