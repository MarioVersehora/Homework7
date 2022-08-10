package com.example.Homework7.dto;

import com.example.Homework7.model.Type;
import lombok.Data;

@Data
public class ProductDTO {

    Type type;
    String name;
    Integer initialStock;

}
