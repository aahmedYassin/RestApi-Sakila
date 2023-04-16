package gov.iti.jets.model.dtos;

import gov.iti.jets.model.entities.Address;
import gov.iti.jets.model.entities.Staff;
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
public class StoreDto {
    private short storeId;
    private AddressDto address;
    private Timestamp lastUpdate;
}
