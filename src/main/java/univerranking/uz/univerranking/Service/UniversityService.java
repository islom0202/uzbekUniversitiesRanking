package univerranking.uz.univerranking.Service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import univerranking.uz.univerranking.Entity.UniversityData;
import univerranking.uz.univerranking.Entity.UniversityType;
import univerranking.uz.univerranking.Model.UniversityDataDTO;
import univerranking.uz.univerranking.Repository.UniversityRepository;
import univerranking.uz.univerranking.Repository.UniversitySearchDao;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversityService {
    private final UniversityRepository universityRepository;
    private final UniversitySearchDao universitySearchDao;

    public Page<UniversityData> findAll(Pageable pageable) {
        return universityRepository.findAll(pageable);
    }

    public List<UniversityData> findByFilter(
            String name,
            String subject,
            UniversityType type,
            String city) {
        return universityRepository.findAllByNameContainingAndCityContainingAndSubjectContainingAndTypeContaining(
                name, city, subject, type);
    }

    public boolean checkUniversity(String name) {
        return universityRepository.existsByName(name);
    }

    public void save(UniversityDataDTO universityDataDTO) {
        UniversityData universityData = new UniversityData();
        universityData.setName(universityDataDTO.getName());
        universityData.setCity(universityDataDTO.getCity());
        universityData.setSubject(universityDataDTO.getSubject());
        universityData.setType(universityDataDTO.getType());
        universityData.setEnrollment(universityDataDTO.getEnrollment());
        universityData.setRanking(universityDataDTO.getRanking());
        universityRepository.save(universityData);
    }

    public List<UniversityData> findAllBySimpleQuery(String name, String subject, UniversityType type, String city) {
        return universitySearchDao.findAllBySimpleQuery(name, city, subject, type);
    }
    public Boolean existsById(Long id) {
        return universityRepository.existsById(id);
    }
}
