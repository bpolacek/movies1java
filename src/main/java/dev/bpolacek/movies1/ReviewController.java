package dev.bpolacek.movies1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService service;

    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.OK);
    }
    // Adding the GET method here
    @GetMapping()
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = service.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
