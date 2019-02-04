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

@Entity
@Table(name = "loan_status")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = "listInventory")
public class LoanStatus {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, length = 64)
    private String id;
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    /*@JsonIgnore
    @OneToMany(mappedBy = "loan_status")
    private List<Inventory> listInventory = new ArrayList<>();*/
}
