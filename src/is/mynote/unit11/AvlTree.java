package is.mynote.unit11;

public class AvlTree<T extends Comparable<T>> {
    /**
     * 根节点
     */
    private AvlTreeNode<T> root;

    class AvlTreeNode<E extends Comparable<E>> {
        /**
         * 键、高度、左右子树
         */
        E key;
        int height;
        AvlTreeNode<E> left;
        AvlTreeNode<E> right;

        public AvlTreeNode(E key, AvlTreeNode<E> left, AvlTreeNode<E> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    private int height(AvlTreeNode<T> tree) {
        if (tree != null) {
            return tree.height;
        }
        return 0;
    }

    /**
     * 获取高度
     *
     * @return int
     */
    public int height() {
        return height(root);
    }

    /**
     * 比例两个值大小
     *
     * @param a value_a
     * @param b value_b
     * @return int
     */
    private int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * LL 情况
     *
     * @param k2
     * @return
     */
    private AvlTreeNode<T> leftLeftRotation(AvlTreeNode k2) {
        AvlTreeNode<T> k1;

        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;

        return k1;
    }
}
