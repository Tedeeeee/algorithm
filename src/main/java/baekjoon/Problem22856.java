package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 22856 - 트리 순회
//  날짜 : 2025-11-30
// -------------------------------
public class Problem22856 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] leftNode = new int[n + 1];
        int[] rightNode = new int[n + 1];
        int[] parentNode = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            leftNode[i] = -1;
            rightNode[i] = -1;
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            // index = 부모, value = 자식
            leftNode[start] = left;
            rightNode[start] = right;

            // index = 자식, value = 부모
            if (left != -1) {
                parentNode[left] = start;
            }

            if (right != -1) {
                parentNode[right] = start;
            }
        }

        // 마지막 노드 = 가장 오른쪽에 있는 노드
        // 중위 순회이기 때문에 마지막에 컨텍되는 곳은 오른쪽 노드
        int lastNodeNumber = 1;
        while (rightNode[lastNodeNumber] != -1) {
            lastNodeNumber = rightNode[lastNodeNumber];
        }

        // last의 깊이를 계산한다
        int depth = 0;
        int current = lastNodeNumber;
        while (current != 1) {
            current = parentNode[current];
            depth++;
        }

        // ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
        // 전체 이동 횟수는 => (간선의 갯수 * 2) - 마지막 노드의 깊이
        // 1. 간선의 갯수 => (노드 - 1) 개
        // 2. 모든 간선의 왕복 => (간선의 갯수 * 2) 번
        // 3. 마지막 노드에서는 "돌아오지 않는다" 그래서 해당 경로는 X2 가 아닌 X1 의 형태를 띄어야 한다
        int edges = n - 1;
        int answer = (edges * 2) - depth;

        System.out.println(answer);
    }
}
