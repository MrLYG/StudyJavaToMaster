function test( ...arg ){
    console.log(`传入了${arg.length}个参数`);
    for(var i = 0 ;i<arg.length;i++){
        console.log(arg[i]);
    }
}


test(1);
test(1,2);
test(1,2,3,4,5,6);
test();
test("郭","嘉",28);