package univerranking.uz.univerranking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import univerranking.uz.univerranking.Entity.UniversityData;
import univerranking.uz.univerranking.Entity.UniversityType;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<UniversityData, Long> {
    List<UniversityData> findAllByNameContainingAndCityContainingAndSubjectContainingAndTypeContaining(
            String name, String city, String subject, UniversityType type);
    boolean existsByName(String name);
}
