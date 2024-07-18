package org.scoula.todo.dao;

import org.scoula.todo.common.JDBCUtil;
import org.scoula.todo.domain.TodoVO;
import org.scoula.todo.dto.PageRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoDaoImpl implements TodoDao{
    Connection conn = JDBCUtil.getConnection();
    @Override
    public int getTotalCount(String userId) throws SQLException {
        String sql = "select count(*) from todo where userid=?";        //집계함수 사용하기
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            try(ResultSet rs = stmt.executeQuery()) {                   //select query는 executeQuery로 호출
                rs.next();
                return rs.getInt(1);
            }
        }
    } @Override
    public int create(TodoVO todo) throws SQLException {
        String sql = "insert into todo(title, description, done, userid) values(?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
            stmt.setBoolean(3, todo.getDone());
            stmt.setString(4, todo.getUserId());
            return stmt.executeUpdate();
        }
    }
    private TodoVO map(ResultSet rs) throws SQLException {
        TodoVO todo = new TodoVO();
        todo.setId(rs.getLong("id"));
        todo.setTitle(rs.getString("title"));
        todo.setDescription(rs.getString("description"));
        todo.setDone(rs.getBoolean("done"));
        todo.setUserId(rs.getString("userid"));
        return todo;
    }

    private List<TodoVO> mapList(ResultSet rs) throws SQLException { //getList, search에서 사용
        List<TodoVO> todoList = new ArrayList<TodoVO>(); //비어있는 ArrayList 준비
        while (rs.next()) {
            TodoVO todo = map(rs); //행 하나하나 맵으로 변환 시키고
            todoList.add(todo);    // 리스트에 넣어준다.
        }
        return todoList;
    }

    @Override
    public List<TodoVO> getList(String user) throws SQLException
    {
        String sql = "select * from todo where userId = ?";         //로그인한 사용자 ID를 Where절에 작성
        try (PreparedStatement stmt = conn.prepareStatement
                (sql)){
            stmt.setString(1, user);
            try(ResultSet rs = stmt.executeQuery()) {
                return mapList(rs);                                 //앞에서 만들었던 mapList 호출 후 사용
            }
        }
    }

    @Override
    public Optional<TodoVO> get(String userId, Long id) throws SQLException
    {
        String sql = "select * from todo where userId = ? and id = ?";
        try (PreparedStatement stmt = conn.prepareStatement
                (sql)) {
            stmt.setString(1, userId);
            stmt.setLong(2, id);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    return Optional.of(map(rs));
                }
            }
        }
        return Optional.empty();
    }

    //Search : 검색어가 전달 됨
    @Override
    public List<TodoVO> search(String userId, String keyword) throws SQLException {
        String sql = "select * from todo where userId = ? and (title like ? or description like ?)";
        // -> 어디에서 검색을 할 것인가 (제목과 description에)
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, userId);
            stmt.setString(2, keyword);
            stmt.setString(3, keyword);
            try(ResultSet rs = stmt.executeQuery()) {
                return mapList(rs);
            }
        }
    }

    @Override
    public int update(String userId, TodoVO todo) throws SQLException {
        String sql = "update todo set title = ?, description = ?, done = ? where userId =? and id = ?";
        try ( PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
            stmt.setBoolean(3, todo.getDone());
            stmt.setString(4, userId);
            stmt.setLong(5, todo.getId());
            return stmt.executeUpdate();
        }
        //return 0;
    }

    @Override
    public int delete(String userId, Long id) throws SQLException {
        String sql = "delete from todo where userId = ? and id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {       //자동 닫기를 위해 try문 사용
            stmt.setString(1, userId);
            stmt.setLong(2, id);
            return stmt.executeUpdate();
        }
        //return 0;
    }

    //List
    @Override
    public List<TodoVO> getPage(String userId, PageRequest request) throws SQLException {
        String sql = "select * from todo where userId = ? limit ?, ?";  //limit가 들어갔다는 점이 차이점
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, userId);
            stmt.setInt(2, request.getOffset());            //getOffset을 불러서 계산한다.
            stmt.setInt(3, request.getSize());
            try(ResultSet rs = stmt.executeQuery()) {
                return mapList(rs);
            }
        }
    }

}