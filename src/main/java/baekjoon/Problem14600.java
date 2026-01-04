package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 14600 - 샤워실 바닥 깔기
//  날짜 : 2026-01-04
// -------------------------------
public class Problem14600 {
    static int tileId = 1;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 샤워실은 정사각형이다. 한 변의 길이는 2의 제곱수 즉, 2의 배수이다
        int k = Integer.parseInt(br.readLine());
        int length = 1 << k;

        arr = new int[length][length];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int hr = length - y;
        int hc = x - 1;
        arr[hr][hc] = -1;

        fill(0, 0, length, hr, hc);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void fill(int sr, int sc, int size, int hr, int hc) {
        if (size == 1) return;

        int half = size / 2;
        int mr = sr + half - 1;
        int mc = sc + half - 1;

        int quad;
        if (hr < sr + half && hc < sc + half) quad = 0;          // TL
        else if (hr < sr + half && hc >= sc + half) quad = 1;    // TR
        else if (hr >= sr + half && hc < sc + half) quad = 2;    // BL
        else quad = 3;                                            // BR

        int t = tileId++;

        int[] r = {mr, mr, mr + 1, mr + 1};
        int[] c = {mc, mc + 1, mc, mc + 1};

        for (int q = 0; q < 4; q++) {
            if (q == quad) continue;
            arr[r[q]][c[q]] = t;
        }

        fill(sr, sc, half, quad == 0 ? hr : r[0], quad == 0 ? hc : c[0]);
        fill(sr, sc + half, half, quad == 1 ? hr : r[1], quad == 1 ? hc : c[1]);
        fill(sr + half, sc, half, quad == 2 ? hr : r[2], quad == 2 ? hc : c[2]);
        fill(sr + half, sc + half, half, quad == 3 ? hr : r[3], quad == 3 ? hc : c[3]);
    }
}
