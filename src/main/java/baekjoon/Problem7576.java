package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 7576 - 토마토
//  날짜 : 2025-12-04
// -------------------------------
public class Problem7576 {

    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int day = 0;

    static Queue<Node> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int nextNumber = Integer.parseInt(st.nextToken());

                if (nextNumber == 1) {
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                }

                graph[i][j] = nextNumber;
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(day);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nextDay = graph[now.x][now.y] + 1;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx > -1 && ny > -1 && nx < n && ny < m) {
                    if (!visited[nx][ny] && graph[nx][ny] == 0) {
                        queue.add(new Node(nx, ny));
                        graph[nx][ny] = nextDay;
                        visited[nx][ny] = true;

                        day = nextDay - 1;
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
