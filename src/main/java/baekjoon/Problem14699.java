package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 14699 - 관악산 등산
//  날짜 : 2025-12-30
//  설명 : 기존의 DFS를 사용하면 너무 오래걸리고 메모리 낭비가 심함
// -------------------------------
public class Problem14699 {

    static List<Node>[] list;
    static int[] answerArr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node[] arr = new Node[n];
        answerArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(i + 1, Integer.parseInt(st.nextToken()));
        }

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());

            Node startNnode = arr[startIndex - 1];
            Node endNode = arr[endIndex - 1];

            // 높이가 부족하면 처음부터 값을 넣지 않는다.
            if (startNnode.height < endNode.height) {
                list[startIndex].add(endNode);
            } else if (startNnode.height > endNode.height) {
                list[endIndex].add(startNnode);
            }
        }

        // 모든 노드에서의 경우의 수를 계산해야함
        for (int i = 1; i <= n; i++) {
            dfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int number : answerArr) {
            sb.append(number).append("\n");
        }

        System.out.println(sb);
    }

    // 기존의 DFS 방식으로 푼 방법은 하단 -> 상단으로 누적합 방식으로 풀었지만 시간 초과 발생
    // 그래서 가장 최상단의 노드에서 부터 계산해서 DP계산해서 누적시켜서 바로 알 수 있게 해야한다
    private static int dfs(int now) {
        if (answerArr[now - 1] != 0) {
            return answerArr[now - 1];
        }

        // 자기 자신
        int best = 1;
        for (Node node : list[now]) {
            best = Math.max(best, dfs(node.value) + 1);
        }

        return answerArr[now - 1] = best;
    }

    static class Node {
        int value;
        int height;

        Node(int value, int height) {
            this.value = value;
            this.height = height;
        }
    }
}