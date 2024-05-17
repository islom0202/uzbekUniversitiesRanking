package univerranking.uz.univerranking.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import univerranking.uz.univerranking.Model.StatisticsRequest;
import univerranking.uz.univerranking.Service.StatisticsService;
import univerranking.uz.univerranking.Service.UniversityService;

import java.rmi.AlreadyBoundException;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;
    private final UniversityService universityService;

    public StatisticsController(StatisticsService statisticsService, UniversityService universityService) {
        this.statisticsService = statisticsService;
        this.universityService = universityService;
    }

    @GetMapping("/university/{universityId}")
    public ResponseEntity<?> getUniversityStatistics(@PathVariable("universityId") Long universityId) {
        return ResponseEntity.ok(statisticsService.getStatistics(universityId));
    }

    @PostMapping("/add/statistic")
    public ResponseEntity<?> addStatistics(@RequestBody StatisticsRequest statistics) {
        if (universityService.existsById(statistics.getUniversityData().getId())) {
            statisticsService.save(statistics);
            return ResponseEntity.ok("statistic added");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
    }
}
