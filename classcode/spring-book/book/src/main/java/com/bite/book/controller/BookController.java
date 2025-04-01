package com.bite.book.controller;

import com.bite.book.model.BookInfo;
import com.bite.book.model.PageRequest;
import com.bite.book.model.PageResult;
import com.bite.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Slf4j
@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;//告诉spring，从容器取出这个对象，赋值给当前对象属性


    @RequestMapping("/getBookListByPage")
    public PageResult<BookInfo> getBookListByPage(PageRequest pageRequest) {
        log.info("查询翻页信息，pageRequest:{}",pageRequest);
        if(pageRequest.getPageSize()<0 || pageRequest.getCurrentPage()<1){
            return null;
        }
        PageResult<BookInfo> bookInfoPageResult = null;
        try{
            bookInfoPageResult = bookService.selectBookInfoByPage(pageRequest);
        }catch (Exception e){
            log.error("查询翻页信息错误，e:{}",e);
        }
        return bookInfoPageResult;
    }

}
