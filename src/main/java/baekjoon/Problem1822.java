package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 1822 - 차집합
//  날짜 : 2025-12-17
// -------------------------------
public class Problem1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] targetArr = new int[N];
        int M = Integer.parseInt(st.nextToken());
        int[] compArr = new int[M];

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            targetArr[i] = number;
            set.add(number);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            compArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(targetArr);

        for (int i = 0; i < M; i++) {
            int target = compArr[i];

            int left = 0;
            int right = N - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int number = targetArr[mid];

                if (number == target) {
                    set.remove(number);
                    break;
                }

                if (number < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        if (set.isEmpty()) {
            sb.append(0);
        } else {
            sb.append(set.size()).append("\n");
            for (int num : result) {
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb);
    }
}
