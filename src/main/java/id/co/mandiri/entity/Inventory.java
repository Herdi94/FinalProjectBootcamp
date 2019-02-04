package id.co.mandiri.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, length = 64)
    private String id;

/*
    public Inventory(String id) {
        this.id = id;
    }

    public Inventory() {
    }

    @ManyToOne
    @JoinColumn(name = "id_device", nullable = false)
    private Device device;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
*/


/* @ManyToOne
    @JoinColumn(name = "id_device_category", nullable = false)
    private CategoryDevice id_device_category;

    @ManyToOne
    @JoinColumn(name = "id_device_condition", nullable = false)
    private DeviceCondition id_device_condition;

    @ManyToOne
    @JoinColumn(name = "id_capacity_unit", nullable = false)
    private CapacityUnit id_capacity_unit;

    @ManyToOne
    @JoinColumn(name = "id_brand_category", nullable = false)
    private CategoryBrand id_brand_category;

    @ManyToOne
    @JoinColumn(name = "id_color", nullable = false)
    private CategoryColor id_color;

    @ManyToOne
    @JoinColumn(name = "id_loan", nullable = false)
    private LoanStatus id_loan;*/

}
