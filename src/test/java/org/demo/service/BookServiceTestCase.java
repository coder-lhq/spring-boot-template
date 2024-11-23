package org.demo.service;

import org.demo.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookService bookService;
    @Test
    public void testSave() {
        Book book = new Book();
        book.setType("测试service");
        book.setName("测试数据service");
        book.setDescription("测试mybatisplus的数据插入结果service");
        bookService.save(book);
    }
}
