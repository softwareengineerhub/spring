/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch02.spring.spring5.jdbc;

import com.ch01.nospring.spring5.jdbc.dao.SingerDao;
import com.ch01.nospring.spring5.jdbc.model.Album;
import com.ch01.nospring.spring5.jdbc.model.Singer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Denys.Prokopiuk
 */
@Repository
public class MySingerTemplateDao implements SingerDao {

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Singer> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String findLastNameById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String findFirstNameById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Singer singer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Singer singer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long singerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Singer> findAllWithDetail() {
        return template.execute(new ConnectionCallback<List<Singer>>() {

            @Override
            public List<Singer> doInConnection(Connection c) throws SQLException, DataAccessException {
                PreparedStatement ps = c.prepareStatement("SELECT singer.*, album.title, album.release_date, album.id as aid  from singer JOIN album on singer.id=album.singer_id ORDER BY singer.id");
                ResultSet rs = ps.executeQuery();
                List<Singer> list = new ArrayList();
                Singer singer = null;
                while (rs.next()) {
                    long id = rs.getLong("id");
                    if (singer == null || id != singer.getId()) {
                        singer = new Singer();
                        singer.setFirstName(rs.getString("FIRST_NAME"));
                        singer.setLastName(rs.getString("LAST_NAME"));
                        singer.setBirthDate(rs.getDate("BIRTH_DATE"));
                        singer.setId(id);
                        list.add(singer);
                        Album album = new Album();
                        album.setReleaseDate(rs.getDate("release_date"));
                        album.setSingerId(id);
                        album.setId(rs.getLong("aid"));
                        singer.addAbum(album);
                    } else {
                        Album album = new Album();
                        album.setReleaseDate(rs.getDate("release_date"));
                        album.setSingerId(id);
                        album.setId(rs.getLong("aid"));
                        singer.addAbum(album);
                    }
                }
                return list;
            }

        });
    }

    @Override
    public void insertWithDetail(Singer singer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
