/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Administrator
 */
public class SanPham {
    //field
    private String tenSanPham;
    private String maSanPham;
    private int gia;
    private String moTa;
    private String maDanhMuc;
    
    //getter && setter

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }
    
    //Constructor

    public SanPham(String maSanPham,String tenSanPham, int gia, String moTa, String maDanhMuc) {
        this.tenSanPham = tenSanPham;
        this.maSanPham = maSanPham;
        this.gia = gia;
        this.moTa = moTa;
        this.maDanhMuc = maDanhMuc;
    }
    public SanPham() {
        this.tenSanPham = "";
        this.maSanPham = "";
        this.gia = 0;
        this.moTa = "";
        this.maDanhMuc = "";
    }
    
    //Method
    public String toString(){
        return this.maSanPham+", "+this.tenSanPham+", "+this.gia+", "+this.moTa+", "+this.maDanhMuc;
    }
}
