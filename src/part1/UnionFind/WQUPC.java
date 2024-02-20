package part1.UnionFind;

public class WQUPC {

    private int[] id;
    private int[] sz;

    public WQUPC(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1; // 각 트리의 크기를 1로 초기화
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // 탐색한 노드들을 직접 루트 노드로 연결하면서 동시에 그 노드의 부모를 조부모(Grandparent)로 설정
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) return;

        // 크기가 작은 트리를 크기가 큰 트리에 합침
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
