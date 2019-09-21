package sort;

import java.util.Arrays;

public class Insert {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,7,1,6,4};
        insert(arr);
        System.out.println(Arrays.toString(arr));
    }
    static public void insert(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int tmp = arr[i+1];
            int index = i;
            while (index>=0&&tmp<arr[index]){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = tmp;
        }
        return;
    }
    static public void swapArr(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
