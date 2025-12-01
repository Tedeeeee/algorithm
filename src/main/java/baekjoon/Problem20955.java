package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 20955 - 민서의 응급 수술
//  날짜 : 2025-12-01
//  추가 설명 : 이번 문제는 서브 트리로 이루어진 트리를 사이클 없이 하나의 트리로 만드는 문제
//             1. 제거해야 하는 간선의 수 -> 사용된 간선의 수 - ( 노드의 수 - 서브 트리 갯수 )
//                  - 모르겠다...이건...진짜
//             2. 꼭 있어야 하는 간선의 수 -> 서브 트리 갯수 - 1
//                  - 이미 서브 트리는 연결되어 있기에 하나의 노드로 보고 트리의 간선 수 공식을 사용한다
//             3. 제거해야 하는 간선의 수 + 꼭 있어야 하는 간선의 수
// -------------------------------
public class Problem20955 {

    static List<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            tree[start].add(end);
            tree[end].add(start);
        }

        // 몇 개의 서브트리가 먼저 생기는지 확인
        visited = new boolean[n + 1];
        // 서브 트리 갯수
        int component = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                // 해당 dfs 가 종료되면 하나의 서브트리를 확인
                dfs(i);
                component++;
            }
        }

        // ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
        // 제거해야 하는 간선의 수 공식 => m - ( n - component )
        // m > ( n - component )
        //  → 반드시 사이클이 존재
        // m = ( n - component )
        //  → 사이클 없는 정확한 포레스트
        // m < ( n - component )
        //  → 아직 덜 연결된 상태
        int removeCnt = m - (n - component);

        // 반드시 추가해야 하는 간선의 수
        // C - 1
        int addCnt = component - 1;

        // 결과
        // 제거해야 하는 간선의 수 - 반드시 추가해야 하는 간선의 수
        System.out.println(removeCnt + addCnt);

    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int next : tree[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

}
