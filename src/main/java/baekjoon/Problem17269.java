package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 17269 - 이름궁합 테스트
//  날짜 : 2025-11-10
// -------------------------------
public class Problem17269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 이름은 대문자
        int[] alphaCount = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstPersonCount = Integer.parseInt(st.nextToken());
        int secondPersonCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String firstPerson = st.nextToken();
        String secondPerson = st.nextToken();

        int len = firstPersonCount + secondPersonCount;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i < firstPersonCount) {
                sb.append(firstPerson.charAt(i));
            }

            if (i < secondPersonCount) {
                sb.append(secondPerson.charAt(i));
            }
        }

        char[] name = new char[len];
        for (int i = 0; i < len; i++) {
            name[i] = sb.charAt(i);
        }

        int[] nameCount = new int[len];
        for (int i = 0; i < len; i++) {
            int index = name[i] - 'A';
            nameCount[i] = alphaCount[index];
        }

        while (nameCount.length > 2) {
            int[] temp = new int[nameCount.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = (nameCount[i] + nameCount[i + 1]) % 10;
            }

            nameCount = temp;
        }

        String result = String.format("%d%d", nameCount[0], nameCount[1]);

        System.out.printf("%d%%", Integer.parseInt(result));
    }
}
