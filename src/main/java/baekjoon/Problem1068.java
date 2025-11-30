package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 1068 - 트리
//  날짜 : 2025-12-01
// -------------------------------
public class Problem1068 {

    static int answer = 0;
    static List<Integer>[] tree;
    static int del;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 노드의 갯수
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());

            // 부모에 해당 자식 넣기
            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }

        del = Integer.parseInt(br.readLine());

        // 루트를 삭제하는 경우
        if (del == root) {
            System.out.println(0);
            return;
        }

        dfs(root);

        System.out.println(answer);

    }

    private static void dfs(int node) {
        if (node == del) {
            return;
        }

        // 살아있는 자식 수 체크
        int childCount = 0;
        for (int child : tree[node]) {
            // 삭제된 노드는 진입 불가
            if (child == del) {
                continue;
            }

            childCount++;
            // 삭제되는 노드는 물론 하위의 노드도 진입 불가
            dfs(child);
        }

        // 특정 노드의 자식이 하나도 없다는건 루트 노드 라는것
        if (childCount == 0) {
            answer++;
        }
    }
}
