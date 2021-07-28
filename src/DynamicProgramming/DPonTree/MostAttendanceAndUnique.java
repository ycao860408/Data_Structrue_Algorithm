package DynamicProgramming.DPonTree;

import java.util.*;

public class MostAttendanceAndUnique {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = -1;
        while ((num = Integer.parseInt(sc.nextLine())) != 0) {
            Map<String, List<String>> tree = new HashMap<>();
            String root = null;
            for (int i = 1; i <= num; i++) {
                String line = sc.nextLine();
                if (i == 1) {
                    root = line;
                    tree.put(root, new ArrayList<>());
                } else {
                    String[] names = line.split(" ");
                    String worker = names[0], leader = names[1];
                    tree.putIfAbsent(leader, new ArrayList<>());
                    tree.putIfAbsent(worker, new ArrayList<>());
                    tree.get(leader).add(worker);
                }
            }

            Map<String, List<Integer>> dp = new HashMap<>();
            new MostAttendanceAndUnique().solve(dp, tree, root);
            int resWithOut = dp.get(root).get(0);
            int resWith = dp.get(root).get(1);
            int uniqueWithout = dp.get(root).get(2);
            int uniqueWith = dp.get(root).get(3);
            boolean isUnique = true;
            if (resWith == resWithOut) {
                isUnique = false;
            } else {
                if (resWith < resWithOut) {
                    isUnique = uniqueWithout == 0? false : true;
                } else {
                    isUnique = uniqueWith == 0? false : true;
                }
            }
            System.out.println(Math.max(resWith, resWithOut) + " " + isUnique);
        }
        sc.close();
    }

    public void solve(Map<String, List<Integer>> dp, Map<String, List<String>> tree, String root) {
        dp.putIfAbsent(root, new ArrayList<>());

        int without = 0;
        int with = 1;
        int isUniqueForWithout = 1;
        int isUniqueForWith = 1;
        for (String child : tree.get(root)) {
            solve(dp, tree, child);
            without += Math.max(dp.get(child).get(0), dp.get(child).get(1));
            if (dp.get(child).get(0) == dp.get(child).get(1)) {
                isUniqueForWithout = 0;
            } else {
                if (without == dp.get(child).get(0)) {
                    isUniqueForWithout = dp.get(child).get(2);
                } else {
                    isUniqueForWithout = dp.get(child).get(3);
                }
            }
            with += dp.get(child).get(0);
            if (dp.get(child).get(2) == 0) {
                isUniqueForWith = 0;
            }
        }

        dp.get(root).add(without);
        dp.get(root).add(with);
        dp.get(root).add(isUniqueForWithout);
        dp.get(root).add(isUniqueForWith);
    }
}
