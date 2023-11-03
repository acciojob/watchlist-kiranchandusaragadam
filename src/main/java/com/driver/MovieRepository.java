package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    private HashMap<String, Movie> moviesMap;
    private HashMap<String, Director> directorsMap;
    private HashMap<String, List<String>> directorVsMovies;

    public MovieRepository() {
        this.moviesMap = new HashMap<>();
        this.directorsMap = new HashMap<>();
        this.directorVsMovies = new HashMap<>();
    }

    public void addMovie(Movie movie){
        String name = movie.getName();
        if(!moviesMap.containsKey(name)) {
            moviesMap.put(name, movie);
        }
    }

    public void addDirector(Director director){
        String name = director.getName();
        if(!directorsMap.containsKey(name)){
            directorsMap.put(name, director);
        }
    }

    public void addMovieDirectorPair(String mName, String dName){
        if(moviesMap.containsKey(mName) && directorsMap.containsKey(dName)){
            if(!directorVsMovies.containsKey(dName)){
                directorVsMovies.put(dName, new ArrayList<>());
            }

            if(!directorVsMovies.get(dName).contains(mName)) {
                directorVsMovies.get(dName).add(mName);
            }
            // now update director his number of movies
            directorsMap.get(dName).setNumberOfMovies(directorVsMovies.get(dName).size());
        }
    }

    public Movie getMovieByName(String name){
        if(moviesMap.containsKey(name)){
            return moviesMap.get(name);
        }
        return null;
    }

    public Director getDirectorByName(String name){
        if(directorsMap.containsKey(name)){
            return directorsMap.get(name);
        }
        return null;
    }

    public List<String> getMoviesByDirectorName(String name){
        if(directorVsMovies.containsKey(name)){
            return directorVsMovies.get(name);
        }
        return null;
    }

    public List<String> findAllMovies(){
        if(moviesMap.size() > 0){
            List<String> allMovies = new ArrayList<>(moviesMap.keySet());
            return allMovies;
        }
        return null;
    }

    public void helper(String name){
        if(directorVsMovies.containsKey(name)){
            List<String> hisMovies = directorVsMovies.get(name);
            directorVsMovies.remove(name);

            for(String m: hisMovies){
                moviesMap.remove(m);
            }
        }
    }
    public void deleteDirectorByName(String name){
        if(directorsMap.containsKey(name)){
            directorsMap.remove(name);
        }

        // for feasibility to delete all directors method
        helper(name);
    }

    public void deleteAllDirectors(){
        for(String d: directorsMap.keySet()){
            helper(d);
        }
        // now delete all these directors from this directors map
        directorsMap.clear();
    }

}
