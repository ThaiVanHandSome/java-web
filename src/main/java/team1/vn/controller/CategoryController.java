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

import team1.vn.models.CategoryModel;

@WebServlet(urlPatterns = { "/category/listcate" })
public class CategoryController extends HttpServlet {
	public static final long serialVersionUID = 1L;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		findAll(req, resp);
	}

	// hiển thị tất cả dữ liệu của category
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// tạo các biến
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM CATEGORY";
				
		try {
			// kết nối database
			conn = new DBConnectionSqlServer().getConnection();
			ps = conn.prepareStatement(sql);
			
			// lấy kết quả ra resultset
			rs = ps.executeQuery();
					
			// đọc resultset đưa vào model
			while(rs.next()) {
				CategoryModel cate = new CategoryModel();
				cate.setCateID(rs.getInt("id"));
				cate.setCateName(rs.getString("name"));
				cate.setImage(rs.getString("image"));
				list.add(cate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// đẩy dữ liệu ra view
		req.setAttribute("listcate", list);
		// view sẽ lấy dữ liệu
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/listcategory.jsp");
		rd.forward(req, resp);
	}
}
