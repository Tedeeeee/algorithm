package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 1021 - 회전하는 큐
//  날짜 : 2025-11-25
//  추가 설명 : 기존에는 인덱스를 찾아야 하기 때문에 List로 구현했지만
//             ArrayList는 배열을 shift 하는 비효율 발생, LinkedList는 인덱스 찾는데 O(n)
//             그래서 Deque를 사용하여 문제를
// -------------------------------
public class Problem1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int count =  Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        int[] targetBalls = new int[count];
        for (int i = 0; i < count; i++) {
            targetBalls[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int targetBall : targetBalls) {
            int idx = 0;

            for (int ball : deque) {
                if (targetBall == ball) {
                    break;
                }
                idx++;
            }

            int size = deque.size();
            // 왼쪽에서의 거리
            int left = idx;
            // 오른쪽에서의 거리
            int right = size - idx;

            // 왼쪽에서 가까운 경우
            if (left <= right) {
                for (int i = 0; i < left; i++) {
                    deque.addLast(deque.pollFirst());
                    result++;
                }
            }
            // 오른쪽에서 가까운 경우
            else {
                for (int i = 0; i < right; i++) {
                    deque.addFirst(deque.pollLast());
                    result++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(result);
    }
}
