package 문제모음.백준.Gold5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1041
 * N과 주사위에 쓰여 있는 수가 주어질 때, 보이는 5개의 면에 쓰여 있는 수의 합의 최솟값을 출력하는 프로그램을 작성하시오.
 * 2023-09-15
 */
public class 주사위 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String dice = scanner.nextLine();
        int[] diceNum = new int[7];
        String[] diceStr = dice.split(" ");
        for (int i = 1; i <= 6; i++) {
            diceNum[i] = Integer.parseInt(diceStr[i - 1]);
        }
        System.out.println(new 주사위().solution(n, diceNum));

    }

    private long solution(int n, int[] diceNum) { //check*** Long!

        if (n == 1) { //check**** N=1일떄 !!!!
            return Arrays.stream(diceNum).sum() - Arrays.stream(diceNum).max().getAsInt();
        }

        diceNum[0] = Integer.MAX_VALUE; //check ****
        long min1SideSum = Arrays.stream(diceNum).min().getAsInt();
        long min2SideSum = Integer.MAX_VALUE;
        for (int i = 1; i <= 5; i++) {
            for (int j = i+1; j <= 6; j++) {
                if(i+j == 7) continue;
                min2SideSum = Math.min(min2SideSum, diceNum[i] + diceNum[j]);
            }
        }

        long min3SideSum = Integer.MAX_VALUE;
        for (int i = 1; i <= 4; i++) {
            for (int j = i+1; j <= 5; j++) {
                for (int k = j + 1; k <= 6; k++) {
                    if(i+j == 7 || i+k ==7 || j+k == 7) continue;
                    min3SideSum = Math.min(min3SideSum, diceNum[i] + diceNum[j] + diceNum[k]);
                }
            }
        }

        long minTotalSum = min3SideSum * 4 + min2SideSum * 4 * (2 * n - 3) + min1SideSum * (n - 2) * (5 * n - 6);
        return minTotalSum;
    }

}

/*
1. N면이 보이는 블록 개수 구하기
    (1+2+3)*4 + (1+2)*4
    (1+2+3)*4 + (1+2)*12 + 1*9

    3면 *4
    2면 *(4(N-1)+4(N-2))
    1면 *(4(N-1)(N-2)+(N-2)(N-2))

=> 3면 *4 + 2면 *4(2N-3) + 1면 *(N-2)(5N-6)


2. N면의 합 최소값 구하기
    ABC
    AB D
    A C E
    A  DE
     BC  F
     B D F
      C EF
       DEF

    AB
    A C
    A  D
    A   E
     BC
     B D
     B   F
      C E
      C  F
       DE
       D F
        EF


    안되는 조합
    ABE  -> BE
    ABF  -> AF
    ACD  -> CD
    ACF  -> AF
    ADF  -> AF
    AEF  -> AF
    BCD  -> CD
    BCE  -> BE
    BDE  -> BE
    BEF  -> BE
    CDE  -> CD
    CDF  -> CD

=> AF, BE, CD 조합이 들어가지 않는 최소값 구하기
*/
