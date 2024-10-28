package hcmute.com.SpringCRUD.repository;

import hcmute.com.SpringCRUD.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
        Optional<Category> findCategoriesByCategoryname(String categoryname);
}
