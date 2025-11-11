package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 2822 - 점수 계산
//  날짜 : 2025-11-11
// -------------------------------
public class Problem2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int question = 8;

        int[] arr = new int[question];
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < question; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            numberMap.put(arr[i], i + 1);
        }

        Arrays.sort(arr);

        int sum = 0;
        int[] resultArr = new int[5];
        int resultIndex = 0;
        for (int i = 3; i < question; i++) {
            resultArr[resultIndex++] = arr[i];
            sum += arr[i];
        }

        int[] resultNumber = new int[5];
        for (int i = 0; i < resultArr.length; i++) {
            resultNumber[i] = numberMap.get(resultArr[i]);
        }

        Arrays.sort(resultNumber);

        System.out.println(sum);
        for (int i : resultNumber) {
            System.out.printf("%d ", i);
        }

    }
}
