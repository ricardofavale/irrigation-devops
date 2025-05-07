package com.smartcity.irrigation.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "zones")
public class Zone {
    @Id
    private String id;

    @NotBlank(message = "O nome da zona é obrigatório")
    private String name;

    @NotBlank(message = "O tipo da zona é obrigatório")
    private String type;

    private String location;
    private int humidityThreshold;
    private boolean active;
}




