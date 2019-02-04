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
@Table(name = "device_condition")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = "listInventory")
public class DeviceCondition {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, length = 64)
    private String id;
    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @Lob
    @Type(type = "text")
    @Column(name = "description")
    private String description;

    /*@JsonIgnore
    @OneToMany(mappedBy = "device_condition")
    private List<Inventory> listInventory = new ArrayList<>();*/
}
