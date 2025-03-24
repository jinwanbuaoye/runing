//文件写入的几种方式

//导入fs模块 
const fs = require('fs');

// 1. fs.writeFile方法（异步写入）
/*fs.writeFile('./天气.txt','今天天气阴，还要早起，这很不合理',(err)=>{
    if(err) throw err;
    console.log('数据已被写入天气.txt')
});*/

// 2. fs.writeFileSync方法（同步写入）
//fs.writeFileSync('./吃饭.txt','今天吃外卖，贵且不好吃，但是莫得办法');
//console.log('同步写入成功')

// 3. fs.appendFile方法（异步追加）fs.appendFileSync(同步追加)
/*fs.appendFile('./上课.txt','今天上课敲代码',(err)=>{
    if(err) throw err;
    console.log('数据已被追加到上课.txt')
})

fs.appendFileSync('./睡觉.txt','今天又是没睡好的一天')
console.log('追加成功')*/

// 4. fs.createWriteStream(流式写入)
let ws = fs.createWriteStream('./静夜思.txt');
ws.write('床前明月光\r\n');
ws.write('疑是地上霜\r\n');
ws.write('举头望明月\r\n');
ws.write('低头思故乡\r\n');
ws.end(); //写入结束