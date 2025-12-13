package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 1260 - DFS와 BFS
//  날짜 : 2025-12-13
// -------------------------------
public class Problem1260 {

    static List<Integer>[] lists;
    static int nodeCnt, edgeCnt, startNode;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

        lists = new ArrayList[nodeCnt + 1];

        for (int i = 1; i <= nodeCnt; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            lists[from].add(to);
            lists[to].add(from);
        }

        for (int i = 1; i <= nodeCnt; i++) {
            List<Integer> list = lists[i];
            Collections.sort(list);
        }

        visited = new boolean[nodeCnt + 1];
        visited[startNode] = true;
        sb.append(startNode).append(" ");
        DFS(startNode);

        sb.append("\n");

        visited = new boolean[nodeCnt + 1];
        BFS(startNode);

        System.out.println(sb);
    }

    static void DFS(int now) {
        for (Integer node : lists[now]) {
            if (!visited[node]) {
                visited[node] = true;
                sb.append(node).append(" ");
                DFS(node);
            }
        }
    }

    static void BFS(int startNode) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[startNode] = true;
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");
            
            for (Integer node : lists[now]) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.offer(node);
                }
            }
        }

    }
}
