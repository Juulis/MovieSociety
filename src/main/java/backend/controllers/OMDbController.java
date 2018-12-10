package backend.controllers;

import backend.entities.Movie;
import backend.entities.SearchResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OMDbController {


    public OMDbController() {
    }

    @RequestMapping("/api/movie")
    public Movie findMovieById(@RequestParam(value = "id") String id) {
        RestTemplate restTemplate = new RestTemplate();
        String call = String.format("http://www.omdbapi.com/?i=%s&apikey=a5fc9d5d", id);
        //check if call exists in db, then get data from db instead.
        return restTemplate.getForObject(call, Movie.class);
    }

    @RequestMapping("/api/movies")
    public Movie[] findMoviesByTitle(@RequestParam(value = "t") String t) {
        RestTemplate restTemplate = new RestTemplate();
        String call = String.format("http://www.omdbapi.com/?s=%s&apikey=a5fc9d5d", t);
        //check if call exists in db, then get data from db instead.
        SearchResult movies = restTemplate.getForObject(call, SearchResult.class);

        return movies.getSearchArray();
    }
}
