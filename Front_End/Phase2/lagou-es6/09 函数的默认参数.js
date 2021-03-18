function test(name , age = 18){
    console.log(`我叫${name}，我今年${age}岁`);
}

test("吕布",33); //我叫吕布，我今年33岁
test("貂蝉"); //我叫貂蝉，我今年18岁
test("关羽",null); //我叫关羽，我今年null岁
test("马超",""); //我叫马超，我今年岁
test("张飞",undefined); //我叫张飞，我今年18岁