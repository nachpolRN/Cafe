//Nachpol Ruangnam 6410406568
package ku.cs.cafe.service;

import ku.cs.cafe.entity.Category;
import ku.cs.cafe.entity.Menu;
import ku.cs.cafe.model.MenuRequest;
import ku.cs.cafe.repository.MenuRepository;
import ku.cs.cafe.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service

public class MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getOneById(UUID id) {
        return menuRepository.findById(id).get();
    }

    public void createMenu(MenuRequest menu) {
        Menu record = modelMapper.map(menu, Menu.class);
        Category category =
                categoryRepository.findById(menu.getCategoryId()).get();
        record.setCategory(category);
        menuRepository.save(record);
    }

}
