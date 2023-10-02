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
		// Is data changed?
		CategoryModel newModel = cateDAO.findOne(model.getCateID());
		newModel.setCateID(model.getCateID());
		newModel.setCateName(model.getCateName());
		newModel.setImage(model.getImage());
		
		
		cateDAO.update(newModel);
	}

	@Override
	public CategoryModel findOne(int id) {
		return cateDAO.findOne(id);
	}

	@Override
	public void delete(int id) {
		cateDAO.delete(id);
	}
}
