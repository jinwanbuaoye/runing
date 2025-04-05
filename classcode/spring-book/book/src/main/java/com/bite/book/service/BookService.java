package com.bite.book.service;

import com.bite.book.enums.BookStatuEnum;
import com.bite.book.mapper.BookInfoMapper;
import com.bite.book.model.BookInfo;
import com.bite.book.model.PageRequest;
import com.bite.book.model.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
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

        if(bookinfos != null && bookinfos.size()>0){
            for (BookInfo bookInfo:bookinfos){
                //根据status 获取状态定义
                bookInfo.setStatusCN(BookStatuEnum.getNameByCode(bookInfo.getStatus()).getName());
            }
        }

        return new PageResult<>(bookinfos,count,pageRequest);
    }

    /**
     * 添加图书
     * @param bookInfo
     */
    public Integer addBook(BookInfo bookInfo) {
        Integer result = 0;
        try {
            result = bookInfoMapper.insertBook(bookInfo);
            if (result <= 0){
                log.error("添加图书出错:bookInfo:{}",bookInfo);
            }
        }catch (Exception e){
            log.error("添加图书出错，e：{}",e);
        }
        return result;
    }

    public BookInfo queryBookInfoById(Integer id){
        return bookInfoMapper.queryBookInfoById(id);
    }

    public Integer updateBook(BookInfo bookInfo){
        Integer result = 0;
        try{
           result = bookInfoMapper.updateBook((bookInfo));
        }catch (Exception e){
            log.error("更新图书失败，e:{}",e);
        }
        return result;
    }

    public Integer batchDelete(List<Integer> ids){
        Integer result = 0;
        try{
            result = bookInfoMapper.batchDelete(ids);
        }catch (Exception e){
            log.error("批量删除失败，ids:{}",ids);
        }

        return result;
    }
}
