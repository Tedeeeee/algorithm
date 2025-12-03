package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 1926 - 그림
//  날짜 : 2025-12-02
// -------------------------------
public class Problem1926 {

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

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int paintingCnt = 0;
        int maxWidth = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    visited[i][j] = true;
                    int width = bfs(i, j);
                    maxWidth = Math.max(width, maxWidth);
                    paintingCnt++;
                }
            }
        }

        System.out.println(paintingCnt);
        System.out.println(maxWidth);
    }

    private static int bfs(int x, int y) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, y));

        int width = 1;
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx > -1 && ny > -1 && nx < n && ny < m) {
                    int num = graph[nx][ny];
                    boolean bool = visited[nx][ny];
                    if (num == 1 && !bool) {
                        visited[nx][ny] = true;
                        width++;
                        queue.add(new Node(nx, ny));
                    }
                }
            }

        }

        return width;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
