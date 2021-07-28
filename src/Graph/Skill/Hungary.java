package Graph.Skill;

import java.util.Arrays;

public class Hungary {
    private static int[] person;
    private static int[] places;
    public static void match(int[][] matrix) {
        person = new int[4];
        places = new int[3];
        Arrays.fill(person, -1);
        Arrays.fill(places, -1);
        int res = 0;
        boolean[] visited;

        for (int i = 0; i < person.length; i++) {
            visited = new boolean[places.length];
            if (hungry(matrix, i, visited)) {
                res++;
            }
        }
        System.out.println("res: " + res);
        System.out.println(Arrays.toString(person));
        System.out.println(Arrays.toString(places));
    }

    private static boolean hungry(int[][] matrix, int start, boolean[] visited) {
        for (int end = 0; end < places.length; end++) {
            // if no edge or has been visited
            if (matrix[start][end + 4] == 0 || visited[end]) {
                continue;
            }
            visited[end] = true;
            // not been taken or
            if (places[end] == -1|| hungry(matrix, places[end],visited)) {
                person[start] = end;
                places[end] = start;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0,0,0,0,1,1,0},
                {0,0,0,0,0,1,1},
                {0,0,0,0,1,1,0},
                {0,0,0,0,0,0,1},
                {1,0,1,0,0,0,0},
                {1,1,1,0,0,0,0},
                {0,0,0,1,0,0,0}
        };
        Hungary.match(matrix);
    }

}
