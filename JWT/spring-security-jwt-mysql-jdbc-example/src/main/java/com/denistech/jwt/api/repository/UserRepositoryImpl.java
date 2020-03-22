package com.denistech.jwt.api.repository;

import com.denistech.jwt.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private DataSource ds;


    @Override
    public User findByUsername(String username) {
        try (Connection c = ds.getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM usertbl WHERE username=?");
            ps.setObject(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //String username = rs.getString("username");
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String email = rs.getString("email");
                return new User(id, username, password, email);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createUser(User user) {
        try (Connection c = ds.getConnection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO usertbl(id, username, password, email) values(?, ?,?,?)");
            ps.setObject(1, user.getId());
            ps.setObject(2, user.getUsername());
            ps.setObject(3, user.getPassword());
            ps.setObject(4, user.getEmail());
            ps.execute();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void saveAll(List<User> users) {
        for(User u: users){
            createUser(u);
        }
    }

    @Override
    public void clear() {
        try(Connection c = ds.getConnection()){
            c.prepareStatement("DELETE FROM usertbl").execute();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
