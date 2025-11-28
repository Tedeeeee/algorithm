package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 1991 - 트리 순회
//  날짜 : 2025-11-28
// -------------------------------
public class Problem1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 알파벳 대문자만 있음
        Node[] tree = new Node[26];

        for (int i = 0; i < 26; i++) {
            tree[i] = new Node((char) ('A' + i));
        }

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            char value = st.nextToken().charAt(0);

            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left != '.') {
                tree[value - 'A'].left = tree[left - 'A'];
            }

            if (right != '.') {
                tree[value - 'A'].right = tree[right - 'A'];
            }
        }

        preOrder(tree[0], sb);
        sb.append("\n");
        middleOrder(tree[0], sb);
        sb.append("\n");
        postOrder(tree[0], sb);

        System.out.println(sb);
    }

    private static void preOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append(node.value);

        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    private static void middleOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        middleOrder(node.left, sb);
        sb.append(node.value);
        middleOrder(node.right, sb);
    }

    private static void postOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.value);
    }

    static class Node {
        char value;

        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }
}
