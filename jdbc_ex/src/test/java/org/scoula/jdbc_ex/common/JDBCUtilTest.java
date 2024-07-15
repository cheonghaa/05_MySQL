package org.scoula.jdbc_ex.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCUtilTest {

    @Test
    @DisplayName("jdbc_ex에 접속합니다.")
    void getConnection() throws SQLException {
        try(Connection conn = JDBCUtil.getConnection()) {
            System.out.println("DB 연결 성공"); //예외 처리 안 됨 -> 자동 닫기 기능 사용 위해서
        }
    }
}