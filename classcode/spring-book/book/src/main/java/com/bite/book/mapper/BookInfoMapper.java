package com.bite.book.mapper;

import com.bite.book.model.BookInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    /**
     * 获取当前页信息
     * @param offset
     * @param pageSize
     * @return
     */
    @Select("select * from book_info where status != 0 " +
            "order by id desc limit #{offset},#{pageSize};")
    List<BookInfo> selectBookInfoByPage(@Param("offset")Integer offset, @Param("pageSize")Integer pageSize);

    /**
     * 获取总记录数
     * @return
     */
    @Select("select count(1) from book_info where status != 0")
    Integer count();

    @Insert("insert into book_info (book_name,author,count,price,publish,status)" +
            "values (#{bookName},#{author},#{count},#{price},#{publish},#{status})")
    Integer insertBook(BookInfo bookInfo);

    @Select("select id, book_name, author, count, price, publish, `status`, create_time, update_time " +
            "from book_info where id=#{bookId} and status<>0")
    BookInfo queryBookInfoById(Integer bookId);


    Integer updateBook(BookInfo bookInfo);

    Integer batchDelete(@Param("ids") List<Integer> ids);
}
