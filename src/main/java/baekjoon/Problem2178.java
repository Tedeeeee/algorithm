package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2178 - 미로 탐색
//  날짜 : 2025-12-02
// -------------------------------
public class Problem2178 {

    static int n;
    static int m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                int num = str.charAt(j) - '0';
                graph[i][j] = num;
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.x == n - 1 && now.y == m - 1) {
                System.out.println(now.dist);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx > -1 && ny > -1 && nx < n && ny < m) {
                    int num = graph[nx][ny];
                    boolean bool = visited[nx][ny];
                    if (num == 1 && !bool) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny, now.dist + 1));
                    }
                }
            }
        }

    }

    static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

}
