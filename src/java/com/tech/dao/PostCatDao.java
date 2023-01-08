/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.dao;

import com.tech.entity.categories;
import java.sql.*;
import java.util.ArrayList;

public class PostCatDao {

    private Connection con;

    public PostCatDao(Connection con) {
        this.con = con;
    }

    public ArrayList<categories> cat() {
        ArrayList<categories> list = new ArrayList<>();
        try {
            String q = "select * from categories";
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery(q);
            while (rs.next()) {
                int cid = rs.getInt("cid");
                String cname = rs.getString("cname");
                String dec = rs.getString("dec");
                categories cat = new categories(cid, cname, dec);
                list.add(cat);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;

    }
}