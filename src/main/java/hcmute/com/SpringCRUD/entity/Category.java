package hcmute.com.SpringCRUD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Categories")
public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(name = "category_name", length = 200, columnDefinition = "nvarchar(200) not null")
        private String categoryname;
        @Column(name = "category_img", length = 200, columnDefinition = "nvarchar(500)")
        private String image;

}

