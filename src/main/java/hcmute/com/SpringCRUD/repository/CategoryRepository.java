package hcmute.com.SpringCRUD.repository;

import hcmute.com.SpringCRUD.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
        Optional<Category> findCategoriesByCategoryname(String categoryname);

        @Query("SELECT c FROM Category c WHERE c.categoryname LIKE %:keyword%")
        Page<Category> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
