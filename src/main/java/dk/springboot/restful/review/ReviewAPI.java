package dk.springboot.restful.review;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/reviews")
@Slf4j
@RequiredArgsConstructor

public class ReviewAPI {
    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> findAll(){
        return ResponseEntity.ok(reviewService.findAll());
    }

    @PostMapping ResponseEntity create(@Valid @RequestBody Review review){
        return ResponseEntity.ok(reviewService.save(review));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> findById(@PathVariable Long id){
        Optional<Review> review = reviewService.findById(id);
        if(!review.isPresent()){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(review.get());
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<Review> findByGameId(@PathVariable Long id){
        Optional<Review> review = reviewService.findByGameID(id);
        if(!review.isPresent()){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(review.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> update(@PathVariable Long id, @Valid @RequestBody Review review){
        if(!reviewService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(reviewService.save(review));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        if(!reviewService.findById(id).isPresent()){
            ResponseEntity.notFound().build();
        }
        reviewService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
