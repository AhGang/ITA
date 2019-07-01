// 阅读推荐的链接，复习JavaScript中数组的相关方法

// 写程序判断下列变量是不是数组类型。
var a = '[a, b, c, d]';
var b = [1, 2, 3, 4];
//TODO
console.log('第一题：');
console.log(a.constructor === Array);
console.log(b.constructor === Array);
// 编写程序，将下面数组中的每一项都乘以2。
var a = [1, 2, 3, 4, 5];
// TODO should output [2,4,6,8,10]
function arrayCase2(array) {
    for (var i = 0; i < array.length; i++) {
         array[i] = array[i] * 2
    }
    return array
}
console.log('第二题：');
arrayCase2(a)
console.log(a)
// 编写程序，按下面的要求输出结果。
var colors = ["Red", "Green", "White", "Black"];
//TODO case 1 output: 'Red Green White Black'
// case 2 output: 'Red+Green+White+Black'
// case 3 output: 'Red,Green,White,Black'
console.log('第三题：');
function arrayCase3(array) {
    console.log( array.join(" "))
    console.log( array.join("+"))
    console.log( array.join(","))
    return array
}
arrayCase3(colors)
// 编写程序，将下面数组中的数字按从大到小的顺序排序。
var a = [5, 1, 8, 10, 4];
//TODO should output: [10,8,5,4,1]
console.log('第四题：');
a.sort(function(a,b){
    return b-a;
})
console.log(a)
// 编程程序，找出下列数组中出现频率最高的元素。
var a = [3, 'a', 'a', 'a', 2, 3, 'a', 3, 'a', 2, 4, 9, 3];
//TODO should output: 'a'
console.log('第五题：');
function arrayCase5(array) {
    let res = {}
    let maxNum = 0;
    let maxValue = null;
    for(let i = 0; i < array.length;i++) {
        let val = array[i]
        res[val] === undefined ? res[val] = 1 : res[val]++;
        if(res[val] > maxNum) {
            maxNum = res[val];
            maxValue = val
        }
    }
    console.log(maxValue)
    return maxValue
}
arrayCase5(a)

