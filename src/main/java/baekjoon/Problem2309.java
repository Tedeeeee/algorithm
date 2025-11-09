package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// -------------------------------
//  문제 : BOJ 2309 - 일곱 난쟁이
//  날짜 : 2025-11-09
//  추가 설명 : 난장이의 7명을 다 더하는것이 아니라 전부다 더하고 두명을 빼는 방식으로 생각을 한다 생각의 전환
// -------------------------------
public class Problem2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] list = new int[9];

        int totalHeight = 0;
        for (int i = 0; i < 9; i++) {
            list[i] = Integer.parseInt(br.readLine());
            totalHeight += list[i];
        }

        int first = -1;
        int second = -1;
        outer:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int targetHeight = totalHeight - (list[i] + list[j]);

                if (targetHeight == 100) {
                    first = list[i];
                    second = list[j];
                    break outer;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int person : list) {
            if (person != first && person != second) {
                result.add(person);
            }
        }

        Collections.sort(result);

        for (Integer i : result) {
            System.out.println(i);
        }

    }
}
