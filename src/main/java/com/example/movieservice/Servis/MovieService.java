package com.example.movieservice.Servis;

import com.example.movieservice.Model.Movie;
import com.example.movieservice.Repository.MovieRepository;
import com.example.movieservice.exception.MovieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie findById(Long id){
        return movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);
    }
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie save(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public void changeIsA(Long id){
        Movie target = findById(id);
        target.setAvailable(!target.getAvailable());
        movieRepository.save(target);
    }
}
