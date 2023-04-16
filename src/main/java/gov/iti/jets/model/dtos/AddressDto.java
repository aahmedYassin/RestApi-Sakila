package gov.iti.jets.model.dtos;

import gov.iti.jets.model.entities.City;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDto {
    private Short addressId;
    private CityDto city;
    private String address;
    private String address2;
    private String district;
    private String postalCode;
    private String phone;
    private byte[] location;
    private Timestamp lastUpdate;
}
