package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.DanhMuc;
import dao.DanhMucDAO;

/**
 * Servlet implementation class EditTableServlet
 */
@WebServlet("/EditTableServlet")
public class EditTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditTableServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String idFromEditTableJSP = request.getParameter("id");
		
		String maDanhMuc = request.getParameter("ma_danh_muc");
		String tenDanhMuc = request.getParameter("ten_danh_muc");
		String ghiChu = request.getParameter("ghi_chu");
//		
//
		DanhMuc danhMuc = new DanhMuc(maDanhMuc, tenDanhMuc, ghiChu);
		DanhMucDAO.suaDanhMuc(danhMuc);
		
//
////		request.setAttribute("danhMuc", danhMuc);
//		request.setAttribute("danhMuc", danhMuc);
		request.setAttribute("listDanhMuc", DanhMucDAO.layTatCaDanhMuc());
		RequestDispatcher rd = request.getRequestDispatcher("QuanLyDanhMuc.jsp");
		rd.forward(request, response);
//		response.sendRedirect("QuanLyDanhMuc.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
