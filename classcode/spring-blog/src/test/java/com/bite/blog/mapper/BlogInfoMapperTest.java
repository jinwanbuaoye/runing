package com.bite.blog.mapper;

import com.bite.blog.model.BlogInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogInfoMapperTest {
    @Autowired
    private BlogInfoMapper blogMapper;

    @Test
    void queryBlogList() {
        System.out.println(blogMapper.queryBlogList());
    }

    @Test
    void queryById() {
        System.out.println(blogMapper.queryById(1));
    }

    @Test
    void updateBlog() {
        BlogInfo blog = new BlogInfo();
        blog.setId(3);
        blog.setDeleteFlag(1);
        blog.setTitle("测试修改接口");
        blog.setContent("测试修改接口测试修改接口测试修改接口");
        blogMapper.updateBlog(blog);
    }

    @Test
    void deleteBlog() {

    }

    @Test
    void insertBlog() {
    }
}