package com.sanedge.interview.divide_conquer;

class Node {

    boolean val;
    boolean isLeaf;
    Node topLeft;
    Node topRight;
    Node bottomLeft;
    Node bottomRight;

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
    }

    public Node(
        boolean isLeaf,
        Node topLeft,
        Node topRight,
        Node bottomLeft,
        Node bottomRight
    ) {
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

public class ConstructQuadTree {

    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int x, int y, int size) {
        if (size == 1) {
            return new Node(grid[x][y] == 1, true);
        }

        boolean allSame = true;
        int val = grid[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (grid[i][j] != val) {
                    allSame = false;
                    break;
                }
            }
            if (!allSame) {
                break;
            }
        }

        if (allSame) {
            return new Node(val == 1, true);
        }

        int mid = size / 2;

        Node topLeft = build(grid, x, y, mid);
        Node topRight = build(grid, x, y + mid, mid);
        Node bottomLeft = build(grid, x + mid, y, mid);
        Node bottomRight = build(grid, x + mid, y + mid, mid);

        return new Node(false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public void printQuadTree(Node node) {
        if (node == null) {
            return;
        }

        if (node.isLeaf) {
            System.out.println("Leaf: " + node.val);
            return;
        }

        System.out.println("Non-Leaf:");
        printQuadTree(node.topLeft);
        printQuadTree(node.topRight);
        printQuadTree(node.bottomLeft);
        printQuadTree(node.bottomRight);
    }
}
