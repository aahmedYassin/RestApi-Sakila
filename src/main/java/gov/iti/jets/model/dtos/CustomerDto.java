package gov.iti.jets.model.dtos;

import gov.iti.jets.model.entities.Address;
import gov.iti.jets.model.entities.Store;
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
public class CustomerDto {
    private Short customerId;
    private AddressDto address;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private Timestamp createDate;
    private Timestamp lastUpdate;
}
