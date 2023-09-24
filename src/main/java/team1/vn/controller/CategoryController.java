package team1.vn.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team1.vn.DAO.DBConnectionSqlServer;
import team1.vn.DAO.categoryDAOImpl;
import team1.vn.DAO.iCategoryDAO;
import team1.vn.models.CategoryModel;

@WebServlet(urlPatterns = { "/category/listcate" })
public class CategoryController extends HttpServlet {
	public static final long serialVersionUID = 1L;
	iCategoryDAO categoryDAO = new categoryDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		findAll(req, resp);
	}

	// hiển thị tất cả dữ liệu của category
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> categoryList = categoryDAO.findAll();
		// đẩy dữ liệu ra view
		req.setAttribute("listcate", categoryList);
		// view sẽ lấy dữ liệu
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/listcategory.jsp");
		rd.forward(req, resp);
	}
}
