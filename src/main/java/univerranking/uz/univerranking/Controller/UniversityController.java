package univerranking.uz.univerranking.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import univerranking.uz.univerranking.Entity.UniversityData;
import univerranking.uz.univerranking.Entity.UniversityType;
import univerranking.uz.univerranking.Service.UniversityService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/univer-list")
    public ResponseEntity<Page<UniversityData>> universityList(Pageable pageable) {
        return ResponseEntity.ok(universityService.findAll(pageable));
    }
    @GetMapping("/filter/univer")
    public ResponseEntity<List<UniversityData>> universityListFilter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String subject,
            @RequestParam(required = false) UniversityType type,
            @RequestParam(required = false) String city ) {
        return ResponseEntity.ok(universityService.findAllBySimpleQuery(name, subject, type, city));
    }

}
