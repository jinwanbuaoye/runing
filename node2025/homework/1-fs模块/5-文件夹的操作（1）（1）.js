const fs = require('fs');
//(1)创建文件夹
//异步

fs.mkdir('./上课.txt', { recursive: true }, (err) => {
  if (err) throw err;
  console.log('Folder created!');
});