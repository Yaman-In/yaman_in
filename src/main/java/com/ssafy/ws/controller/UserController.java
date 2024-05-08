package com.ssafy.ws.controller;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import com.ssafy.ws.model.dto.UserDto;
import com.ssafy.ws.model.service.UserService;

/**
 * UserController는 사용자 정보를 관리하는 컨트롤러입니다.
 * RESTful 서비스를 구현합니다.
 */
@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    // 모든 사용자 목록 조회
    // GET /user
    @GetMapping("")
    public ResponseEntity<List<UserDto>> list() throws SQLException {
        List<UserDto> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    // 사용자 상세 조회
    // GET /user/{userId}
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> detail(@PathVariable("userId") Long userId) throws SQLException {
        UserDto user = service.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // 사용자 등록
    // POST /user
    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody UserDto user) throws SQLException {
        int result = service.insert(user);
        if (result == 1) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User successfully registered.");
        } else {
            return ResponseEntity.badRequest().body("Failed to register user.");
        }
    }

    // 사용자 정보 수정
    // PUT /user/{userId}
    @PutMapping("/{userId}")
    public ResponseEntity<?> update(@PathVariable("userId") Long userId, @RequestBody UserDto user) throws SQLException {
        user.setUserId(userId);
        int result = service.update(user);
        return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // 사용자 삭제
    // DELETE /user/{userId}
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> delete(@PathVariable("userId") Long userId) throws SQLException {
        int result = service.delete(userId);
        return new ResponseEntity<>(result, result == 1 ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
    }

    // 사용자 등록 (회원가입 처리)
    // POST /perform_register
    @PostMapping("/perform_register")
    public ResponseEntity<?> performRegister(@ModelAttribute UserDto user) throws SQLException {
        ResponseEntity<?> response = insert(user);
        if (response.getStatusCode() == HttpStatus.CREATED) {
            // 리디렉션하는 로직을 추가
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("/index.html")); // 인덱스 페이지 URL을 설정
            return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
        }
        return response; // 기존 로직대로 반환
    }

    // 사용자 로그인 처리
    // POST /perform_login
//    @PostMapping("/perform_login")
//    public ResponseEntity<?> performLogin(@RequestParam String loginId, @RequestParam String password) {
//        UserDto user = service.login(loginId, password);
//		if (user != null) {
//		    return ResponseEntity.ok("User successfully logged in.");
//		} else {
//		    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
//		}
//    }
    
    @PostMapping("/perform_login")
    public RedirectView performLogin(@RequestParam String loginId, @RequestParam String password) {
        UserDto user = service.login(loginId, password);
        if (user != null) {
            return new RedirectView("/index.html"); // 로그인 성공시 리디렉션될 경로
        } else {
            return new RedirectView("/login.html"); // 로그인 실패시 리디렉션될 경로
        }
    }
}
