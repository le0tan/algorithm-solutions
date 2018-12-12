/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    let mem = [];
    mem[1] = 1;
    mem[2] = 2;
    for(let i = 3; i <= n; i = i + 1){
        mem[i] = mem[i-1] + mem[i-2];
    }
    return mem[n];
};
