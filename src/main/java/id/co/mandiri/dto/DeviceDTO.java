package id.co.mandiri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

public class DeviceDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeviceRequestNewDTO {
        @NotNull
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeviceRequestUpdateDTO {
        @NotNull
        private String id;
        @NotNull
        private String name;
    }

}
