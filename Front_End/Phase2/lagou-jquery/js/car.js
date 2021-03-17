$(".jia").click(function(){
    var i = $(this).prev().text(); //获得原来的商品数量
    i++;
    $(this).prev().text(i); //现在的商品数量

    var price = $(this).parent().prev().text(); //商品单价
    var zong = i*price; //商品总价
    $(this).parent().next().text( zong );// 现在商品的总价

    getTotal();
});


$(".jian").click(function(){
    var i = $(this).next().text();
    i--;

    if(i == 0){  //询问用户数量已经是0了，是否删除该商品
        if( confirm("是否删除该商品？") ){
            $(this).parents("tr").remove();
        }
    }else{
        $(this).next().text(i);

        var price = $(this).parent().prev().text(); //商品单价
        var zong = i*price; //商品总价
        $(this).parent().next().text( zong );// 现在商品的总价
    }

    getTotal();
});

//计算所有商品的总价
// function getTotal(){
//     var sum = 0; // 总价钱
//     var arr = $("tr:not(tr:first)").find("td:last");
//     for(var i = 0;i<arr.length ; i++){
//        sum += Number(arr[i].innerHTML) ;
//     }
    
//     $("b").text(sum);
// }

function getTotal(){
    var sum = 0; // 总价钱
    $("tr:not(tr:first)").find("td:last").each(function(){
         sum += Number($(this).text());
    });
    $("b").text(sum);
}