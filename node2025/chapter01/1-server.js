//导包 从const/var/let 名字 = require('包名')
var http = require('http');

// 创建http 服务器
http.createServer(function (req,res){
    // 设置 HTTP头部
    // HTTP头部包含了以下字段：
    // HTTP版本 : HTTP/1.1
    // 状态码 : 200 : OK
    // 内容类型 : text/plain
    res.writeHead(200, {'Content-Type': 'text/plain'});
    // 发送 HTTP 响应数据
    res.end('Hello World!');

}).listen(3000);

// 终端打印如下信息

console.log('Server running at http://127.0.0.1:3000/');












