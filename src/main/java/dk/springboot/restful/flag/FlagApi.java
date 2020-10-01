package dk.springboot.restful.flag;

        import lombok.RequiredArgsConstructor;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
        import java.io.IOException;
        import java.util.List;
        import java.util.Optional;

@RestController
@RequestMapping("api/v1/flag")
@CrossOrigin(origins = "*")
@Slf4j
@RequiredArgsConstructor
public class FlagApi {
    private final FlagService flagService = new FlagService();

    @GetMapping("/{countryTag}")
    public ResponseEntity<String> Get(@PathVariable String countryTag) throws IOException {
        System.out.println("request called");
        return ResponseEntity.ok(flagService.getImageSouce(countryTag));
    }

}

