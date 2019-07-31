package com.leito.ratingsdata.service.resources;

import com.leito.ratingsdata.service.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RaitingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 4);
    }

}
