package 문제모음.프로그래머스;

public class 기지국설치 {

    public static int solution(int n, int[] stations, int w) {

        int answer = 0;


        /*
            1. stations 배열 재배치
            - stations[0] 이전과 stations[stations.length-1] 이후를 계산하기 위해
            - stations[-1]과 stations[stations.length] 추가
         */
        int[] newStations = new int[stations.length+2];
        System.arraycopy(stations, 0, newStations, 1, stations.length);
        newStations[0] = -w;
        newStations[newStations.length - 1] = n + w + 1;

        /*
            2. stations 사이 거리에서, 필요 기지국 수
            - stations 사이 거리 : (이전 station + w + 1) - (현재 station - w)
            - 필요 기지국 수 : (w * 2 + 1)로 나눈 몫에, 나머지가 있다면 +1
        */
        for (int i=0; i<newStations.length-1; i++){
            int x = newStations[i+1] - newStations[i]  - w*2 -1;

            if(x > 0) answer += x / (w*2+1) + (x % (w*2+1) != 0? 1 : 0);
        }

        return answer;
    }

    public static void main(String[] args) {

        int n = 16;
        int[] stations = new int[]{9};
        int w = 2;

        //-2 9 19  6 5   5  2  1

        System.out.println(solution(n, stations, w));
    }
}
