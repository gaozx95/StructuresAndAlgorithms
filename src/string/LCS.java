package string;
/*
 ������������ X = < x1, x2, ..., xm > �� Y = < y1, y2, ..., ym >��ϣ���ҳ�X��Y��󳤶ȵĹ���������(LCS)��
 ע�⣬��������������
             |-    0
 c[i][j] =   |-    c[i-1][j-1]+1    x[i] = y[j]
             |-    Math.max(c[i-1][j],c[i][j-1])
 */
public class LCS {
    public static void main(String[] args) {
        String s1 = "ABCBDAB";
        String s2 = "BDCABA";
        int len = lcs(s1,s2);
        System.out.println(len);
    }
    public static int lcs(String s1,String s2){
        int m=s1.length();
        int n=s2.length();
        int[][] c =new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            for (int j=0;j<=n;j++){
                if (i==0||j==0)
                    c[i][j] =0;
                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    c[i][j] = c[i-1][j-1]+1;
                }else {
                    c[i][j] = Math.max(c[i-1][j],c[i][j-1]) ;
                }
            }
        }
        //
        return c[m][n];
    }
}
