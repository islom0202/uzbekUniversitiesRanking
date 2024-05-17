package univerranking.uz.univerranking.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import univerranking.uz.univerranking.Entity.UniversityData;

@Setter
@Getter
@Data
@Builder
public class StatisticsRequest {
    private int totalStudents;
    private int internationalStudents;
    private int totalEmployees;
    private int numberOfBachelorStudents;
    private int numberOfMasterStudents;
    private int numberOfProfessors;
    private double academicReputation;
    private double employerReputation;
    private String location;
    private UniversityData universityData;
    private String universityPhone;
}
