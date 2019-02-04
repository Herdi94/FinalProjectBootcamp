package id.co.mandiri.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/*create table brand_category(
        id varchar(64) not null primary key,
        name varchar(50) not null,
        kode varchar(64) not null,
        description text not null
        )*/

@Entity
@Table(name = "brand_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = "listInventory")
public class CategoryBrand {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, length = 64)
    private String id;
    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @Column(name = "code", nullable = false, length = 150)
    private String code;
    @Lob
    @Type(type = "text")
    @Column(name = "description")
    private String description;

    /*@JsonIgnore
    @OneToMany(mappedBy = "brand_category")
    private List<Inventory> listInventory = new ArrayList<>();*/
}
