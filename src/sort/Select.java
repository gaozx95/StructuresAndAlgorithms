package sort;

import java.util.Arrays;

public class Select {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,7,1,6,4};
        select(arr);
        System.out.println(Arrays.toString(arr));
    }
    static public void select(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int tmp = i;
            for (int j =i+1;j<arr.length;j++){
                if(arr[j]<arr[tmp]){
                    tmp =j;
                }
            }
            swapArr(arr,i,tmp);
        }
        return;
    }
    static public void swapArr(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
