package 문제모음.프로그래머스;

public class 쿼드압축후개수세기 {

    public int[] solution(int[][] arr){
        ans = new int[2];
        div(0,0,arr.length,arr);
        return ans;
    }

    private static int[] ans;

    public void div(int x, int y, int len,int[][] arr){

        boolean isZero = true;
        boolean isOne = true;


        for (int i = x; i < x+len  ; i++) {
            for (int j = y; j <y+len; j++) {
                if(arr[i][j] == 1) isZero = false;
                if(arr[i][j] == 0) isOne= false;
            }
        }


        if(isOne){
            ans[1]++;
            return;
        }

        if(isZero){
            ans[0]++;
            return;
        }


        div(x,y,len/2,arr);
        div(x+len/2,y,len/2,arr);
        div(x,y+len/2,len/2,arr);
        div(x+len/2,y+len/2,len/2,arr);
    }

}
