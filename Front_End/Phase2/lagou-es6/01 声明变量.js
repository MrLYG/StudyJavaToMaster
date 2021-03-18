/*
{
    var a = 0; // var声明的变量是全局变量
    let b = 0; // let声明的变量是局部变量
}

console.log(a);
console.log(b); //b is not defined：b没有定义
*/

//------------------------------------------------

/*
// var可以声明多次
// let只能声明一次
var m = 1;
var m = 2;
let n = 3;
let n = 4; //SyntaxError: Identifier 'n' has already been declared（语法错误：n已经声明过了）

console.log(m);
console.log(n);
*/

//------------------------------------------------

// var 声明的变量会全局存储
// let 声明的变量只能在执行后才存储

console.log( x ); //没有报错，输出：undefined
var x = "苹果";

console.log(y);  //y is not defined（y没有定义）
let y = "香蕉";