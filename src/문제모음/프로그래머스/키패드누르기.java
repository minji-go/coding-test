package 문제모음.프로그래머스;

import java.util.ArrayList;
import java.util.List;

/*
    [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	    "LRLLLRLLRRL"
    [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	    "LRLLRRLLLRR"
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	    "right"	    "LLRLLRLLRL"

    1,4,7은 L
    3,6,9는 R
    2,5,8,0은 result에서 lastindexof로 배열 방번호를 찾은후 거리계산하여 더 작은 쪽으로 기록

*/
public class 키패드누르기 {
    public static String solution(int[] numbers, String hand) {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(12);

        for (int num : numbers) {
            list.add(num == 0 ? 11 : num);
        }

        String result = "";

        for (int num : list) {

            switch (num) {
                case 1 : case 4 : case 7 : case 10 : result += "L"; break;
                case 3 : case 6 : case 9 : case 12 : result += "R"; break;
                default:
                    int leftNum = list.get(result.lastIndexOf("L"));
                    int rightNum = list.get(result.lastIndexOf("R"));
                    int leftDistance = Math.abs(num - leftNum) / 3 + Math.abs(num - leftNum) % 3;
                    int rightDistance =  Math.abs(num - rightNum) / 3 + Math.abs(num - rightNum) % 3;

                    if (leftDistance > rightDistance) {
                        result += "R";
                    } else if (leftDistance < rightDistance) {
                        result += "L";
                    } else {
                        result += (hand.substring(0, 1).toUpperCase());
                    }

            }
        }

        return result.substring(2);
    }

    public static void main(String[] args) {
        if(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left").equals("LRLLRRLLLRR"))
            System.out.println("true");
        else
            System.out.println("false");
    }
}