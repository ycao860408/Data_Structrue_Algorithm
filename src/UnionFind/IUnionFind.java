package UnionFind;

public interface IUnionFind {
    int count();

    void union(int x, int y);

    int find(int x);

    boolean connected(int x, int y);
}
