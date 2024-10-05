package 문제모음.프로그래머스;

public class 행렬테두리회전하기 {

    public static int[] solution(int rows, int columns, int[][] queries) {

        int[][] matrix = new int[rows][columns];

        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num;
                num++;
            }
        }

        int[] answer = new int[queries.length];
        for (int q = 0; q<queries.length; q++) {
            int x1 = queries[q][0]-1;
            int x2 = queries[q][2]-1;
            int y1 = queries[q][1]-1;
            int y2 = queries[q][3]-1;

            int minNum = rows * columns;
            int prevNum = matrix[x1+1][y1];
            int thisNum = 0;

            for (int i = y1; i <= y2; i++) {
                thisNum = matrix[x1][i];
                if(thisNum < minNum) minNum = thisNum;
                matrix[x1][i] = prevNum;
                prevNum = thisNum;
            }
            for (int i = x1 + 1; i <= x2; i++) {
                thisNum = matrix[i][y2];
                if(thisNum < minNum) minNum = thisNum;
                matrix[i][y2] = prevNum;
                prevNum = thisNum;
            }
            for (int i = y2 - 1; i >= y1; i--) {
                thisNum = matrix[x2][i];
                if(thisNum < minNum) minNum = thisNum;
                matrix[x2][i] = prevNum;
                prevNum = thisNum;
            }
            for (int i = x2 - 1; i > x1; i--) {
                thisNum = matrix[i][y1];
                if(thisNum < minNum) minNum = thisNum;
                matrix[i][y1] = prevNum;
                prevNum = thisNum;
            }

            answer[q] = minNum;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] result = solution(6, 6, new int[][]{new int[]{2, 2, 5, 4}, new int[]{3, 3, 6, 6}, new int[]{5, 1, 6, 3}});
    }
}
