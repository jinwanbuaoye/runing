package com.bite.book.service;

import com.bite.book.mapper.BookInfoMapper;
import com.bite.book.model.BookInfo;
import com.bite.book.model.PageRequest;
import com.bite.book.model.PageResult;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//告诉spring,帮我们存对象
public class BookService {
    @Autowired
    private BookInfoMapper bookInfoMapper;

    public PageResult<BookInfo> selectBookInfoByPage(PageRequest pageRequest) {
        if(pageRequest == null){
            return null;
        }
        //获取总记录数
        Integer count = bookInfoMapper.count();

        //获取当前记录
        List<BookInfo> bookinfos = bookInfoMapper.selectBookInfoByPage(pageRequest.getOffset(), pageRequest.getPageSize());


        return new PageResult<>(bookinfos,count,pageRequest);
    }
}
