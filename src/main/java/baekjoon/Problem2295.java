package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2295 - 세 수의 합
//  날짜 : 2025-12-18
// -------------------------------
public class Problem2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        /**
         *  x + y + z = k 라면 x + y = k - z 와 같다
         *  그래서 x + y의 조합을 만들어서 또 다른 배열에 저장을 해서 이분법을 사용할 수 있다
         *  2중 for문을 통해 x + y의 모든 경우의 수를 저장해두기
         *  n개의 원소 를 n번 반복하기 때문에 n*n의 갯수와 같다
         */
        long[] twoSum = new long[n * n];
        int idx = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                twoSum[idx++] = (long) arr[x] + arr[y];
            }
        }

        /**
         *  해당 배열은 x+y의 조합이다.
         *  이것을 이분법으로 찾기위해 배열을 정렬해두어야 한다
         */
        Arrays.sort(twoSum);

        /**
         *  이번엔 k - z의 경우의 수를 만들어야 한다
         */
        int answer = 0;
        for (int k = n - 1; k >= 0; k--) {
            for (int z = 0; z < n; z++) {
                long target = (long) arr[k] - arr[z];

                /**
                 *  기존에 만들어둔 배열에서 이분법으로 비교해서 찾는다
                 */
                int left = 0;
                int rigth = (n * n) - 1;
                while (left <= rigth) {
                    int mid = left + (rigth - left) / 2;
                    long xySum = twoSum[mid];

                    if (xySum == target) {
                        System.out.println(arr[k]);
                        return;
                    }

                    if (xySum < target) {
                        left = mid + 1;
                    } else {
                        rigth = mid - 1;
                    }
                }
            }
        }
    }
}
