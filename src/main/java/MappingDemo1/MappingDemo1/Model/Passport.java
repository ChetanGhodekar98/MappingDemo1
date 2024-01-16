package MappingDemo1.MappingDemo1.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passport")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "passportIdGenerator")
    @SequenceGenerator(name = "passportIdGenerator",initialValue = 50000,allocationSize = 100)
    @Column(name = "passport_id")
    private int passportId;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "passport_country")
    private String passportCountry;


}
