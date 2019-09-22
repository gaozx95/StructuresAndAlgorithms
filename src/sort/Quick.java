package sort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,7,1,6,4};
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static public void quick(int[] arr,int start,int end){
        if(start<end) {
            int index = partition(arr, start, end);
            quick(arr, start, index - 1);
            quick(arr, index + 1, end);
        }
    }
    static public int partition(int[]arr,int l,int r){
        int key = arr[l];
        int start = l;
        while (l<r){
            while (arr[r]>=key&&l<r) r--;
            while (arr[l]<=key&&l<r) l++;
            swapArr(arr,l,r);
        }
        swapArr(arr,l,start);
//        System.out.println(Arrays.toString(arr));
        return l;

    }
    static public void swapArr(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
