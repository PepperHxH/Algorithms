function Find(target, array)
{
    var m = array.length;
    var n = array[0].length;
    var i = 0;
    var j = n-1;
    while(i < m && j >= 0) {
        if(array[i][j] < target) {
            i++;
        } else if(array[i][j] > target) {
            j--;
        } else {
            return true;
        }
    }
    return false;
}

/*
function Find(target, array)
{
    return array.some(arr => arr.some(e => e === target));
}
*/