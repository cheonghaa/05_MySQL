package org.scoula.todo.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO //테이블과 매핑됨 - 테이블을 클래스로 표현
{
    private String id;
    private String password;
    private String name;
    private String role;
}