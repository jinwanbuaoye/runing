package com.bite.book.service;

import com.bite.book.dao.BookDao;
import com.bite.book.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//告诉spring,帮我们存对象
public class BookService {
    @Autowired
    private BookDao bookDao;
    public List<BookInfo> getBookList(){

        List<BookInfo> bookInfos = bookDao.mockDate();
        for(BookInfo bookInfo: bookInfos){
            if (bookInfo.getStatus()==1){
                bookInfo.setStatusCN("可借阅");
            }else {
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }
}
