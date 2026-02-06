package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 6550 - 부분 문자열
//  날짜 : 2026-02-06
// -------------------------------
public class Problem6550 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제가 각 단어가의 최대 길이가 10만자 이기 때문에 2중 for문이 돌면 망가진다.
        // 그래서 2 pointer 를 사용해야 한다
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) {
                continue;
            }

            st = new StringTokenizer(line);

            String s = st.nextToken();
            String t = st.nextToken();

            int sIndex = 0;
            int tIndex = 0;
            while (sIndex < s.length() && tIndex < t.length()) {
                char sChar = s.charAt(sIndex);
                char tChar = t.charAt(tIndex);

                if (sChar == tChar) {
                    sIndex++;
                }
                tIndex++;
            }

            if (sIndex == s.length()) {
                sb.append("Yes").append('\n');
            } else {
                sb.append("No").append('\n');
            }
        }
        System.out.println(sb);
    }
}