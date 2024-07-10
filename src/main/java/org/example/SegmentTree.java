package org.example;

public class SegmentTree {
    private int[] segmentTree;
    private int[] arr;
    private int n;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        this.segmentTree = new int[4 * n];
        build(0, 0, n - 1);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            segmentTree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(2 * node + 1, start, mid);
            build(2 * node + 2, mid + 1, end);
            segmentTree[node] = segmentTree[2 * node + 1] + segmentTree[2 * node + 2];
        }
    }

    public int query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    private int query(int node, int start, int end, int l, int r) {
        if (r < start || l > end) {
            return 0;
        }
        if (l <= start && r >= end) {
            return segmentTree[node];
        }
        int mid = (start + end) / 2;
        int leftQuery = query(2 * node + 1, start, mid, l, r);
        int rightQuery = query(2 * node + 2, mid + 1, end, l, r);
        return leftQuery + rightQuery;
    }

     public void update(int idx, int newValue) {
        update(0, 0, n - 1, idx, newValue);
    }

    private void update(int node, int start, int end, int idx, int newValue) {
        if (start == end) {
            arr[idx] = newValue;
            segmentTree[node] = newValue;
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(2 * node + 1, start, mid, idx, newValue);
            } else {
                update(2 * node + 2, mid + 1, end, idx, newValue);
            }
            segmentTree[node] = segmentTree[2 * node + 1] + segmentTree[2 * node + 2];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(arr);

        System.out.println("Sum from index 1 to 3: " + segmentTree.query(1, 3));
        System.out.println("Sum from index 2 to 5: " + segmentTree.query(2, 5));

        segmentTree.update(3, 8);
        System.out.println("Sum from index 2 to 5 after update: " + segmentTree.query(2, 5));
    }
}
