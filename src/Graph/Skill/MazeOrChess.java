package Graph.Skill;

import java.util.LinkedList;
import java.util.Queue;

public class MazeOrChess {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int m, n;
    public  static boolean hasPath(int[][] maze, int[] start, int[] end) {
        if (maze[start[0]][start[1]] == 0 || maze[end[0]][end[1]] == 0) return false;
        m = maze.length;
        n =  maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> que = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        que.offer(start[0] * n + start[1]);

        while (!que.isEmpty()) {
            int cur = que.poll();
            int curX = cur / n;
            int curY = cur % n;
            if (curX == end[0] && curY == end[1]) return true;
            for (int k = 0; k < 4; k++) {
                int nx = curX + dx[k];
                int ny = curY + dy[k];
                if (isValid(nx, ny, maze, visited)) {
                    visited[nx][ny] = true;
                    que.offer(nx * n + ny);
                }
            }
        }
        return false;
    }

    private static boolean isValid(int nx, int ny, int[][] maze, boolean[][]visited) {
        return nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 1 && !visited[nx][ny];
    }

    public  static int shortestDistance(int[][] maze, int[] start, int[] end) {
        if (maze[start[0]][start[1]] == 0 || maze[end[0]][end[1]] == 0) return 0;
        m = maze.length;
        n =  maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> que = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        que.offer(start[0] * n + start[1]);
        int res = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            res++;
            for (int i = 0; i < size; i++) {
                int cur = que.poll();
                int curX = cur / n;
                int curY = cur % n;
                if (curX == end[0] && curY == end[1]) {
                    for (boolean[] visit : visited) {
                        for (boolean item : visit) {
                            System.out.print(item + " ");
                        }
                        System.out.println();
                    }
                    return res - 1;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = curX + dx[k];
                    int ny = curY + dy[k];
                    if (isValid(nx, ny, maze, visited)) {
                        visited[nx][ny] = true;
                        que.offer(nx * n + ny);
                    }
                }
            }
        }

        return - 1;
    }
    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 1, 1, 1, 1}
        };
        System.out.println(MazeOrChess.hasPath(maze, new int[]{0, 0}, new int[]{4, 4}));
        System.out.println(MazeOrChess.shortestDistance(maze, new int[]{0, 0}, new int[]{4, 4}));
    }
}
