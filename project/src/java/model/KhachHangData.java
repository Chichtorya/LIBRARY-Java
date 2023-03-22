/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Object.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaara
 */
public class KhachHangData {
     public Connection con = null;
  public PreparedStatement ps = null;
  public ResultSet rs = null;
  public String xSql = null;
    public KhachHang dangNhap(String taiKhoan, String pass) {
        KhachHang kh = null;
        try{
            ps = con.prepareStatement("SELECT * FROM KHACH_HANG where Ma_Khach_hang = ? and Password=?");
            ps.setString(1, taiKhoan);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()) {
                kh = new KhachHang();
               // kh.setMaKH(rs.getString("Ma_Khach_hang"));
               // kh.setPass(rs.getString("Password"));
                kh.setBirth(rs.getDate("Ngay_sinh"));
                kh.setName(rs.getString("Ten_Khach_hang"));
                kh.setDiaChi(rs.getString("Dia_chi"));
                kh.setPhone(rs.getString("Phone"));
            }
        }
        catch(Exception e) {
            return kh = null;
        }
        return kh;
    }
    
    
    public  ResultSet showTextfield(String sql) {
        try {
            ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    
     public  void InsertKhachHang(KhachHang kh) {
        String sql = "insert into KHACH_HANG values(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getPass());
            ps.setString(3, kh.getName());
            ps.setDate(4, kh.getBirth());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getPhone());
            ps.setString(7, "Nguyễn Hoàng Hải");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm khách hàng thành công!" , "Thông báo", 1);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Khách hàng không được thêm" , "Thông báo", 1);
        }
    }
    
    public boolean UpdateKhachHang(KhachHang kh) {
        try {
            ps = con.prepareStatement("UPDATE KHACH_HANG SET Password = ?, Ten_Khach_hang = ?,"
                    + "Ngay_sinh = ?, Dia_chi = ?, Phone = ? where Ma_Khach_hang = ?");
            ps.setString(6, kh.getMaKH());
            ps.setString(1, kh.getPass());
            ps.setString(2, kh.getName());
            ps.setDate(3, kh.getBirth());
            ps.setString(4, kh.getDiaChi());
            ps.setString(5, kh.getPhone());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeleteKhachHang(String maKH) {
        try {
            ps = con.prepareStatement("DELETE FROM KHACH_HANG WHERE Ma_Khach_hang = ?");
            ps.setString(1, maKH);
            return ps.executeUpdate() >0;
        } catch(Exception e) {
            return false;
        }
    }
    
}
