package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 14575 - 뒤풀이
//  날짜 : 2025-12-28
// -------------------------------
public class Problem14575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int leftMax = 0;
        int rightMax = 0;
        int sumLeft = 0;
        int sumRight = 0;

        List<Drink> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            sumLeft += left;
            sumRight += right;

            leftMax = Math.max(leftMax, left);
            rightMax = Math.max(rightMax, right);

            arr.add(new Drink(left, right));
        }

        if (sumLeft > t || sumRight < t) {
            System.out.println(-1);
            return;
        }

        int answer = 0;
        while (leftMax <= rightMax) {
            int mid = leftMax + (rightMax - leftMax) / 2;

            long sum = 0;
            for (Drink drink : arr) {
                sum += Math.min(drink.r, mid);
            }

            if (sum >= t) {
                answer = mid;
                rightMax = mid - 1;
            } else {
                leftMax = mid + 1;
            }
        }

        System.out.println(answer);

    }

    static class Drink {
        int l;
        int r;

        Drink(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
