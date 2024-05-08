package com.ssafy.ws.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.UserDao;
import com.ssafy.ws.model.dto.UserDto;

/**
 * UserServiceImpl은 UserService를 구현하는 클래스입니다.
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;

    @Override
    public UserDto getUserById(Long userId) throws SQLException {
        return userDao.selectOne(userId);
    }

    @Override
    public List<UserDto> getAllUsers() throws SQLException {
        return userDao.selectAll();
    }

    @Override
    public int insert(UserDto user) throws SQLException {
        return userDao.insert(user);
    }

    @Override
    public int update(UserDto user) throws SQLException {
        return userDao.update(user);
    }

    @Override
    public int delete(Long userId) throws SQLException {
        return userDao.delete(userId);
    }

    @Override
    public UserDto login(String loginId, String password) {
        return userDao.findByLoginIdAndPassword(loginId, password);
    }
}