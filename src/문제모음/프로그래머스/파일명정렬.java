package 문제모음.프로그래머스;

import java.util.*;

class 파일명정렬 {

    public static String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] file1 = check(s1);
                String[] file2 = check(s2);

                if(file1[0].equals(file2[0])) {
                    int num1 = Integer.parseInt(file1[1]);
                    int num2 = Integer.parseInt(file2[1]);

                    return num1 - num2;
                } else {
                    return file1[0].compareTo(file2[0]);
                }
            }

        });

        return files;
    }


    private static String[] check(String name) {

        int numberIndex = 0;
        int tailIndex = name.length();

        for (int i=0; i<name.length(); i++) {

            char n = name.charAt(i);

            if (numberIndex == 0 && (n >= '0' && n <= '9')) {
                numberIndex = i;

            } else if (numberIndex != 0 && (n < '0' || n > '9')) {
                tailIndex = i;
                break;
            }
        }

        String head = name.substring(0, numberIndex).toLowerCase();
        String number = name.substring(numberIndex, tailIndex);

        return new String[]{head, number};

    }
}