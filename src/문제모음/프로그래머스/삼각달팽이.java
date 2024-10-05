package 문제모음.프로그래머스;

public class 삼각달팽이 {

    public static int[] solution(int n) {

        //1. 2차원 배열 만들기
        int[][] array = new int[n][];

        for(int i=0; i<n; i++){
            array[i] = new int[i+1];
        }

        //2. 2차원 배열 채우기
        //- 끝수가 없거나 방이 0이 아니면 턴
        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};
        int index = 0;
        int x = 0;
        int y = 0;
        int turn = n;
        int add = n;

        for(int i=1; i<=(n*(n+1))/2; i++){

            array[y][x] = i;

            if(i==turn) {
                turn += --add;
                index = (index+1)%3;
            }

            x = x + dx[index];
            y = y + dy[index];
        }


        //3. 2차원 배열을 1차원 배열 result로 만들기
        int[] answer = new int[(n*(n+1))/2];
        index = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                answer[index] = array[i][j];
                index++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] result = solution(n);
        for(int i : result) System.out.println(i);
    }
}
