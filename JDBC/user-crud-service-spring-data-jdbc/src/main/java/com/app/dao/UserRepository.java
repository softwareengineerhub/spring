package com.app.dao;

import com.app.model.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT * from user where name=:pName and age=:pAge")
    public List<User> findAllByNameAndAge(@Param("pName") String name, @Param("pAge") int age);

    @Modifying
    @Query("UPDATE User SET name= :pName, age= :pAge WHERE age= :age")
    public void updateUserByAge(@Param("pName") String pName, @Param("pAge") int pAge, @Param("age") int age);

    @Modifying
    @Query("DELETE FROM User WHERE name= :pName and age= :pAge")
    void deleteUserByNameAndAge(@Param("pName") String name, @Param("pAge") int age);
}
