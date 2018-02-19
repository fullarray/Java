package com.herrj.dao;

import java.util.List;

import com.herrj.model.User;

public interface UserDao {
   void save(User user);
   List<User> list();
}