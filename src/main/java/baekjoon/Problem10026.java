package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 10026 - 불!
//  날짜 : 2025-12-07
// -------------------------------
public class Problem10026 {

    static int n;
    static Queue<Node> queue;
    static char[][] graph, anotherGraph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    static int result = 0;
    static int anotherResult = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new char[n][n];
        anotherGraph = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = str.charAt(j);
                graph[i][j] = c;

                if (c == 'G') {
                    c = 'R';
                }
                anotherGraph[i][j] = c;
            }
        }

        // 일반인과 적록색약 2번
        for (int i = 0; i < 2; i++) {
            queue = new ArrayDeque<>();
            visited = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k]) {
                        visited[j][k] = true;
                        queue.add(new Node(j, k));
                        if (i == 0) {
                            bfs(graph[j][k]);
                        } else {
                            anotherBfs(anotherGraph[j][k]);
                        }
                    }
                }
            }
        }

        System.out.println(result + " " + anotherResult);
    }

    private static void bfs(char color) {
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx > -1 && ny > -1 && nx < n && ny < n) {
                    if (graph[nx][ny] == color && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }

        result++;
    }

    private static void anotherBfs(char color) {
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx > -1 && ny > -1 && nx < n && ny < n) {
                    if (anotherGraph[nx][ny] == color && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }

        anotherResult++;
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