package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 2667 - 단지번호 붙이기
//  날짜 : 2025-12-10
// -------------------------------
public class Problem2667 {

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
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                int num = str.charAt(j) - '0';
                graph[i][j] = num;
            }
        }

        queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.add(new Node(i, j));
                    int count = bfs();
                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");

        for (int i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs() {
        int count = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx > -1 && ny > -1 && nx < n && ny < n) {
                    if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                        count++;
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }

            }
        }

        return count;
    }

    static class Node{
        int x;
        int y;
        int count;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
