package gov.iti.jets.model.dtos;

import gov.iti.jets.model.entities.Country;
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
public class CityDto {

    private Short cityId;
    private String city;
    private Timestamp lastUpdate;
}
