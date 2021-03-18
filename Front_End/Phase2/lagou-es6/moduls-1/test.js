let user = require("./user.js"); //引入user模块

console.log( user );

let result1 = user.addUser("吕布");
let result2 = user.removeUser(101);

console.log(result1);
console.log(result2);