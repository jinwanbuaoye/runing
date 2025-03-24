//buffer的创建与使用

//(1)buffer.alloc()表示存多少位
let buf_1 = Buffer.alloc(10);
//console.log(buf_1);

//(2)buffer.allocUnsafe 速度会比第一个快，使用时候要注意内存空间是否是空的
let buf_2 = Buffer.allocUnsafe(10);
//console.log(buf_2);

//(3)buffer.from()表示将字符串转化为buffer
let buf_3 = Buffer.from('hello');
//console.log(buf_3);
let buf_4 = Buffer.from([105,108,11,111,118,101,117]);
console.log(buf_4);

//(4)buffer.toString()表示将buffer转化为字符串
console.log(buf_4.toString());

//(5)查看某一位
console.log(buf_3[1]);
