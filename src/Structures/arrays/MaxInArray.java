package Structures.arrays;



import java.util.*;

/**题： 给定一个数组A，有一个大小为w的滑动窗口，该滑动窗口从最左边滑到最后边。
 * 在该窗口中你只能看到w个数字，每次只能移动一个位置。
 * 我们的目的是找到每个窗口w个数字中的最大值，并将这些最大值存储在数组B中。
 *
 */
public class MaxInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3 ,-1, -3, 5, 3, 6, 7};
        int[] res = maxInArray(arr,3);
        System.out.println(Arrays.toString(res));
    }
    /**
    static public int[] maxInArray(int[] arr,int n){
        int len = arr.length;
        int[] res = new int[len-n+1];
        for (int i =0;i<len-n+1;i++){
            res[i] = findMax(arr,i,i+n-1);
        }
        return res;
    }
    */


    static public int[] maxInArray(int[] arr,int n){
        int len = arr.length;
        int[] res = new int[len-n+1];
        int k =0;
        Deque<Integer> q = new ArrayDeque<>();   //存的是下标
        for(int i =0;i<len;i++){
            while (!q.isEmpty()&&q.peek() <i-n+1){
                q.removeFirst();
            }
            while (!q.isEmpty() && arr[q.peekLast()]<arr[i]){
                q.removeLast();
            }
            q.offerLast(i);
            if(i>= n-1){
                res[k++] = arr[q.peek()];
            }
        }


        return res;
    }
    static public int findMax(int[] arr,int start,int end){
        int max = arr[start];
        for (int i =start;i<=end;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}
