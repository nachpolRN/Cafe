//Nachpol Ruangnam 6410406568
package ku.cs.cafe.service;

import ku.cs.cafe.entity.Category;
import ku.cs.cafe.model.CategoryRequest;
import ku.cs.cafe.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public void createCategory(CategoryRequest category) {
        Category record = modelMapper.map(category, Category.class);
        categoryRepository.save(record);
    }
}
