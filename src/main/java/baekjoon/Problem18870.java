package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 18870 - 좌표 압축
//  날짜 : 2025-12-14
// -------------------------------
public class Problem18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cloneArr = arr.clone();
        Arrays.sort(cloneArr);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int num : cloneArr) {
            if (!map.containsKey(num)) {
                map.put(num, idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            int index = map.get(num);
            sb.append(index).append(" ");
        }

        System.out.println(sb);

    }
}
