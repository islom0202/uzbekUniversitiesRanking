package univerranking.uz.univerranking.Model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import univerranking.uz.univerranking.Entity.UniversityType;

@Getter
@Setter
@Data
@Builder
public class UniversityDataDTO {

    private String name;
    private String city;
    private String subject;
    private int enrollment;
    private int ranking;
    @Enumerated(EnumType.STRING)
    private UniversityType type;
}
