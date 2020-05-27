package thoughtworks;

import java.util.Scanner;

/**
 * @author :  PF_23
 * @Description : 4x6区域
 * @date : 2020/04/17.
 */

public class Wurenji {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int num = (n + 2) / 3 * m;
        String[] strs = new String[num];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = sc.nextLine();
        }
//        strs = new String[]{"R-FGR", "GRGFR", "FGFRG", "RFF-F", "GRF-G", "RFGGR", "FGGRF", "G-FFR"};

        char[][] area = area(strs, m, n, num);
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[0].length; j++) {
                System.out.print(area[i][j]);
            }
            System.out.println();
        }


    }

    public static char[][] area(String[] strs, int m, int n, int num) {
        char[][] res = new char[m][n];
        for (int i = 0, j = 0; i < m; i++, j++) {
            int k = 0;
            res[j][k++] = strs[i].charAt(4);
            res[j][k++] = strs[i].charAt(0);
            res[j][k++] = strs[i].charAt(2);
        }

        for (int i = num - 1, j = 0; i >= m; i--, j++) {
            int k = 3;
            res[j][k++] = strs[i].charAt(4);
            res[j][k++] = strs[i].charAt(0);
            //cs[0]为***RGF，下一次为：***FFG
            res[j][k++] = strs[i].charAt(2);
        }
        return res;
    }
}

