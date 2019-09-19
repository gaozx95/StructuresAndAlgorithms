package string;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abacdfgdcaba";
        String sub = longestPalindrome(s);
        System.out.println(sub);

    }
    static String longestPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        String restr = sb.reverse().toString();
        int len = s.length();
        int[][] dp = new int[len][len];
        int max = 0;
        int prei=0;
        for(int i =0;i<len;i++){
            for (int j=0;j<len;j++){
                if(s.charAt(i) == restr.charAt(j)){
                    if(i==0||j==0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1]+1;
                    }
                }
                if(dp[i][j] >max){
                    if(isPalin(s,i-dp[i][j]+1,i)){
                        max = dp[i][j];
                        prei = i;
                    }

                }
            }
        }

        String sub = s.substring(prei-max+1,prei+1);
        return sub;
    }
    static public boolean isPalin(String s ,int start,int end){
        while (start<end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else
                return false;
        }
        return true;
    }
}
