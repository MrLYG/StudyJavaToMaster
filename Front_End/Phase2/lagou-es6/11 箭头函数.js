// 传统
var f1 = function(a){
    return a*10;
}

console.log( f1(10) );

// es6
var f2 = a=>a*10;
console.log( f2(20) );

// 当箭头函数一个参数时，（）可以省略
// 当箭头函数没有参数或者有多个参数，要用（）括起来
// 当箭头函数的函数体有多行语句，用｛｝括起来，表示代码块
// 当只有一条语句，并且需要返回时，可以省略｛｝，结果会自动返回

var f3 = (a,b) => {
    let sum = a+b;
    return sum;
}
console.log( f3(3,7) );

// 可以将f3进行简化
var f4 = (a,b) => a + b;
console.log( f3(11,22) );