package part1.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.UF;

public class DynamicConnectivity {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (!uf.connected(p, q)) {
                uf.union(p,q);
                System.out.println(p + " " + q);
            }
        }
    }
}
