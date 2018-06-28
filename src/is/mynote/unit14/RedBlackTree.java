package is.mynote.unit14;


/**
 * 红黑树
 *
 * @author Neal
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private final static boolean RED = true;
    private final static boolean BLACK = false;
    private Node root;

    private class Node {
        /**
         * 键
         */
        Key key;
        /**
         * 值
         */
        Value value;
        /**
         * 左右子树
         */
        Node left, right;
        /**
         * 子树节点总数
         */
        int total;
        /**
         * 父节点指向该节点的颜色
         */
        boolean color;

        Node(Key key, Value value, int total, boolean color) {
            this.key = key;
            this.value = value;
            this.total = total;
            this.color = color;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.total;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color = RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.total = h.total;
        h.total = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.total = h.total;
        h.total = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            return new Node(key, value, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        h.total = size(h.left) + size(h.right) + 1;
        return h;
    }
}
