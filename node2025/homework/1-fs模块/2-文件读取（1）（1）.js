//导入fs模块 
const fs = require('fs');

//fs.readFile异步读取
fs.readFile('./天气.txt',(err, data) => {
    if (err) throw err;
        console.log(data);
    });

fs.readFile('./天气.txt','utf-8',(error, data) => {
    if (error) throw error;
        console.log(data);
    });

//(2)同步读取
const data = fs.readFileSync('./天气.txt');

console.log(data.toString());

const data1 = fs.readFileSync('./天气.txt','utf8');

//(3)流式读取

const crs = fs.createReadStream('./上课.txt');

crs.on('data', (data) => {
    console.log(data.toString());
});

crs.on('end', () => {
    console.log('读取结束');
});
