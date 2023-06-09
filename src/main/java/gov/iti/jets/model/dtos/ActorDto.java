package gov.iti.jets.model.dtos;

import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Timestamp;
import java.util.List;
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
public class ActorDto {
    
    private Short actorId;
    private String firstName;
    private String lastName;
    private Timestamp lastUpdate;
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)  // HATEOAS
    private List<Link> links;
}
