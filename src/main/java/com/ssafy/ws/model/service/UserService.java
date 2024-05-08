package com.ssafy.ws.model.service;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.ws.model.dto.UserDto;

/**
 * UserService는 사용자 정보를 관리하는 서비스 인터페이스입니다.
 * 해당 인터페이스는 UserServiceImpl에서 구현됩니다.
 * 객체지향의 다형성을 이용하여 유연한 코드를 작성하기 위함입니다.
 */
public interface UserService {

    UserDto getUserById(Long userId) throws SQLException;
    List<UserDto> getAllUsers() throws SQLException;
    int insert(UserDto user) throws SQLException; // 정보
    int update(UserDto user) throws SQLException;
    int delete(Long userId) throws SQLException;
	UserDto login(String loginId, String password);
}