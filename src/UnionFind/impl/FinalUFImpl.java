package UnionFind.impl;

import UnionFind.IUnionFind;

public class FinalUFImpl implements IUnionFind {

    int count;
    private int [] id;

    public FinalUFImpl(int n) {
        this.count = n;
        id = new int[this.count];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int count() {
        return this.count;
    }

    @Override
    public void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx == fy) return;
        id[fx] = fy;
    }

    @Override
    public int find(int x) {
        if (x < 0 || x >= this.count) {
            throw new IllegalArgumentException("OverSize");
        }
        if (x == id[x]) return x;
        return id[x] = find(id[x]);
    }

    @Override
    public boolean connected(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        return fx == fy;
    }
}
