let user1 = {
    name:"项羽",
    age:34
};

let user2 = {head:"诸葛亮"};

let user = {...user1,...user2};

console.log( user );