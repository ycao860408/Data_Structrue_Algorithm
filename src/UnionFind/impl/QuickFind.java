package UnionFind.impl;

import UnionFind.IUnionFind;

public class QuickFind implements IUnionFind {

    public int count;
    private int[] parents;

    public QuickFind(int n) {
        this.count = n;
        parents = new int[this.count];
        for (int i = 0; i < this.count; i++) {
            parents[i] = i;
        }
    }

    @Override
    public int count() {
        return this.count;
    }

    @Override
    public void union(int x, int y) {
        if (connected(x, y)) return;
        int rootX = find(x);
        int rootY = find(y);
        for (int i = 0; i < this.count; i++) {
            if (parents[i] == rootX) {
                parents[i] = rootY;
            }
        }
    }

    @Override
    public int find(int x) {
        if (x < 0 || x >= this.count) {
            throw new IllegalArgumentException("Oversize");
        }
        return parents[x];
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
