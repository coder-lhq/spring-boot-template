package org.demo.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.logging.log4j.util.Strings;
import org.demo.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    public void testSave() {
        Book book = new Book();
        book.setType("测试");
        book.setName("测试数据");
        book.setDescription("测试mybatisplus的数据插入结果");
        bookDao.insert(book);
    }

    @Test
    public void testUpdate() {
        Book book = new Book();
        book.setId(11);
        book.setType("测试123");
        book.setName("测试数据123");
        book.setDescription("测试mybatisplus的数据插入结果123");
        bookDao.updateById(book);
    }

    @Test
    public void testDelete() {
        bookDao.deleteById(10);
    }

    @Test
    public void testGetAll() {
        System.out.println("bookDao.selectList(null) = " + bookDao.selectList(null));
    }

    @Test
    public void testGetPage() {
        IPage page = new Page(1, 5);
        bookDao.selectPage(page ,null);
        System.out.println("page.getPages() = " + page.getPages());
        System.out.println("page.getCurrent() = " + page.getCurrent());
        System.out.println("page.getRecords() = " + page.getRecords());
        System.out.println("page.getSize() = " + page.getSize());
        System.out.println("page.getTotal() = " + page.getTotal());
    }

    @Test
    public void testGetBy() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "Spring");
        bookDao.selectList(qw);
    }

    @Test
    public void testGetBy2() {
        String name = null;
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isEmpty(name), Book::getName, name);
        bookDao.selectList(lqw);
    }
}
