package UnionFind.impl;

import UnionFind.IUnionFind;

public class QuickUnionByRanks implements IUnionFind {
    private int count;
    private int[] parents;
    private int[] rank;
    public QuickUnionByRanks(int n) {
        this.count = n;
        parents = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int count() {
        return this.count;
    }

    @Override
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;

        if (rank[rootX] < rank[rootY]) {
            parents[rootX] = rootY;
        } else if (rank[rootY] < rank[rootX]) {
            parents[rootY] = rootX;
        } else {
            parents[rootY] = rootX;
            rank[rootX]++;
        }
    }

    @Override
    public int find(int x) {
        if (x < 0 || x >= this.count) {
            throw new IllegalArgumentException("OverSize");
        }
        int idx = x;
        while (idx != parents[idx]) {
            idx = parents[idx];
        }
        return 0;
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
