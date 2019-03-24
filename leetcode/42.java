class Solution {
  public int trap(int[] height) {
    int hi=-1;
    int[] l = new int[height.length];
    int[] r = new int[l.length];
    int res = 0;
    for(int i=0;i<l.length;i++) {
      if(height[i]>hi) { l[i]=height[i]; hi=height[i]; }
      else l[i]=hi;
    } 
    hi=-1;
    for(int i=r.length-1;i>=0;i--) {
      if(height[i]>hi) { r[i]=height[i]; hi=height[i]; }
      else r[i]=hi;
    }
    for(int i=0;i<l.length;i++) {
      res += (Math.min(l[i],r[i])-height[i]);
    }
    return res;
  }
}