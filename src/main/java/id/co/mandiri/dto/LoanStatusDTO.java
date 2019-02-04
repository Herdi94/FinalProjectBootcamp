package id.co.mandiri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

public class LoanStatusDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoanStatusRequestNewDTO {
        @NotNull
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoanStatusRequestUpdateDTO {
        @NotNull
        private String id;
        @NotNull
        private String name;
    }

}
