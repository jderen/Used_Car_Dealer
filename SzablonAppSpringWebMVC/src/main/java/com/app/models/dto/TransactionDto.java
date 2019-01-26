package com.app.models.dto;


import com.app.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    private Long id;
    private Double price;
    private LocalDate transactionDate;
    private Long employeeId;
    private Long carId;
    private Long clientId;
}

