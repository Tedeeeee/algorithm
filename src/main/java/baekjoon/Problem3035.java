package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 3035 - 스캐너
//  날짜 : 2025-11-10
//  추가 설명 : 정말 단순한 코드 구현 중첩 for문도 조건이 만족하기에 그냥 사용할 수 있다.
// -------------------------------
public class Problem3035 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        int plusRow = Integer.parseInt(st.nextToken());
        int plusColumn = Integer.parseInt(st.nextToken());

        char[][] news = new char[row][column];
        for (int i = 0; i < row; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < column; j++) {
                news[i][j] = charArray[j];
            }
        }

        char[][] resultNews = new char[row * plusRow][column * plusColumn];
        for (int i = 0; i < row; i++) {
            char[] newCharArray = new char[column * plusColumn];
            for (int j = 0; j < column; j++) {
                char ch = news[i][j];
                for (int k = 0; k < plusColumn; k++) {
                    int idx = (j * plusColumn) + k;
                    newCharArray[idx] = ch;
                }
            }

            int startRow = i * plusRow;
            for (int j = 0; j < plusRow; j++) {
                int selectRow = startRow + j;
                for (int k = 0; k < newCharArray.length; k++) {
                    resultNews[selectRow][k] = newCharArray[k];
                }
            }
        }

        for (int i = 0; i < resultNews.length; i++) {
            if (i == resultNews.length - 1) {
                System.out.print(new String(resultNews[i]));
            } else {
                System.out.println(new String(resultNews[i]));
            }
        }
    }
}
