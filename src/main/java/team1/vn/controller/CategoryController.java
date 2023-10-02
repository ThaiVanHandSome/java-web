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

@WebServlet(urlPatterns = { "/category/listcate", "/category/insert", "/findOne", "/category/update", "/category/delete" })
public class CategoryController extends HttpServlet {
	public static final long serialVersionUID = 1L;

	// declare object service
	ICategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();

		if (url.contains("insert")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/category/addcategory.jsp");
			rd.forward(req, resp);
		} else if (url.contains("listcate")) {
			try {
				findAll(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url.contains("findOne")) {
			try {
				findOne(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url.contains("update")) {
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryModel model = categoryService.findOne(id);
			req.setAttribute("cate", model);
			RequestDispatcher rd = req.getRequestDispatcher("/views/category/updatecategory.jsp");
			rd.forward(req, resp);
		} else if (url.contains("delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				categoryService.delete(id);
				req.setAttribute("message", "Delete successful!");			
				RequestDispatcher rd = req.getRequestDispatcher("listcate");
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("error", "Fail!");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();

		// handle insert data
		if (url.contains("insert")) {
			insert(req, resp);
		} else if (url.contains("findOne")) {

		} else if (url.contains("update")) {
			update(req, resp);
		}
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
		// encode UTF-8
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// recieve data from Form
		int id = Integer.parseInt(req.getParameter("cateID"));
		String name = req.getParameter("cateName");
		String image = req.getParameter("image");

		// declare model and add data into model
		CategoryModel model = new CategoryModel();
		model.setCateID(id);
		model.setCateName(name);
		model.setImage(image);

		// call method update
		categoryService.update(model);

		// change page (transfer page)
		resp.sendRedirect("listcate");

	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// encode UTF-8
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// recieve data from Form
		String name = req.getParameter("cateName");
		String image = req.getParameter("image");

		// declare model and add data into model
		CategoryModel model = new CategoryModel();
		model.setCateName(name);
		model.setImage(image);

		// call method insert
		categoryService.insert(model);

		// change page (transfer page)
		resp.sendRedirect("listcate");
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

	private void findOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("cateID"));
		CategoryModel model = categoryService.findOne(id);
		req.setAttribute("cate", model);
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/updatecategory.jsp");
		rd.forward(req, resp);
	}
}
