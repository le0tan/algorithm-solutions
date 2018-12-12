/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */
var change = function(amount, coins) {
    let dp = [];
    const len = coins.length;
    for(let i = 0; i <= amount; i = i + 1){
        dp[i] = [];
    }
    for(let i = 0; i <= len; i = i + 1){
        dp[0][i] = 1;
    }
    for(let i = 1; i <= amount; i = i + 1){
        for(let j = 0; j <= len; j = j + 1){
            dp[i][j] = 0;
            if(j-1 >= 0){
                dp[i][j] = dp[i][j] + dp[i][j-1]
                if(i-coins[j-1]>=0){
                    dp[i][j] = dp[i][j] + dp[i-coins[j-1]][j];
                }
            } else {}
        }
    }
    return dp[amount][len];
};
