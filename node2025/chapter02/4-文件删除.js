const fs = require('fs');

/*fs.unlink('./天气1.txt',(err)=>{
    if(err) throw err;
    console.log('天气1.txt已删除');
})*/

fs.unlinkSync('./吃饭.txt');
console.log('已删除');