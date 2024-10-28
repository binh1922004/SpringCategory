package hcmute.com.SpringCRUD.service;

import hcmute.com.SpringCRUD.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface ICategoryService {
        List<Category> findAll();

        <S extends Category> S save(S entity);

        Optional<Category> findById(Long aLong);

        long count();

        void deleteById(Long aLong);

        List<Category> findAll(Sort sort);

        Optional<Category> findCategoriesByCategoryname(String categoryname);
}
