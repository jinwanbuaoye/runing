package com.bite.book.controller;

import com.bite.book.constant.Constans;
import com.bite.book.enums.ResultCode;
import com.bite.book.model.*;
import com.bite.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;//告诉spring，从容器取出这个对象，赋值给当前对象属性


    @RequestMapping("/getBookListByPage")
    public Result getBookListByPage(PageRequest pageRequest, HttpSession session) {
        log.info("查询翻页信息，pageRequest:{}",pageRequest);
        //用户登录校验
//        UserInfo userInfo = (UserInfo) session.getAttribute(Constans.SESSION_USER_KEY);
//        if (userInfo==null || userInfo.getId()<=0 || "".equals(userInfo.getUserName())){
//            //用户未登录
//            return Result.unlogin();
//        }

        //校验成功
        if(pageRequest.getPageSize()<0 || pageRequest.getCurrentPage()<1){
            return Result.fail("参数校验失败");
        }
        PageResult<BookInfo> bookInfoPageResult = null;
        try{
            bookInfoPageResult = bookService.selectBookInfoByPage(pageRequest);
            return Result.success(bookInfoPageResult);
        }catch (Exception e){
            log.error("查询翻页信息错误，e:{}",e);
            return Result.fail(e.getMessage());
        }

    }

    @RequestMapping(value = "/addBook",produces = "application/json")
    public String addBook(BookInfo bookInfo){
        log.info("接收到添加图书请求");

        if (!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount()==null
                || bookInfo.getPrice()==null
                || !StringUtils.hasLength(bookInfo.getPublish())
                || bookInfo.getStatus() ==null
        ) {
            return "输⼊参数不合法, 请检查⼊参!";
        }

       Integer result = bookService.addBook(bookInfo);

        if(result <= 0){
            log.error("添加图书出错:bookInfo:{}",bookInfo);
            return "添加图书出错，请联系管理员";
        }
        return "";
    }

    @RequestMapping("queryBookInfoById")
    public BookInfo queryBookInfoById(Integer bookId){
        log.info("根据ID查询图书，bookId:"+bookId);

        try{
            BookInfo bookInfo = bookService.queryBookInfoById(bookId);
            return bookInfo;
        }catch (Exception e){
            log.error("查询图书失败，e:{}",e);
        }
        return null;
    }

    @RequestMapping(value = "/updateBook", produces = "application/json")
    public String updateBook(BookInfo bookInfo){
        log.info("接收到更新图书的请求，bookInfo:{}",bookInfo);
        Integer result = bookService.updateBook(bookInfo);
        if(result == 0){
            log.error("更新图书失败，请联系管理员");
            return "更新图书失败，请联系管理员";
        }
        return "";
    }

    @RequestMapping(value = "/batchDelete",produces = "application/json")
    public String batchDelete(@RequestParam List<Integer> ids){
        log.info("接收请求，批量删除图书, ids:{}",ids);
        Integer result = bookService.batchDelete(ids);
        if (result <= 0){
            log.error("批量删除失败，请联系管理员");
            return "批量删除失败，请联系管理员";
        }
        return "";
    }

}
