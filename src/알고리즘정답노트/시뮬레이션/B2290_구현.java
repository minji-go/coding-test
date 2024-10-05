package 알고리즘정답노트.시뮬레이션;

//문제: https://www.acmicpc.net/problem/2290
//설명: 각 숫자를 '-'와 '|'를 이용해서 가로 s+2, 세로 2s+3 길이로 출력하는 문제
//개념: 구현, 문자열

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2290_구현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        String n = st.nextToken();

        //0-9 출력여부
        int[][] on = {
                {1,0,1,1,0,1,1,1,1,1},
                {0,1,1,1,0,-1,-1,1,0,0},
                {0,0,1,1,1,1,1,0,1,1},
                {0,1,-1,1,1,1,0,1,0,1},
                {1,0,1,1,0,1,1,0,1,1}
        };

        //출력 형태
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<2*s+3; i++){
            for(int j=0; j<n.length(); j++){
                int num = Integer.parseInt(String.valueOf(n.charAt(j)));
                for(int k=0; k<s+3; k++) {
                    if ((i==0 || i==s+1 || i==2*s+2) && (k>0 && k<s+1) && (on[2*i/(s+1)][num]==1)) {
                        sb.append("-");
                    } else if ((i!=0 && i!=s+1 && i!=2*s+2) && (k==0) && (on[(i/(s+1))*2+1][num]==-1||on[(i/(s+1))*2+1][num]==0)) {
                        sb.append("|");
                    } else if ((i!=0 && i!=s+1 && i!=2*s+2) && (k==s+1) && (on[(i/(s+1))*2+1][num]==1||on[(i/(s+1))*2+1][num]==0)) {
                        sb.append("|");
                    } else {
                        sb.append(" ");
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
