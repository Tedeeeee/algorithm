package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 11715 - 트리의 부모 찾기
//  날짜 : 2025-11-26
//  추가 설명 : 간선을 나타내는 것이 중요하다 방법은 연결리스트를 통해서 표현
//             만들고나서 DFS 를 사용해서 기존에 방문 기록을 입력해서 처음 방문한 기존의 노드는 변경하지 않고 진행
// -------------------------------
public class Problem11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer>[] arr = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            arr[parent].add(child);
            arr[child].add(parent);
        }

        int[] nodes = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();

        int parentNum = 1;
        q.offer(parentNum);

        while (!q.isEmpty()) {
            int parent = q.poll();
            for (int node : arr[parent]) {
                if (!visited[node]) {
                    visited[node] = true;
                    nodes[node] = parent;
                    q.offer(node);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(nodes[i]).append("\n");
        }

        System.out.println(sb);
    }
}
