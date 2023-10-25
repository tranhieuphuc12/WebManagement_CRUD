/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import core.DanhMuc;
import core.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class SanPhamDAO {
    //Ham tim kiem san pham theo ten hoac chi tiet
    public static SanPham timKiemSanPham(String key) {
        SanPham sanPham = new SanPham();
        try {
            Connection con = DatabaseUntil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT `ma_san_pham`, `ten_san_pham`, `gia`, `mo_ta`, `ma_danh_muc` FROM `san_pham` WHERE `ten_san_pham` =? OR `mo_ta`= ?");
            ps.setString(1, key);
            ps.setString(2, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                sanPham.setMaSanPham(rs.getString(1));
                sanPham.setTenSanPham(rs.getString(2));
                sanPham.setGia(Integer.parseInt(rs.getString(3)));
                sanPham.setMoTa(rs.getString(4));
                sanPham.setMaDanhMuc(rs.getString(5));
                
            }
            con.close();
        } catch (Exception e) {
        }
        return sanPham;
    }
    //Ham lay san pham theo danh muc 
    public static ArrayList<SanPham> laySanPhamTheoDanhMuc(String maDanhMuc) {
        ArrayList<SanPham> list = new ArrayList<SanPham>();
        try {
            Connection con = DatabaseUntil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM `san_pham` WHERE `ma_danh_muc` = ? ");
            ps.setString(1, maDanhMuc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(rs.getString(1));
                sanPham.setTenSanPham(rs.getString(2));
                sanPham.setGia(Integer.parseInt(rs.getString(3)));
                sanPham.setMoTa(rs.getString(4));
                sanPham.setMaDanhMuc(rs.getString(5));
                list.add(sanPham);
            }
            con.close();
        } catch (Exception e) {
        }
        return list;
    }
    //Ham lay san pham 
    public static ArrayList<SanPham> layTatCaSanPham() {
        ArrayList<SanPham> list = new ArrayList<SanPham>();
        try {
            Connection con = DatabaseUntil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM `san_pham` ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(rs.getString(1));
                sanPham.setTenSanPham(rs.getString(2));
                sanPham.setGia(Integer.parseInt(rs.getString(3)));
                sanPham.setMoTa(rs.getString(4));
                sanPham.setMaDanhMuc(rs.getString(5));
                list.add(sanPham);
            }
            con.close();
        } catch (Exception e) {
        }
        return list;
    }

    //Ham them danh muc
    public static int themSanPham(SanPham sanPham) {
        int status = 0;
        try {
            Connection con = DatabaseUntil.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO `san_pham`(`ma_san_pham`, `ten_san_pham`, `gia`, `mo_ta`, `ma_danh_muc`) VALUES (?,?,?,?,?)");
            ps.setString(1, sanPham.getMaSanPham());
            ps.setString(2, sanPham.getTenSanPham());
            ps.setString(3, sanPham.getGia()+"");
            ps.setString(4, sanPham.getMoTa());
            ps.setString(5, sanPham.getMaDanhMuc());

            status = ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    //Ham xoa danh muc 
    public static int xoaSanPham(String maSanPham) {
        int status = 0;
        try {
            Connection con = DatabaseUntil.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM `san_pham` WHERE `ma_san_pham` =?");
            ps.setString(1, maSanPham);

            status = ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    //Ham sua thong tin 

    public static int suaSanPham(SanPham sanPham) {
        int status = 0;
        try {
            Connection con = DatabaseUntil.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE `san_pham` SET`ten_san_pham`=?,`gia`=?,`mo_ta`=?,`ma_danh_muc`=? WHERE  `ma_san_pham`=?");
            ps.setString(1, sanPham.getTenSanPham());
            ps.setString(2, sanPham.getGia()+"");
            ps.setString(3, sanPham.getMoTa());
            ps.setString(4, sanPham.getMaDanhMuc());
            ps.setString(5, sanPham.getMaSanPham());

            status = ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    public static void main(String[] args) {
//        for(SanPham sp : laySanPhamTheoDanhMuc("2")){
//            System.out.println(sp.toString());
//        }
//System.out.println(suaSanPham(new SanPham("sp01", "naruto", 19000, "motamotamota", "02")));
//xoaSanPham("sp02");
System.out.println(timKiemSanPham("sp01").toString());
    }
}
