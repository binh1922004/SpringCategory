package hcmute.com.SpringCRUD.repository;

import hcmute.com.SpringCRUD.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

        List<Category> findByCategoryname(String name);

        Page<Category> findByCategorynameContaining(String name, Pageable pageable);
}
