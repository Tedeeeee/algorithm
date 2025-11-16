package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// -------------------------------
//  문제 : BOJ 2816 - 디지털 티비
//  날짜 : 2025-11-16
// -------------------------------
public class Problem2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int moveDownIndex = 1;
        final int moveUpIndex = 2;
        final int moveDownValue = 3;
        final int moveUpValue = 4;

        int n = Integer.parseInt(br.readLine());

        List<String> arr = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            arr.add(str);
        }

        StringBuilder sb = new StringBuilder();

        // KBS1 로 채널 이동 (인덱스 찾기)
        int KBS1Index = 0;
        for (int i = 0; i < n; i++) {
            if ("KBS1".equals(arr.get(i))) {
                KBS1Index = i;
                break;
            } else {
                sb.append(moveDownIndex);
            }
        }

        // KBS1 을 최상단으로 이동
        for (int i = KBS1Index; i > 0; i--) {
            String KBS1 = arr.remove(i);
            arr.add(i - 1, KBS1);

            sb.append(moveUpValue);
        }

        // KBS2 로 채널 이동 (인덱스 찾기)
        int KBS2Index = 0;
        for (int i = 0; i < n; i++) {
            if ("KBS2".equals(arr.get(i))) {
                KBS2Index = i;
                break;
            } else {
                sb.append(moveDownIndex);
            }
        }

        // KBS2를 KBS1 하단으로 이동
        for (int i = KBS2Index; i > 1; i--) {
            String KBS1 = arr.remove(i);
            arr.add(i - 1, KBS1);

            sb.append(moveUpValue);
        }

        System.out.println(sb);

    }
}
