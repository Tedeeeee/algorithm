package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 4803 - 트리
//  날짜 : 2025-12-02
//  추가 설명 : 간선으로 이어진 트리 들의 갯수를 파악하는 문제
//             1. 트리는 사이클이 생기면 안된다
//                 - 부모의 노드에 다시 방문하는 것은 사이클이 아니다
//             2. 사이클이 없는 서브 트리의 갯수
// -------------------------------
public class Problem4803 {

    static boolean[] visited;
    static List<Integer>[] tree;
    static boolean hasCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int caseNo = 1;
        while(true){

            st = new StringTokenizer(br.readLine());

            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            if (node == 0 && edge == 0) {
                break;
            }

            tree = new ArrayList[node + 1];

            for (int i = 1; i <= node; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < edge; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                tree[a].add(b);
                tree[b].add(a);
            }

            visited = new boolean[node + 1];

            int treeCnt = 0;
            for (int i = 1; i <= node; i++) {
                if (!visited[i]) {

                    hasCycle = false;
                    dfs(i, 0);

                    if (!hasCycle) {
                        treeCnt++;
                    }
                }
            }

            if (treeCnt == 0) {
                System.out.printf("Case %d: No trees.\n", caseNo);
            } else if (treeCnt == 1) {
                System.out.printf("Case %d: There is one tree.\n", caseNo);
            } else {
                System.out.printf("Case %d: A forest of %d trees.\n", caseNo, treeCnt);
            }

            caseNo++;
        }

    }

    private static void dfs(int node, int parent) {
        visited[node] = true;

        for (int next : tree[node]) {
            // 시작점인 부모에 다시 방문하는 것은 사이클이 아니다.
            // 다음 노드 진행
            if (parent == next) {
                continue;
            }

            if (visited[next]) {
                // 방문했던 노드에 다시 방문하는 것은 사이클 발생
                hasCycle = true;
            } else {
                dfs(next, node);
            }
        }
    }
}
