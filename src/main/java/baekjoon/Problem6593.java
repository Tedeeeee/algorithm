package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 6593 - 상범 빌딩
//  날짜 : 2025-12-09
// -------------------------------
public class Problem6593 {

    static int l, r, c;
    static int result = 0;
    static char[][][] tower;
    static boolean[][][] visited;

    static Queue<Point> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] dl = {1, -1};

    static Point target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            tower = new char[l][r][c];
            visited = new boolean[l][r][c];
            queue = new ArrayDeque<>();

            for(int i = 0; i < l; i++){
                for(int j = 0; j < r; j++){
                    String str = br.readLine();
                    for(int k = 0; k < c; k++){
                        char ch = str.charAt(k);
                        tower[i][j][k] = ch;

                        if (ch == 'S') {
                            queue.add(new Point(i, j, k, 0));
                            visited[i][j][k] = true;
                        } else if (ch == 'E') {
                            target = new Point(i, j, k, 0);
                        }
                    }
                }
                br.readLine();
            }

            bfs();

            if (result == 0) {
                System.out.println("Trapped!");
            } else {
                System.out.printf("Escaped in %d minute(s).\n", result);
            }
        }
    }

    private static void bfs() {
        result = 0;
        while(!queue.isEmpty()){
            Point now = queue.poll();

            if (target.equals(now)) {
                result = now.time;
            }

            // 4방향으로 움직일 수 있다면 움직이기
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];


                if (nx > -1 && ny > -1 && nx < r && ny < c) {
                    if (tower[now.level][nx][ny] != '#' && !visited[now.level][nx][ny]) {
                        queue.add(new Point(now.level, nx, ny, now.time + 1));
                        visited[now.level][nx][ny] = true;
                    }
                }
            }

            // 다른 층도 보기
            for (int j = 0; j < 2; j++) {
                int nl = now.level + dl[j];

                if (nl > -1 && nl < l) {
                    if (tower[nl][now.x][now.y] != '#' && !visited[nl][now.x][now.y]) {
                        queue.add(new Point(nl, now.x, now.y, now.time + 1));
                        visited[nl][now.x][now.y] = true;
                    }
                }
            }
        }
    }

    static class Point{
        int level;
        int x;
        int y;
        int time;
        public Point(int l, int x, int y, int time) {
            this.level = l;
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public boolean equals(Point p) {
            return this.level == p.level && this.x == p.x && this.y == p.y;
        }
    }
}