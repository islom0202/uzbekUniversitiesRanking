package univerranking.uz.univerranking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import univerranking.uz.univerranking.Entity.Statistics;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
}
