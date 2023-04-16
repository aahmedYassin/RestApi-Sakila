package gov.iti.jets.model.dtos;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CountryDto {
    
    private Short countryId;
    private String country;
    private Timestamp lastUpdate;
}
