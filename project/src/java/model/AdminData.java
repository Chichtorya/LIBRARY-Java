/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Object.Admin;
import Object.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gaara
 */
public class AdminData extends MyDAO{



    public Admin login(String taiKhoan, String pass) {
        Admin ad = new Admin();
        xSql = "SELECT * FROM [QUAN_TRI] where Ma_Admin = ? and Password=?";

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, taiKhoan);
            ps.setString(2, pass);

            rs = ps.executeQuery();

            String name = rs.getString("Ma_Admin");
            String Pass = rs.getString("Password");

            ad.setMaAdmin(name);
            ad.setPassword(Pass);
            rs.close();
            ps.close();
        } catch (SQLException e) {
            return ad;
        }
        System.out.println(ad);
        return ad;
    }

    public ResultSet showTextfield(String sql) {
        try {
            ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }

    }

    public boolean UpdateAdmin(Admin ad) {
        try {
            ps = con.prepareStatement("UPDATE QUAN_TRI SET Password = ? where Ma_Admin = ?");
            ps.setString(2, ad.getMaAdmin());
            ps.setString(1, ad.getPassword());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean DeleteAdmin(String maAd) {
        try {
            ps = con.prepareStatement("DELETE FROM QUAN_TRI WHERE Ma_Admin = ?");
            ps.setString(1, maAd);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
