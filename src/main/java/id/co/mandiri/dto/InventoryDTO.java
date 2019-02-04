package id.co.mandiri.dto;

import id.co.mandiri.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

public class InventoryDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InventoryRequestNewDTO {
        /*@NotNull
        private Device id_device;
        @NotNull
        private CategoryDevice id_device_category;
        @NotNull
        private DeviceCondition id_device_condition;
        @NotNull
        private CapacityUnit id_capacity_unit;
        @NotNull
        private CategoryBrand id_brand_category;
        @NotNull
        private CategoryColor id_color;
        @NotNull
        private LoanStatus id_loan;*/

        @NotNull
        private String id_device;
        @NotNull
        private String id_device_category;
        @NotNull
        private String id_device_condition;
        @NotNull
        private String id_capacity_unit;
        @NotNull
        private String id_brand_category;
        @NotNull
        private String id_color;
        @NotNull
        private String id_loan;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InventoryRequestUpdateDTO {
        /*@NotNull
        private String id;
        @NotNull
        private Device id_device;
        @NotNull
        private CategoryDevice id_device_category;
        @NotNull
        private DeviceCondition id_device_condition;
        @NotNull
        private CapacityUnit id_capacity_unit;
        @NotNull
        private CategoryBrand id_brand_category;
        @NotNull
        private CategoryColor id_color;
        @NotNull
        private LoanStatus id_loan;*/

        @NotNull
        private String id;
        @NotNull
        private String id_device;
        @NotNull
        private String id_device_category;
        @NotNull
        private String id_device_condition;
        @NotNull
        private String id_capacity_unit;
        @NotNull
        private String id_brand_category;
        @NotNull
        private String id_color;
        @NotNull
        private String id_loan;

    }

}
