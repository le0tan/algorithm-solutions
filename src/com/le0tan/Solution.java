package com.le0tan;

public class Solution {
    public double findK(int l1, int r1, int l2, int r2, int[] n1, int[] n2, int K){
        if(l1 > r1){
//            System.out.println(l1);
//            System.out.println(r1);
            return n2[K];
        } else if(l2 > r2) {
//            System.out.println("4");
            return n1[K];
        } else if(l1==r1 && l2==r2) {
            if (K == 0) {
                return n1[l1] < n2[l2] ? n1[l1] : n2[l2];
            } else {
                return n1[l1] > n2[l2] ? n1[l1] : n2[l2];
            }
        } else {
            int mid1 = Math.floorDiv(l1 + r1, 2);
            int mid2 = Math.floorDiv(l2 + r2, 2);
            if (n1[mid1] > n2[mid2]) {
                return findK(l2, r2, l1, r1, n2, n1, K);
            } else {
                // left: 0~mid1 in n1
                // right: mid2~n2.length in n2
                if (K <= mid1) {
//                    System.out.println("1");
                    return n1[l1 + K];
                } else if (K >= mid1+mid2) {
                    // K-n1.length
//                    System.out.println("2");
                    return n2[l2 + K - n1.length];
                } else {
                    System.out.printf("mid1: %d, mid2: %d, newK: %d\n",mid1,mid2,K-mid1-1);
                    System.out.printf("l1:%d, r1:%d, l2:%d, r2:%d\n",mid1 + 1,r1,l2,mid2 - 1);
                    return findK(mid1 + 1, r1, l2, mid2 - 1, n1, n2, K - mid1 - 1);
                }
            }
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int t = len1 + len2;
        if(t % 2 == 0){
            return findK(0,len1-1,0,len2-1,nums1,nums2,t/2-1)
                    + findK(0,len1-1,0,len2-1,nums1,nums2,t/2);
        } else {
            return findK(0,len1-1,0,len2-1,nums1,nums2,(t-1)/2);
        }
    }
}
