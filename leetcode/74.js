/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    const rows = matrix.length;
    if(rows === 0){
        return false;
    } else {
        const cols = matrix[0].length;
        let ok = false;
        for(let i = 0; i < rows; i = i + 1){
            const cur = matrix[i][cols-1];
            if(target <= cur){
                for(let j = 0; j < cols; j = j + 1){
                    if(matrix[i][j] === target){
                        ok = true;
                        break;
                    }
                }
                break;
            } else { }
        }
        return ok;
    }

};
