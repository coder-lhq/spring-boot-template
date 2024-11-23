package org.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.demo.domain.Book;
import org.demo.service.BookService;
import org.demo.service.IBookService;
import org.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {

        if (book.getName().equals("123")) throw new IOException();
        return new R(bookService.save(book));
    }


    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable  Integer id) {
        return new R(bookService.removeById(id));
    }

    // http://localhost:8086/books/1
    @GetMapping("/{id}")
    public R getById(@PathVariable  Integer id) {
        return new R(true, bookService.getById(id));
    }


}
