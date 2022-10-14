package com.benji.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public List<Item> getAllItems(){
    return jdbcTemplate.query("select * from items", new BeanPropertyRowMapper(Item.class));
  }


  public Item getItemById(int id){
    return jdbcTemplate.queryForObject("select * from items where id=?", new Object[]{id},
        new BeanPropertyRowMapper<Item>(Item.class));
  }

  public int insert(Item item){
    return jdbcTemplate.update(
        "insert into items(name, price, quantity, description) values(?,?,?,?)",
      new Object[]{item.getName(), item.getPrice(), item.getQuantity(), item.getDescription()});
  }

}
