package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 9372 - 상근이의 여행
//  날짜 : 2025-11-27
//  추가 설명 : 노드를 최소의 간선을 이용해 모두 연결이 된다는 것은 결국 N - 1 이 되어야 하는 것이다
// -------------------------------
public class Problem9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 번의 여행
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 국가의 수 ( 노드의 수 )
            int country = Integer.parseInt(st.nextToken());
            // 비행기의 수 ( 연결된 간선의 수 )
            int airplane = Integer.parseInt(st.nextToken());

            for (int j = 0; j < airplane; j++) {
                br.readLine();
            }

            // 가장 적은 종류의 비행기로 국가를 모두 여행하는 방법
            // 몇 개의 간선이 있으면 모든 노드가 연결되는가
            // 노드의 갯수 - 1 이면 모두 연결된다.
            sb.append(country - 1).append("\n");
        }

        System.out.println(sb);
    }
}
