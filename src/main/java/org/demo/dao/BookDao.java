package org.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.demo.domain.Book;

@Mapper
public interface BookDao extends BaseMapper<Book> {

//    @Select("select * from tbl_book where id = #{id}")
//    Book getById(Integer id);
}
