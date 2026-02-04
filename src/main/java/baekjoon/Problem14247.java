package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 14247 - 나무 자르기
//  날짜 : 2026-02-04
// -------------------------------
public class Problem14247 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n개의 나무 중 하나를 자른다
        // 총 n 번 자를것이다.
        int n = Integer.parseInt(br.readLine());
        Tree[] arr = new Tree[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());
            arr[i] = new Tree(height);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int grow = Integer.parseInt(st.nextToken());
            arr[i].setGrow(grow);
        }

        Arrays.sort(arr);

        long answer = 0;
        for (int i = 0; i < arr.length; i++) {
            Tree tree = arr[i];
            answer += tree.nowHeight(i);
        }

        System.out.println(answer);
    }

    static class Tree implements Comparable<Tree> {
        int height;
        int grow;

        public Tree(int height) {
            this.height = height;
        }

        public void setGrow(int grow) {
            this.grow = grow;
        }

        @Override
        public int compareTo(Tree o) {
            return this.grow - o.grow;
        }

        public long nowHeight(int day) {
            return height + ((long) grow * day);
        }
    }
}