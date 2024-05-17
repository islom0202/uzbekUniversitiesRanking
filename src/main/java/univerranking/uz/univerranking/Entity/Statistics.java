package univerranking.uz.univerranking.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "statistics")
public class Statistics implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int totalStudents;
    private int internationalStudents;
    private int totalEmployees;
    private int numberOfBachelorStudents;
    private int numberOfMasterStudents;
    private int numberOfProfessors;
    private double academicReputation;
    private double employerReputation;
    private String location;
    @OneToOne(optional = false)
    private UniversityData universityData;
    @Column(unique = true)
    private String universityPhone;
}
