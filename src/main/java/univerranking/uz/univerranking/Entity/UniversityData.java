package univerranking.uz.univerranking.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "university_data")
public class UniversityData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String city;
    private String subject;
    private int enrollment;
    private int ranking;
    @Enumerated(EnumType.STRING)
    private UniversityType type;
}
