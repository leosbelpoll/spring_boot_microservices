package com.leito.moviecatalogservice.resources;

import com.leito.moviecatalogservice.models.CatalogItem;
import com.leito.moviecatalogservice.models.Movie;
import com.leito.moviecatalogservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogs")
public class MovieCatalogResource {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        RestTemplate restTemplate = new RestTemplate();

        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 3),
                new Rating("5678", 5)
        );

        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8086/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "desc 1", rating.getRating());
        }).collect(Collectors.toList());
    }

}
