next = n =>
  //Promise的构造函数接收一个参数，是函数，
  //并且传入两个参数：resolve(异步操作执行成功后的回调函数)，reject(异步操作执行失败后的回调函数)
  new Promise(function(resolve, reject) {
    setTimeout(function() {
      resolve(n);
    }, 1000);
  });

next(1)
  .then(res => { // 成功
    console.log(res);
    return next(2); //在then方法中调用的next方法，一定要用return ，否则不会通过resolve把数据往下传递
  })
  .then(res => {
    console.log(res);
    return next(3);
  })
  .then(res => {
    console.log(res);
  })
  .catch(() => {  //处理失败：catch方法的第二个参数是失败的回调
    console.log("出错啦！");
  });