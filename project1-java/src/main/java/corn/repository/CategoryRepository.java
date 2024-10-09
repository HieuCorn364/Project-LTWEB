package corn.repository;

import java.util.List;

import corn.entity.CategoryEntity;

public interface CategoryRepository {
	List<CategoryEntity> findAll();
	CategoryEntity findById(int id);
	void insert(CategoryEntity category);
	void update(CategoryEntity category);
	void delete(int id);
	List<CategoryEntity> findByName(String keyword);
}
