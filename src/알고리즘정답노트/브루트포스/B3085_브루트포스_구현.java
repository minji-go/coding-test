package 알고리즘정답노트.브루트포스;

// 문제 링크 : https://www.acmicpc.net/problem/3085
// 문제 설명 : N×N 사탕 상자에서 인접한 두칸을 교환하여, 같은 색으로 이루어진 가장 긴 연속된 사탕의 길이를 구하는 문제
// 핵심 개념 : 구현, 브루트포스

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class B3085_브루트포스_구현 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][n];
        for(int i=0; i<n; i++){
            String st = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] = String.valueOf(st.charAt(j));
            }
        }

        int max = solution(new int[]{0, 0}, new int[]{0, 1}, arr);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                if(i+1<n && !arr[i][j].equals(arr[i+1][j])) max = Math.max(max, solution(new int[]{i, j}, new int[]{i+1, j}, arr));
                if(j+1<n && !arr[i][j].equals(arr[i][j+1])) max = Math.max(max, solution(new int[]{i, j}, new int[]{i, j+1}, arr));
            }
        }
        bw.write(String.valueOf(max));
        bw.close();
    }

    public static int solution(int[] a, int[] b, String[][] arr){
        String x = arr[a[0]][a[1]];
        arr[a[0]][a[1]] = arr[b[0]][b[1]];
        arr[b[0]][b[1]] = x;

        int max = 0;
        int rowCount = 0, colCount = 0;
        String rowCharacter = "C", colCharacter = "C";
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(arr[i][j].equals(rowCharacter)) {
                    rowCount++;
                } else {
                    max = Math.max(rowCount, max);
                    rowCharacter = arr[i][j];
                    rowCount = 1;
                }

                if(arr[j][i].equals(colCharacter)) {
                    colCount++;
                } else {
                    max = Math.max(colCount, max);
                    colCharacter = arr[j][i];
                    colCount = 1;
                }

                if(j==arr.length-1){
                    max = Math.max(rowCount, max);
                    max = Math.max(colCount, max);
                    rowCount = 0;
                    colCount = 0;
                }
            }
        }

        x = arr[a[0]][a[1]];
        arr[a[0]][a[1]] = arr[b[0]][b[1]];
        arr[b[0]][b[1]] = x;

        return max;
    }
}