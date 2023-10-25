/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import core.DanhMuc;
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
public class DanhMucDAO {

//	// Ham Tim Danh Muc
//	public static DanhMuc timDanhMuc(String maDanhMuc) {
//		DanhMuc danhMuc = new DanhMuc();
//		try {
//			Connection con = DatabaseUntil.getConnection();
//			PreparedStatement ps = con.prepareStatement(
//					"SELECT `ma_danh_muc`,`ten_danh_muc`, `ghi_chu` FROM `danh_muc` WHERE `ma_danh_muc` = 1  ");
//			ResultSet rs = ps.executeQuery();
//			danhMuc.setMaDanhMuc(rs.getString(1));
//			danhMuc.setTenDanhMuc(rs.getString(2));
//			danhMuc.setGhiChu(rs.getString(3));
//
//			con.close();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return danhMuc;
//	}

	// Ham Lay Tat Ca Danh Muc
	public static ArrayList<DanhMuc> layTatCaDanhMuc() {
		ArrayList<DanhMuc> list = new ArrayList<DanhMuc>();
		try {
			Connection con = DatabaseUntil.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM `danh_muc` ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DanhMuc danhMuc = new DanhMuc();
				danhMuc.setMaDanhMuc(rs.getString(1));
				danhMuc.setTenDanhMuc(rs.getString(2));
				danhMuc.setGhiChu(rs.getString(3));
				list.add(danhMuc);
			}
			con.close();
		} catch (Exception e) {
		}
		return list;
	}

	// Ham them danh muc
	public static int themDanhMuc(DanhMuc danhMuc) {
		int status = 0;
		try {
			Connection con = DatabaseUntil.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO `danh_muc`(`ma_danh_muc`, `ten_danh_muc`, `ghi_chu`) VALUES (?,?,?)");
			ps.setString(1, danhMuc.getMaDanhMuc());
			ps.setString(2, danhMuc.getTenDanhMuc());
			ps.setString(3, danhMuc.getGhiChu());

			status = ps.executeUpdate();
			con.close();

		} catch (SQLException ex) {
			Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return status;
	}

	// Ham xoa danh muc
	public static int xoaDanhMuc(String maDanhMuc) {
		int status = 0;
		try {
			Connection con = DatabaseUntil.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM `danh_muc` WHERE `ma_danh_muc`= ?");
			ps.setString(1, maDanhMuc);

			status = ps.executeUpdate();
			con.close();

		} catch (SQLException ex) {
			Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return status;
	}
	// Ham sua thong tin

	public static int suaDanhMuc(DanhMuc danhMuc) {
		int status = 0;
		try {
			Connection con = DatabaseUntil.getConnection();
			PreparedStatement ps = con
					.prepareStatement("UPDATE `danh_muc` SET `ten_danh_muc`=?,`ghi_chu`=? WHERE `ma_danh_muc`=?");
			ps.setString(1, danhMuc.getTenDanhMuc());
			ps.setString(2, danhMuc.getGhiChu());
			ps.setString(3, danhMuc.getMaDanhMuc());

			status = ps.executeUpdate();
			con.close();

		} catch (SQLException ex) {
			Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return status;
	}

//	public static void main(String[] args) {
////        for (DanhMuc dm : DanhMucDAO.layTatCaDanhMuc()) {
////            System.out.println(dm.toString());
////        }
//
////DanhMucDAO.themDanhMuc(new DanhMuc("3","Sach Trinh Tham","mota mota mota"));
////System.out.println(DanhMucDAO.xoaDanhMuc("3"));
//		System.out.println(DanhMucDAO.timDanhMuc("1").toString());
//	}
}
