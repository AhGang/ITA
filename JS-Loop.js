//制作9*9乘法表
function loopCase1(array) {
    var str = "";
    for(var i=1;i<=9;i++){
        for(var j=1;j<=i;j++){
            str += i + "*" + j + "=" + i*j + " ";
            if(i === j){
                str += "\n";
            }
        }
    }
    console.log(str);
    return 0
}
console.log('第一题：');
loopCase1();
//新建index.js文件，用任何一种方式写一个循环，实现以下需求：从0循环到20，分别判断该数是奇数还是偶数，并输出。输出结果如下：
function loopCase2() {
    for (var i = 0; i <= 20; i++) {
        if( i% 2 == 0){
            console.log(i + '是偶数')
        }else{
            console.log(i + '是奇数')
        }
    }
    return 0
}
console.log('第二题：');
loopCase2();


