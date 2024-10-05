package 알고리즘정답노트.시뮬레이션;

// 문제 링크 : https://www.acmicpc.net/problem/8911
// 문제 설명 : 좌표상에서 명령에 따라 이동할 때, 지나간 영역을 포함하는 가장 작은 직사각형의 넓이를 구하는 문제
//           F(앞으로), B(뒤로), L(왼쪽으로 회전), R(오른쪽으로 회전)
// 핵심 개념 : 구현, 시뮬레이션

import java.io.*;

public class B8911_시뮬레이션 {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            char[] cmd = br.readLine().toCharArray();
            System.out.println(solution(cmd));
        }
    }
    public static int solution(char[] cmd){
        int i = 0;                          //dx, dy의 인덱스
        int x=0, y=0;                       //현재 좌표
        int minX=0, minY=0, maxX=0, maxY=0; //지나간 좌표 중 min, max

        for(char c: cmd){
            if(c=='F') {            //dx, dy대로 움직이면 앞으로
                x+=dx[i];
                y+=dy[i];
            } else if(c=='B') {     //dx, dy의 반대로 움직이면 뒤로
                x-=dx[i];
                y-=dy[i];
            } else if(c=='L') {     //왼쪽으로 회전하면 dx, dy의 인덱스가 1감소
                i=(i+3)%4;
            } else if(c=='R')	{   //오른쪽으로 회전하면 dx, dy의 인덱스가 1증가
                i=(i+1)%4;
            }

            if(x<minX) minX=x;      //직사각형의 넓이를 구하려면, 가로와 세로 길이를 구해야한다.
            else if(x>maxX) maxX=x; //가로 길이는 x좌표가 가장 클 때와 작을 때의 차이다.

            if(y<minY) minY=y;      //세로 길이는 y좌표가 가장 클 때와 작을 때의 차이다.
            else if(y>maxY) maxY=y;
        }

        return (maxX-minX)*(maxY-minY); //가로 * 세로
    }
}
