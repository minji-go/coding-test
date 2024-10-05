package 문제모음.백준.재귀;
import java.util.*;

public class _2309_일곱난쟁이 {
    public void solution(int[] height, int sum){
        for(int i=0;i<8; i++){
            for(int j=i+1; j<9; j++){
                if(height[i]+height[j]==sum){
                    height[i]=height[j]=0;
                    return;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] height = new int[9];
        int sum = -100;
        for(int i=0; i<9; i++){
            sum += height[i] = sc.nextInt();
        }
        _2309_일곱난쟁이 T = new _2309_일곱난쟁이();
        T.solution(height, sum);

        Arrays.sort(height);
        for(int i=2; i<9; i++){
            System.out.println(height[i]);
        }
    }
}