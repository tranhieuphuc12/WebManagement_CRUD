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
public class DanhMuc {

    //field
    private String maDanhMuc;
    private String tenDanhMuc;
    private String ghiChu;

    //properties
    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    //Constructor

    public DanhMuc(String maDanhMuc, String tenDanhMuc, String ghiChu) {
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.ghiChu = ghiChu;
    }

    public DanhMuc() {
        this.maDanhMuc = "";
        this.tenDanhMuc = "";
        this.ghiChu = "";
    }
    //method
    public String toString(){
        return this.maDanhMuc+", "+this.tenDanhMuc+", "+this.ghiChu;
    }
}
