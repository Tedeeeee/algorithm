package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 20364 - 부동산 다툼
//  날짜 : 2025-11-27
//  추가 설명 : 문제에서 시작은 1이라는 부모 노드에서 시작하지만 목적지를 start 로 해서 내려와야 한다.
//            그 과정에서 이미 누군가 점령한 땅이 있다면 해당 땅을 출력하면 된다 
// -------------------------------
public class Problem20364 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int ducks = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[node + 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ducks; i++) {
            // 목표지점
            int target = Integer.parseInt(br.readLine());

            // 길 탐색
            int search = target;
            // 멈춘곳
            int stop = 0;

            while (search > 1) {
                if (visited[search]) {
                    stop = search;
                }

                search /= 2;
            }

            if (stop == 0) {
                visited[target] = true;
            }

            sb.append(stop).append("\n");
        }

        System.out.println(sb);
    }
}
