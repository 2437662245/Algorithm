package exam.xiecheng;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @author: joe
 * @dateTime: 2023/3/6 21:20
 * @description: TODO
 * @version: 1.0
 */
public class Q2A2 {
    static int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int[][] a = new int[][]{{sc.nextInt(),sc.nextInt()},{sc.nextInt(),sc.nextInt()}};
            int[][] b = new int[][]{{sc.nextInt(),sc.nextInt()},{sc.nextInt(),sc.nextInt()}};
            if(cout(a)!=cout(b)){
                bw.write("-1");
                continue;
            }
            int time = Integer.MAX_VALUE>>1;
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    time = Math.min(getTime(a, b,j,k),time);
                }
            }
            if(time>=Integer.MAX_VALUE>>1)
                bw.write("-1");
            else
                bw.write(Integer.toString(time));
            if(i<t-1) bw.newLine();
        }
        bw.flush();
    }

    private static int cout(int[][] b) {
        int res = 0;
        for (int[] ints : b) {
            for (int anInt : ints) {
                if(anInt==1)res++;
            }
        }
        return res;
    }

    private static int getTime(int[][] a, int[][] b, int x, int y) {
        if(isVaild(a,b))
            return 0;
        if(x<0||x>=2||y<0||y>=2)
            return Integer.MAX_VALUE>>1;
        int res = Integer.MAX_VALUE>>1;
        for (int[] ints : dist) {
            swap(x,y,x+ints[0],y+ints[1],a);
            res = Math.min(res,getTime(a,b,(y==1?x+1:x),(y==1?0:y+1))+1);
            swap(x,y,x+ints[0],y+ints[1],a);
        }
        return res;
    }

    private static void swap(int x, int y, int x1, int y1, int[][] a) {
        if(x1<0||x1>1||y1<0||y1>1)return;
        int k = a[x][y];
        a[x][y] = a[x1][y1];
        a[x1][y1] = k;
    }


    private static boolean isVaild(int[][] a, int[][] b) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if(a[i][j]!=b[i][j])
                    return false;
            }
        }
        return true;
    }
}
