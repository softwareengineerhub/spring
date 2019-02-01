/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch01.nospring.spring5.jdbc.dao;

import com.ch01.nospring.spring5.jdbc.model.Album;
import com.ch01.nospring.spring5.jdbc.model.Singer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public class PlainSingerDao implements SingerDao {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Singer> findAll() {
        try (Connection c = getConnection()) {
            List<Singer> list = new ArrayList();
            ResultSet rs = c.prepareStatement("SELECT * FROM singer").executeQuery();
            while (rs.next()) {
                Singer singer = new Singer();
                singer.setBirthDate(rs.getDate("birth_date"));
                singer.setFirstName("first_name");
                singer.setLastName("last_name");
                singer.setId(rs.getLong("id"));
                list.add(singer);
            }
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        try (Connection c = getConnection()) {
            List<Singer> list = new ArrayList();
            ResultSet rs = c.prepareStatement("SELECT * FROM singer where first_name=" + firstName).executeQuery();
            while (rs.next()) {
                Singer singer = new Singer();
                singer.setBirthDate(rs.getDate("birth_date"));
                singer.setFirstName("first_name");
                singer.setLastName("last_name");
                singer.setId(rs.getLong("id"));
                list.add(singer);
            }
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String findLastNameById(Long id) {
        try (Connection c = getConnection()) {
            ResultSet rs = c.prepareStatement("SELECT * FROM singer where id=" + id).executeQuery();
            while (rs.next()) {
                return rs.getString("last_name");
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String findFirstNameById(Long id) {
        try (Connection c = getConnection()) {
            ResultSet rs = c.prepareStatement("SELECT * FROM singer where id=" + id).executeQuery();
            while (rs.next()) {
                return rs.getString("first_name");
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void insert(Singer singer) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO singer(first_name, last_name, birth_date) VALUES(?,?,?)");
            ps.setObject(1, singer.getFirstName());
            ps.setObject(2, singer.getLastName());
            ps.setObject(3, singer.getBirthDate());
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Singer singer) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("UPDATE singer SET first_name=?, last_name=?, birth_date=? WHERE id=?");
            ps.setObject(1, singer.getFirstName());
            ps.setObject(2, singer.getLastName());
            ps.setObject(3, singer.getBirthDate());
            ps.setObject(4, singer.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Long singerId) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("DELETE FROM singer WHERE id=?");
            ps.setObject(1, singerId);
            ps.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Singer> findAllWithDetail() {
        try (Connection c = getConnection()) {
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
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void insertWithDetail(Singer singer) {
        try (Connection c = getConnection()) {
            c.setAutoCommit(false);

            PreparedStatement ps = c.prepareStatement("INSERT INTO singer(first_name, last_name, birth_date) VALUES(?,?,?)");
            ps.setObject(1, singer.getFirstName());
            ps.setObject(2, singer.getLastName());
            ps.setObject(3, singer.getBirthDate());
            ps.execute();

            for (Album album : singer.getAlbums()) {
                ps = c.prepareStatement("INSERT INTO album(title, release_date, singer_id) VALUES(?,?,?)");
                ps.setObject(1, album.getTitle());
                ps.setObject(2, album.getReleaseDate());
                ps.setObject(3, album.getSingerId());
                ps.execute();
            }

            c.commit();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_schema?useSSL=false", "root", "111111");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
