package com.bite.book.model;

import lombok.Data;

@Data
public class PageRequest {
        private Integer currentPage = 1; // 当前⻚
    private Integer pageSize = 10; // 每⻚中的记录数

    private Integer offset;
    public Integer getOffset() {
        return (currentPage-1) * pageSize;
    }
}
