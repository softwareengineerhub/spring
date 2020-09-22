package com.app.service;

import com.app.entity.User;
import com.app.repo.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private MyRepo myRepo;

    public void create(User user){
        myRepo.create(user);
    }

    public List<User> readAll(){
        return myRepo.readAll();
    }

    public User read(int id){
        return myRepo.read(id);
    }

    public void update(User candidate){
        myRepo.update(candidate);
    }

    public void deleteAll(){
        myRepo.deleteAll();
    }

    public void delete(int id){
        myRepo.delete(id);
    }

    public boolean isEmpty(){
        return myRepo.isEmpty();
    }

    public int size(){
        return myRepo.size();
    }

}
