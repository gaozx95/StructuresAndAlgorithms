package Structures.arrays;

public class FindInMat {
    public static void main(String[] args) {

    }
    public boolean find(int target ,int[][] array){
        int i =0;
        int j =array[0].length-1;
        while (i<array.length&&j>=0){
            if(target>array[i][j]){
                i++;
            }else if (target <array[i][j]){
                j--;
            }else
                return true;
        }
        return false;
    }
}
