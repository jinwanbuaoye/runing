package com.bite.book.controller;

import com.bite.book.model.BookInfo;
import com.bite.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;//告诉spring，从容器取出这个对象，赋值给当前对象属性


    @RequestMapping("getBookList")
    public List<BookInfo> getBookList(){
        //1.获取图书数据
        //2.对图书数据进行处理
        //3.返回数据

        List<BookInfo> bookInfos = bookService.getBookList();
        return bookInfos;
    }


}
