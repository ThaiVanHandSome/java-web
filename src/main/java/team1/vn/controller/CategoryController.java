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
import team1.vn.services.CategoryServiceImpl;
import team1.vn.services.ICategoryService;

@WebServlet(urlPatterns = { "/category/listcate" })
public class CategoryController extends HttpServlet {
	public static final long serialVersionUID = 1L;
	
	// declare object service
	ICategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		findAll(req, resp);
	}

	// display all data of category
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> categoryList = categoryService.findAll();
		
		// push data to view
		req.setAttribute("listcate", categoryList);
		
		// view will get data
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/listcategory.jsp");
		rd.forward(req, resp);
	}
}
