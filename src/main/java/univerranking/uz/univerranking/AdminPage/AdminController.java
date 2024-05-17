package univerranking.uz.univerranking.AdminPage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import univerranking.uz.univerranking.Model.UniversityDataDTO;
import univerranking.uz.univerranking.Service.UniversityService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UniversityService universityService;

    public AdminController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("/add/university")
    public ResponseEntity<String> addUniversity(@RequestBody UniversityDataDTO universityDataDTO) {
        if (universityService.checkUniversity(universityDataDTO.getName())) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("already reported");
        }
        universityService.save(universityDataDTO);
        return ResponseEntity.ok("saved");
    }


}
