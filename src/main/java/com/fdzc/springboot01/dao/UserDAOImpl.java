package com.fdzc.springboot01.dao;

import com.fdzc.springboot01.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO{
    @Resource
    private JdbcTemplate jdbcTemplate;


    @Override
    public void Insert(User user) {

        String userName = user.getUserName();
        String password = user.getPassword();
        String sql = "INSERT INTO `user` (`user_name`, `password`) VALUES ('"+userName+"', '"+password+"')";
        jdbcTemplate.execute(sql);

    }



    @Override
    public User GetByNameAndPW(User user) {
        String sql = "select * from user where `user_name` = " + "\"" +  user.userName + "\"" + " and password = " + "\"" + user.password +"\"";
        System.out.println("sql = " + sql);
        ArrayList<User> userList = (ArrayList<User>) jdbcTemplate.query(sql,new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        if(userList != null && userList.size() > 0){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public User GetByName(String name) {
        String sql = "select * from user where `user_name` = " + "\"" + name + "\"";
        System.out.println("sql = " + sql);
        ArrayList<User> userList = (ArrayList<User>) jdbcTemplate.query(sql,new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        return userList.get(0);
    }

    @Override
    public User GetByID(int id) {
        String sql = "select * from user where `id` = " + "\"" + id + "\"";
        System.out.println("sql = " + sql);
        ArrayList<User> userList = (ArrayList<User>) jdbcTemplate.query(sql,new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        return userList.get(0);
    }

    @Override
    public List<User> GetALL() {
        String sql = "select * from user";
        ArrayList<User>  userList = (ArrayList<User>) jdbcTemplate.query(sql,new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        return userList;
    }

    @Override
    public void Updata(User user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        String sql = "UPDATE `user` SET `password`='" + password + "' WHERE (`user_name`='"+userName+"')";
        jdbcTemplate.execute(sql);
    }



    @Override
    public void DeleteByName(int id) {
        String sql = "DELETE FROM `user` WHERE (`id`='"+id+"') ";
        jdbcTemplate.execute(sql);
    }
}
