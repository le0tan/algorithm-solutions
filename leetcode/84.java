class Solution {
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> s = new Stack<>();
    int max = 0;
    int i=0;
    while(i<heights.length) {
      if(s.isEmpty() || heights[i]>=heights[s.peek()]) {
        s.push(i++);
      } else {
        max = Math.max(heights[s.pop()]*(s.isEmpty()?i:(i-s.peek()-1)),max);
      }
    }
    while(!s.isEmpty()) {
      max = Math.max(heights[s.pop()]*(s.isEmpty()?i:(i-s.peek()-1)),max);
    }
    return max;
  }
}