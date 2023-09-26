package team1.vn.services;

import java.util.List;

import team1.vn.DAO.categoryDAOImpl;
import team1.vn.DAO.iCategoryDAO;
import team1.vn.models.CategoryModel;

public class CategoryServiceImpl implements ICategoryService {
	// declare objects in DAO
	iCategoryDAO cateDAO = new categoryDAOImpl();

	@Override
	public List<CategoryModel> findAll() {
		return cateDAO.findAll();
	}

	@Override
	public void insert(CategoryModel model) {
		cateDAO.insert(model);
	}

	@Override
	// check data update
	public void update(CategoryModel model) {
		
	}

	@Override
	public CategoryModel findOne(int id) {
		return cateDAO.findOne(id);
	}
}
