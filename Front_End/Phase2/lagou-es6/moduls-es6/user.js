let name = "老孙";
let age = 66;
let fn = function(){
    return `我是${name}!我今年${age}岁了！`;
}

// 声明模块并导出
export{
    name as a,
    age as b,
    fn as c
}