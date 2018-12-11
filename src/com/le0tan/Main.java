package com.le0tan;
import com.le0tan.Solution;
import sun.plugin.javascript.navig.Array;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] n1 = {1,2,7};
        int[] n2 = {3,4,5,7};
//        System.out.println(sol.findMedianSortedArrays(n1, n2));
//        for(int i=0;i<7;i++){
//            System.out.println(sol.findK(0,2,0,3,n1,n2,i));
//        }
        System.out.println(sol.findK(0,2,0,3,n1,n2,3));
    }

}
