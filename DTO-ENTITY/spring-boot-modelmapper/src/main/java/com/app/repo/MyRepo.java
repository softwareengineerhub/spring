package com.app.repo;

import com.app.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MyRepo {
    private List<User> data = new ArrayList<>();

    public void create(User user){
        data.add(user);
    }

    public List<User> readAll(){
        return data;
    }

    public User read(int id){
        return data.get(id);
    }

    public void update(User candidate){
        data.set((int) candidate.getId(), candidate);
    }

    public void deleteAll(){
        data.clear();
    }

    public void delete(int id){
        data.remove(id);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public int size(){
        return data.size();
    }
}
