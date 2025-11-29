package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 1240 - 노드 사이의 거리
//  날짜 : 2025-11-28
// -------------------------------
public class Problem1240 {

    private static int answer = 0;
    private static List<Node>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // List<Node>[] list = new ArrayList[n];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y, des));
            graph[y].add(new Node(x, des));
        }

        for (int i = 0; i < m; i++) {
            visited = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int totalDist = 0;
            dfs(start, end, totalDist);

            System.out.println(answer);
            answer = 0;
        }
    }

    private static void dfs(int nowNode, int targetNode, int dist) {
        if (nowNode == targetNode) {
            answer = dist;
            return;
        }

        visited[nowNode] = true;

        for (Node node : graph[nowNode]) {
            if (!visited[node.value]) {
                dfs(node.value, targetNode, dist + node.des);
            }
        }
    }

    static class Node {
        int value;
        int des;

        public Node(int value, int des) {
            this.value = value;
            this.des = des;
        }
    }
}
