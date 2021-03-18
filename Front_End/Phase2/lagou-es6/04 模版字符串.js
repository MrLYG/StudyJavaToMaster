/*
let str = `hello,
你俩在哪呢？
心情不好，出来喝点啊！`;

console.log(str);
*/

//-----------------------------------

/*
let name = `吕布`;
let age = 24;

// 传统的拼接字符串
var info1 = "我叫:"+ name +",我今年"+age+"岁！";
console.log(info1);

// es6的拼接字符串
var info2 = `我叫:${name},我明年${age+1}岁！`;
console.log(info2);
*/

//-----------------------------------

function test(){
    return "吃喝玩乐";
}

let str = `悲催的人生，从${test()}开始`;
console.log( str );
