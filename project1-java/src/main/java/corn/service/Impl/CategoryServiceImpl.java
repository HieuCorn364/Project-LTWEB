package corn.service.Impl;

import java.util.List;

import corn.entity.CategoryEntity;
import corn.repository.CategoryRepository;
import corn.repository.Impl.CategoryRepositoryImpl;
import corn.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	public CategoryRepository categoryRepository = new CategoryRepositoryImpl();
	@Override
	public List<CategoryEntity> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public CategoryEntity findById(int id) {
		return categoryRepository.findById(id);
	}

	@Override
	public void insert(CategoryEntity category) {
		categoryRepository.insert(category);
	}

	@Override
	public void update(CategoryEntity category) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity = categoryRepository.findById(category.getCategoryId());
		if(categoryEntity != null) {
			categoryRepository.update(categoryEntity);
		}
	}

	@Override
	public void delete(int id) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity = categoryRepository.findById(id);
		if(categoryEntity != null) {
			categoryRepository.delete(id);
		}
	}

	@Override
	public List<CategoryEntity> findByName(String keyword) {
		return categoryRepository.findByName(keyword);
	}

}
