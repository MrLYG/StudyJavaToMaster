function addUser(name){
    return `保存${name}成功！`;
}

function removeUser(id){
    return `删除${id}号用户！`;
}

// 声明模块并导出
// module.exports={
//     save:addUser,
//     delete:removeUser
// }

// 声明模块导出的简写
module.exports={
    addUser,
    removeUser
}
