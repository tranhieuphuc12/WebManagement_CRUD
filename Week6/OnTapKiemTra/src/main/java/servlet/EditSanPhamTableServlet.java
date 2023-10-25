package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.SanPham;
import dao.DanhMucDAO;
import dao.SanPhamDAO;

/**
 * Servlet implementation class EditSanPhamTableServlet
 */
@WebServlet("/EditSanPhamTableServlet")
public class EditSanPhamTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSanPhamTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSanPham = request.getParameter("ma_san_pham");
		String tenSanPham = request.getParameter("ten_san_pham");
		int gia = Integer.parseInt(request.getParameter("gia"));
		String moTa = request.getParameter("mo_ta");
		String maDanhMuc = request.getParameter("ma_danh_muc");
	
		SanPham sanPham = new SanPham(maSanPham, tenSanPham, gia, moTa, maDanhMuc);
		SanPhamDAO.suaSanPham(sanPham);
		request.setAttribute("listSanPham", SanPhamDAO.layTatCaSanPham());
		RequestDispatcher rd = request.getRequestDispatcher("QuanLySanPham.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
