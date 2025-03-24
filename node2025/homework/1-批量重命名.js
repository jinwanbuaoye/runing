//实验一:批量修改文件名
// 批量修改1-fs模块文件夹里的每一个文件后面都改名。
// 如：1-文件写入1.js 改为1-文件写入（1）.js
//1.读取文件夹目录
//2.批量改名。拼接文件名


const fs = require('fs');
const path = require('path');

const folderPath = '1-fs模块';

// 读取目标文件夹内的所有文件
fs.readdir(folderPath, (err, files) => {
    if (err) {
        console.error('读取文件夹失败:', err);
        return;
    }

    // 遍历
    files.forEach((file) => {
        const oldFilePath = path.join(folderPath, file);
        const fileBaseName = path.basename(file, path.extname(file));
        const fileExtension = path.extname(file);

        // 原文件名后面添加（1）
        const newFileName = fileBaseName + '（1）' + fileExtension;
        const newFilePath = path.join(folderPath, newFileName);

        // 重命名文件
        fs.rename(oldFilePath, newFilePath, (renameErr) => {
            if (renameErr) {
                console.error('重命名', file, '失败:', renameErr);
            } else {
                console.log('重命名', file, '成功，名字:', newFileName);
            }
        });
    });
});