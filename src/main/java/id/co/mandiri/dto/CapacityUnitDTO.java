package id.co.mandiri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

public class CapacityUnitDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CapacityUnitRequestNewDTO {
        @NotNull
        private String name;
        private String description;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CapacityUnitRequestUpdateDTO {
        @NotNull
        private String id;
        @NotNull
        private String name;
        private String description;
    }

}
