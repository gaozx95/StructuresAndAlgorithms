package sort;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,7,1,6};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
    static public void bubble(int[] arr){
        for (int i=0;i<arr.length;i++){
            for (int j =0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    swapArr(arr,j,j+1);
                }
            }
        }
        return;
    }
    static public void swapArr(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
