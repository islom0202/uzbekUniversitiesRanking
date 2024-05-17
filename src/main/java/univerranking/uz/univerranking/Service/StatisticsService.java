package univerranking.uz.univerranking.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import univerranking.uz.univerranking.Entity.Statistics;
import univerranking.uz.univerranking.Entity.UniversityData;
import univerranking.uz.univerranking.Exception.UniversityNotFoundException;
import univerranking.uz.univerranking.Model.StatisticsRequest;
import univerranking.uz.univerranking.Repository.StatisticsRepository;
import univerranking.uz.univerranking.Repository.UniversityRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;
    private final UniversityRepository universityRepository;

    public Optional<Statistics> getStatistics(Long universityId) throws UniversityNotFoundException {
        Optional<UniversityData> universityData = universityRepository
                .findById(universityId);
        if (universityData.isPresent()) {
            return statisticsRepository.findById(universityId);
        } else
            throw new UniversityNotFoundException("not found the university!");
    }

    public void save(StatisticsRequest statistics) {
        Statistics statisticsEntity = new Statistics();
        UniversityData universityData = universityRepository
                .findById(statistics.getUniversityData().getId()).get();

        statisticsEntity.setId(universityData.getId());
        statisticsEntity.setLocation(statistics.getLocation());
        statisticsEntity.setEmployerReputation(statistics.getEmployerReputation());
        statisticsEntity.setAcademicReputation(statistics.getAcademicReputation());
        statisticsEntity.setInternationalStudents(statistics.getInternationalStudents());
        statisticsEntity.setNumberOfBachelorStudents(statistics.getNumberOfBachelorStudents());
        statisticsEntity.setTotalStudents(statistics.getTotalStudents());
        statisticsEntity.setNumberOfMasterStudents(statistics.getNumberOfMasterStudents());
        statisticsEntity.setNumberOfProfessors(statistics.getNumberOfProfessors());
        statisticsEntity.setUniversityPhone(statistics.getUniversityPhone());
        statisticsEntity.setTotalEmployees(statistics.getTotalEmployees());
            statisticsEntity.setUniversityData(universityData);

        statisticsRepository.save(statisticsEntity);
    }
}
