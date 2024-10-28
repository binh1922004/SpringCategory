package hcmute.com.SpringCRUD.service.imp;

import hcmute.com.SpringCRUD.entity.Category;
import hcmute.com.SpringCRUD.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryService implements hcmute.com.SpringCRUD.service.ICategoryService {
        CategoryRepository categoryRepository;


        @Override
        public List<Category> findAll() {
                return categoryRepository.findAll();
        }

        @Override
        public <S extends Category> S save(S entity) {
                return categoryRepository.save(entity);
        }

        @Override
        public Optional<Category> findById(Long aLong) {
                return categoryRepository.findById(aLong);
        }

        @Override
        public long count() {
                return categoryRepository.count();
        }

        @Override
        public void deleteById(Long aLong) {
                categoryRepository.deleteById(aLong);
        }

        @Override
        public List<Category> findAll(Sort sort) {
                return categoryRepository.findAll(sort);
        }

        @Override
        public Optional<Category> findCategoriesByCategoryname(String categoryname) {
                return categoryRepository.findCategoriesByCategoryname(categoryname);
        }


}
