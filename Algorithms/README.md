# 剑指offer——JS题解
## 二维数组中的查找
题目描述：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

```
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
```

```
function Find(target, array)
{
    return array.some(arr => arr.some(e => e === target));
}
```
