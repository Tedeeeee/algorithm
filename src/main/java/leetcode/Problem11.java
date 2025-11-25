package leetcode;

public class Problem11 {
    public static void main(String[] args) {

        int[] heightArr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        // int[] heightArr = {1, 1};

        int l = 0;
        int r = heightArr.length - 1;

        int result = Integer.MIN_VALUE;
        while (l < r) {
            int leftHeight = heightArr[l];
            int rightHeight = heightArr[r];
            int area = Math.min(leftHeight, rightHeight) * (r - l);

            result = Math.max(result, area);

            if (rightHeight < leftHeight) {
                r--;
            } else {
                l++;
            }
        }

        System.out.println(result);
    }
}
