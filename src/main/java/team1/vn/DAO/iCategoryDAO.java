package team1.vn.DAO;

import java.util.List;

import team1.vn.models.CategoryModel;

public interface iCategoryDAO {
	List<CategoryModel> findAll();
	void insert(CategoryModel model);
	void update(CategoryModel model);
	void delete(int id);
	CategoryModel findOne(int id);
}
