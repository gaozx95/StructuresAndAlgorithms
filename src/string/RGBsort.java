package string;

import java.util.Arrays;

/**
һ���ַ����飬���д洢��R��G��B�ַ���Ҫ�����е��ַ����� RGB ��˳���������
�������һ������Ϊ char s[] = "RGBBRGGBGB"���������Ӧ��Ϊ RRGGGGBBBB
 */
public class RGBsort {
    public static void main(String[] args) {
        String s  = "RGBBRGGBGB";
        char[] c = s.toCharArray();
        rgbsort(c);
        System.out.println(Arrays.toString(c));

    }
    /*
    static void rgbsort(char[] c){
        int r = 0,g = 0,b = 0;
        for (int i =0;i<c.length;i++){
            if(c[i] == 'R') r++;
            if(c[i] == 'G') g++;
            if(c[i] == 'B') b++;
        }
        for (int i = 0;i<r;i++){
            c[i] = 'R';
        }
        for(int i =r;i<r+g;i++){
            c[i] = 'G';
        }
        for (int i =r+g;i<r+g+b;i++){
            c[i] = 'B';
        }
    }*/
    public static void rgbsort(char[] c){
        int r = -1;
        int g = -1;
        for (int i =0;i<c.length;i++) {
            if(c[i] == 'R') {
                r++;
                swapChar(c, i, r);
                g++;
                if(c[i] == 'G'){
                    swapChar(c,g,i);
                }
            }else if(c[i] == 'G'){
                g++;
                swapChar(c,i,g);
            }

        }
    }

    static void swapChar(char[] c,int i,int j){
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
