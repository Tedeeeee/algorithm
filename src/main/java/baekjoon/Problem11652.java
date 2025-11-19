package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// -------------------------------
//  문제 : BOJ 11652 - 카드
//  날짜 : 2025-11-19
//  추가 설명 : 초기엔 int 배열로 풀려고 했지만 Java에서 사용되는 배열 인덱스는 int 범위만 허용된다
//             그래서 Map 을 사용하기로 했다
// -------------------------------
public class Problem11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Long, Long> map = new HashMap<>();

        for (long i = 0; i < n; i++) {
            long input = Long.parseLong(br.readLine());
            map.put(input, map.getOrDefault(input, 0L) + 1L);
        }

        // value 가 가장 큰 값 가져오기
        long maxValue = Long.MIN_VALUE;
        for (Long value : map.values()) {
            maxValue = Math.max(value, maxValue);
        }

        long result = Long.MAX_VALUE;
        for (Long key : map.keySet()) {
            long value = map.get(key);

            if (value == maxValue) {
                result = Math.min(key, result);
            }
        }

        System.out.println(result);

    }
}
