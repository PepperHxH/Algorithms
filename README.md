# Algorithm 🍓
fiting!(ง •_•)ง

#### 1. 多重数组嵌套展开
```javascript
var arrTest = [1, [2, 3, [4]], 5, 6, [7, 8], [[9, [10, 11], 12], 13], 14];
function FlatArr(arr) {
    while(arr.some(t => Array.isArray(t))) {
        arr = ([]).concat(...arr)
    }
    return arr
}
console.log(FlatArr(arrTest));
```

#### 2.实现add(1)(2)(3)(4)累加
```javascript
var add = function(m) {
    var temp = function(n) {
        return add(m+n)
    }
    temp.toString = function () {
        return m
    }
    return temp
}
var a = add(1)(2)(3)(4)
console.log(a)  
```
