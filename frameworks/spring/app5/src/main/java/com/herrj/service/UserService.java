package com.herrj.service;

import java.util.List;

import com.herrj.model.User;

public interface UserService {
   void save(User user);
   List<User> list();
}