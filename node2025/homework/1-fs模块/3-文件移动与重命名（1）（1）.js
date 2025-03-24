const fs = require('fs');
//异步的
fs.rename('./天气.txt','./天气1.txt',(err)=>{
    if(err) throw err;
    console.log('重命名成功')
});

//同步的

fs.renameSync('./上课.txt','./上课1.txt');
console.log('重命名成功')