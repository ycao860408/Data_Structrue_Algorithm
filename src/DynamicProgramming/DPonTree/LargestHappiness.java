package DynamicProgramming.DPonTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestHappiness {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] happiness = new int[N + 1];
        int[] fathers = new int[N + 1];
        int[][] dp = new int[N + 1][2];
        List<Integer>[] tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            happiness[i] = Integer.parseInt(sc.nextLine());
        }

        fathers[0] = -1;
        for (int i = 1; i <= N; i++) {
            fathers[i] = i;
            tree[i] = new ArrayList<>();
        }
        String line = null;
        while (!(line = sc.nextLine()).equals("0 0")) {
            String[] pairs = line.split(" ");
            int child = Integer.parseInt(pairs[0]);
            int father = Integer.parseInt(pairs[1]);
            fathers[child] = father;

            tree[father].add(child);
        }
        int root = 1;

        while (fathers[root] != root) {
            root = fathers[root];
        }

        dfs(root, tree, happiness, dp);
        System.out.println(Math.max(dp[root][0], dp[root][1]));
        sc.close();
    }

    public static void dfs(int node, List<Integer>[] tree, int[] happiness, int[][] dp) {
        dp[node][0] = 0;
        dp[node][1] = happiness[node];
        for (int child : tree[node]) {
            dfs(child, tree, happiness, dp);
            dp[node][1] += dp[child][0];
            dp[node][0] += Math.max(dp[child][0], dp[child][1]);
        }
    }

}
