package com.kitten.kittenws.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class KittenError implements Serializable {
    private final String url;
    private final String statusCode;
    private final String message;
}
