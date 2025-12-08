package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2468 - 안전 영역
//  날짜 : 2025-12-08
// -------------------------------
public class Problem2468 {

    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static Queue<Node> queue;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        StringTokenizer st;
        int maxheight = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;

                maxheight = Math.max(num, maxheight);
            }
        }

        queue = new ArrayDeque<>();
        int max = 1;
        for (int i = 1; i <= maxheight; i++) {
            visited = new boolean[n][n];
            int result = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k] && graph[j][k] > i) {
                        queue.add(new Node(j, k));
                        visited[j][k] = true;
                        bfs(i);
                        result++;
                    }
                }
            }

            max = Math.max(result, max);
        }

        System.out.println(max);
    }

    static private void bfs(int height) {
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx > -1 && ny > -1 && nx < n && ny < n) {
                    if (graph[nx][ny] > height && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny));
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