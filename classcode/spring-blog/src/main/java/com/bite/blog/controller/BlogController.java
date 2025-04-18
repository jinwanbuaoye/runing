package com.bite.blog.controller;

import com.bite.blog.model.BlogInfo;
import com.bite.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    //获取博客列表
    @RequestMapping("/getlist")
    public List<BlogInfo> getBlogList() {
        return blogService.getBlogList();
    }

    //获取博客详情
    @RequestMapping("/getBlogDetail")
    public BlogInfo getBlogDeatail(Integer blogId){
        return blogService.getBlogDeatil(blogId);
    }
}
