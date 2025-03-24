const os = require('os');

//(1)操作系统信息获取
console.log(os.platform());//win32

console.log(os.arch());//x64

console.log(os.type());//Windows_NT

console.log(os.release());//10.0.26100

//(2)内存信息获取

console.log(os.totalmem());//16869548032 / 1024 ** 3 

console.log(os.freemem());//3101466624 / 1024 ** 3

//(3) CPU信息获取

console.log(os.cpus());

console.log(os.cpus().length);

console.log(os.cpus()[0].model);//12th Gen Intel(R) Core(TM) i5-12500H

//(4)获取网络信息
const x = os.networkInterfaces();
console.log(x.eth0);

//(5)用户和路径
console.log(os.homedir());//C:\Users\c'k

console.log(os.hostname());//chen