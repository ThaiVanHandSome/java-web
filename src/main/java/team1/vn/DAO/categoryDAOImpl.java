package team1.vn.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import team1.vn.models.CategoryModel;

public class categoryDAOImpl implements iCategoryDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<CategoryModel> findAll() {
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
			while (rs.next()) {
				CategoryModel cate = new CategoryModel();
				cate.setCateID(rs.getInt("id"));
				cate.setCateName(rs.getString("name"));
				cate.setImage(rs.getString("image"));
				list.add(cate);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// execute data for insert
	@Override
	public void insert(CategoryModel model) {
		String sql = "INSERT INTO CATEGORY(name, image) VALUES (?,?)";
		try {
			conn = new DBConnectionSqlServer().getConnection(); // connect database

			// use query
			ps = conn.prepareStatement(sql);

			// transmit value into variables
			ps.setString(1, model.getCateName());
			ps.setString(2, model.getImage());

			// execute query
			ps.executeUpdate();

			// disconnect
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	// handle data update
	public void update(CategoryModel model) {

	}

	@Override
	public CategoryModel findOne(int id) {
		String sql = "SELECT * FROM CATEGORY WHERE CATEGORY.id = ?";
		try {
			conn = new DBConnectionSqlServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			CategoryModel model = new CategoryModel();
			while(rs.next()) {
				model.setCateID(rs.getInt(1));
				model.setCateName(rs.getString(2));
				model.setImage(rs.getString(3));
			}
			conn.close();
			return model;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
