package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 4179 - 불!
//  날짜 : 2025-12-06
// -------------------------------
public class Problem4179 {

    static int n, m;
    static char[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] fireMap;
    static int[][] jihoonMap;

    static Queue<Node> fireQueue;
    static Queue<Node> jihoonQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new char[n][m];

        fireMap = new int[n][m];
        fireQueue = new ArrayDeque<>();

        jihoonMap = new int[n][m];
        jihoonQueue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                graph[i][j] = c;

                if (c == 'J') {
                    jihoonMap[i][j] = 1;
                    jihoonQueue.add(new Node(i, j));
                } else if (c == 'F') {
                    fireMap[i][j] = 1;
                    fireQueue.add(new Node(i, j));
                }
            }
        }

        fireBfs();
        jihoonBfs();
    }

    // 불 BFS
    private static void fireBfs() {
        while (!fireQueue.isEmpty()) {
            Node now = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m ) {
                    if (fireMap[nx][ny] == 0 && graph[nx][ny] != '#') {
                        fireMap[nx][ny] = fireMap[now.x][now.y] + 1;
                        fireQueue.add(new Node(nx, ny));
                    }
                }
            }
        }
    }

    private static void jihoonBfs() {
        while (!jihoonQueue.isEmpty()) {
            Node now = jihoonQueue.poll();

            int x = now.x;
            int y = now.y;

            // 가장 자리로 갔다면
            if (x == 0 || y == 0 || x == n - 1 || y == m - 1) {
                int fireCnt = fireMap[x][y];
                int jihoonCnt = jihoonMap[x][y];
                // 불이 해당 위치에 아예 안 왔다면
                // 해당 위치에 불의 숫자보다 지훈이 이동 숫자가 작다면
                if (fireCnt == 0 || fireCnt > jihoonCnt) {
                    System.out.println(jihoonCnt);
                    return;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (jihoonMap[nx][ny] == 0 && graph[nx][ny] != '#') {
                        int nextStep = jihoonMap[now.x][now.y] + 1;
                        if (nextStep < fireMap[nx][ny] || fireMap[nx][ny] == 0) {
                            jihoonMap[nx][ny] = nextStep;
                            jihoonQueue.add(new Node(nx, ny));
                        }
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
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