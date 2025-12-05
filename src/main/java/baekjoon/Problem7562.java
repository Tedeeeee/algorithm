package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 7562 - 나이트의 이동
//  날짜 : 2025-12-06
// -------------------------------
public class Problem7562 {

    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static Point target;

    static Queue<Point> queue;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            queue = new ArrayDeque<>();

            int l = Integer.parseInt(br.readLine());
            graph = new int[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            queue.add(new Point(x, y, 0));
            visited[x][y] = true;

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());
            target = new Point(targetX, targetY, 0);

            while(!queue.isEmpty()){
                Point p = queue.poll();

                if (p.equals(target)) {
                    System.out.println(p.des);
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx > -1 && ny > -1 && nx < l && ny < l && !visited[nx][ny]){
                        queue.add(new Point(nx, ny, p.des + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int des;

        public Point(int x, int y, int des) {
            this.x = x;
            this.y = y;
            this.des = des;
        }

        public boolean equals(Point point) {
            return point.x == this.x && point.y == this.y;
        }
    }
}