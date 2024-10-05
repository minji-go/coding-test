package 문제모음.프로그래머스;

public class 거리두기확인하기 {
    public int[] solution(String[][] places) {
        int[] result = {1, 1, 1, 1, 1};

        for (String[] place : places) {

            for (int row = 0; row<place.length; row++) {
                int col = place[row].indexOf("P");
                while (col != -1) {
                    if(!iskept(place, row-2, col)) {
                        result[row] = 0; break; }
                    if(!iskept(place, row-1, col)) {
                        result[row] = 0; break; }
                    if(!iskept(place, row-1, col+1)) {
                        result[row] = 0; break; }
                    if(!iskept(place, row+1, col)) {
                        result[row] = 0; break; }
                    if(!iskept(place, row+1, col-1)) {
                        result[row] = 0; break; }
                    if(!iskept(place, row+2, col)) {
                        result[row] = 0; break; }
                    if(!iskept(place, row,col-2)) {
                        result[row] = 0; break; }
                    if(!iskept(place, row,col-1)) {
                        result[row] = 0; break; }
                    if(!iskept(place, row-1,col-1)) {
                        result[row] = 0; break; }
                    if(!iskept(place, row,col+1)) {
                        result[row] = 0; break; }
                    if(!iskept(place, row+1,col+1)) {
                        result[row] = 0; break; }
                    if(!iskept(place, row,col+2)) {
                        result[row] = 0; break; }
                    col = place[row].indexOf("P", col);
                }

            }

        }

        return result;
    }
    public boolean iskept(String[] place, int row, int col) {

        if(row < 0 || row > 4 || col < 0 || col > 4) return true;

        if(place[row].charAt(col) == 'P') return false;

        return true;
    }

    public static void main(String[] args) {
    }

}

/*
    PP   POP  P   PO   P
              P    P   O
                       P

*/
