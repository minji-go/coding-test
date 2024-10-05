package 알고리즘정답노트.시뮬레이션;

//문제: https://school.programmers.co.kr/learn/courses/30/lessons/147354#
//설명: 2차원 배열 데이터를 컬럼으로 정렬한 후, 각 배열의 연산 결과를 XOR 하는 문제
//개념: 정렬

import java.util.*;

public class P147354_구현_정렬 {

    public int solution(int[][] data, int col, int row_begin, int row_end) {

        Arrays.sort(data, (o1, o2) -> {
            if (o1[col-1] != o2[col-1]) {
                return o1[col-1] - o2[col-1];
            } else {
                return o2[0] - o1[0];
            }
        });

        int answer = 0;
        for(int i=row_begin-1; i<row_end; i++){
            int sum = 0;
            for(int j=0; j<data[0].length; j++){
                sum += data[i][j]%(i+1);
            }
            answer ^= sum;
        }

        return answer;
    }
}
