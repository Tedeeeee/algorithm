package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// -------------------------------
//  문제 : BOJ 15953 - 상금 헌터
//  날짜 : 2025-11-08
// -------------------------------
public class Problem15953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeatCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < repeatCount; i++) {
            String str = br.readLine();

            String[] strings = str.split(" ");

            int firstNumber = Integer.parseInt(strings[0]);
            int secondeNumber = Integer.parseInt(strings[1]);

            int firstPrice = getFirstPrice(firstNumber, 0);
            int secondPrice = getSecondPrice(secondeNumber, 0);

            System.out.println(firstPrice + secondPrice);
        }
    }

    private static int getFirstPrice (int first, int startGrade) {
        int n = 1;
        while (first > 0) {
            first -= n;
            n++;
            startGrade++;
        }

        switch (startGrade) {
            case 1:
                return 5000000;
            case 2:
                return 3000000;
            case 3:
                return 2000000;
            case 4:
                return 500000;
            case 5:
                return 300000;
            case 6:
                return 100000;
            default:
                return 0;
        }
    }

    private static int getSecondPrice (int second, int startGrade) {
        int m = 1;
        while (second > 0) {
            second -= m;
            m = m * 2;
            startGrade++;
        }

        switch (startGrade) {
            case 1:
                return 5120000;
            case 2:
                return 2560000;
            case 3:
                return 1280000;
            case 4:
                return 640000;
            case 5:
                return 320000;
            default:
                return 0;
        }
    }
}
