var uniquePaths = function(m, n) {
    var dp = new Array(m+1)
    for (var i = 0; i <= m; i++) {
        dp[i] = new Array(n+1).fill(0)
    }

    for (var i = 1; i <= m; i++) {
        for (var j = 1; j <= n; j++) {
            if (i == 1 && j == 1) {
                dp[i][j] = 1
            } else {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]    
            }
            
        }
    }
    return dp[m][n]
};