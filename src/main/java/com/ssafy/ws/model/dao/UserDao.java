package com.ssafy.ws.model.dao;

import java.util.List;
import com.ssafy.ws.model.dto.UserDto;

public interface UserDao {
    List<UserDto> selectAll(); // 모든 사용자 정보 조회
    UserDto selectOne(Long userId); // 특정 사용자 정보 조회
    int insert(UserDto user); // 사용자 정보 추가
    int update(UserDto user); // 사용자 정보 수정
    int delete(Long userId); // 사용자 정보 삭제
    UserDto findByLoginIdAndPassword(String loginId, String password);
}
