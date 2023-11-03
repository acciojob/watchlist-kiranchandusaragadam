package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {
//    @Autowired
    MovieRepository movieRepository = new MovieRepository();

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String mName, String dName){
        movieRepository.addMovieDirectorPair(mName, dName);
    }

    public Movie getMovieByName(String name){
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name){
        return movieRepository.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String name){
        return movieRepository.getMoviesByDirectorName(name);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String name){
        movieRepository.deleteDirectorByName(name);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}
