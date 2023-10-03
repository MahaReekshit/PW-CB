package com.rest.rates.entities;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rate {

    Integer id;
    String type;
    Double rateValue;
}
