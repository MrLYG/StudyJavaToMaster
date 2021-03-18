let name = `吕布`;
let age = 28;

//传统
let user1 = {
    name : name,
    age : age
};
console.log(user1);

//es6新语法中的简写
let user2 = {name,age};
console.log(user2);