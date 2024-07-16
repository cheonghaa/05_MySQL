package org.scoula.jdbc_ex.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserVO //테이블과 매핑됨 - 테이블을 클래스로 표현
{
    private String id;
    private String password;
    private String name;
    private String role;
}