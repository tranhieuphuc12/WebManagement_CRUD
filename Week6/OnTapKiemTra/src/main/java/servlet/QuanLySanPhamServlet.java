package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.DanhMuc;
import core.SanPham;
import dao.DanhMucDAO;
import dao.SanPhamDAO;

/**
 * Servlet implementation class QuanLySanPhamServlet
 */
@WebServlet("/QuanLySanPhamServlet")
public class QuanLySanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLySanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<DanhMuc> listDanhMuc = DanhMucDAO.layTatCaDanhMuc();
		ArrayList<SanPham> listSanPham = SanPhamDAO.layTatCaSanPham();
		
		request.setAttribute("listSanPham", listSanPham);
        request.setAttribute("listDanhMuc", listDanhMuc);
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
