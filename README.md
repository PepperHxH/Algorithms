# Algorithm 🍓
fiting!(ง •_•)ง

#### 多重数组嵌套展开
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

#### 实现add(1)(2)(3)(4)累加
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
#### 226.翻转二叉树
```javascript
var invertTree = function(root) {
    if(!root) return null
    let tmp = root.left
    root.left = root.right
    root.right = tmp
    invertTree(root.left)
    invertTree(root.right)
    return root
};

//解构赋值
var invertTree = function(root) {
    if(root !== null){
        [root.left, root.right] = [invertTree(root.right), invertTree(root.left)]
    }
    return root
};
```

#### 215.数组中的第K个最大元素
```javascript
var findKthLargest = function(nums, k) {
    nums.sort(function(a, b){return (b - a)}).slice(0,k)
    return nums[k-1]
};

// 快速排序
var quickSort = (arr, left, right) => {
    if(left >= right) {
    	return arr
    }
    let i = left,
        j = right,
        base = arr[left]
    while(i < j) {
        while(i < j && arr[j] >= base) {
            j--
        }
        while(i < j && arr[i] <= base) {
            i++
        }
        if(i < j) {
            let tmp = arr[i]
            arr[i] = arr[j]
            arr[j] = tmp
        }
    }
    arr[left] = arr[i]
    arr[i] = base
    quickSort(arr, left, i-1)
    quickSort(arr, i+1, right)
    return arr
}

var findKthLargest = function(nums, k) {
    quickSort(nums, 0, nums.length-1)
    return nums[nums.length-k]
};
```

#### 排序合集
```javascript
// 冒泡排序
function bubbleSort(arr) {
    let flag;
    for(var i = arr.length-1; i >= 0; i--) {
        flag = false
        for(var j = 0; j < i; j++) {
            arr[j] > arr[j+1] && (flag = true) && swap(arr, j, j+1)
        }
        if(!flag) {
            break
        }
    }
    return arr
}

// 快速排序
function quickSort(arr) {
    quick(arr, 0, arr.length-1)
}

function quickSort(arr, left, right) {
    if(left >= right) {
        return arr
    }
    let i = left,
        j = right,
        base = arr[left]
    while(i < j) {
    	// 注意顺序不能变
        while(i < j && arr[j] >= base) {
            j--
        }
        while(i < j && arr[i] <= base) {
            i++
        }
        if(i < j) {
            swap(arr, i, j)
        }
    }
    swap(arr, i, left)
    quickSort(arr, left, i-1)
    quickSort(arr, i+1, right)
    return arr
}

let arr = [5,2,4,1,3,6,0]
quickSort(arr)
console.log(arr)
```
