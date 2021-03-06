package com.informatorio.festmovies.service;

import com.informatorio.festmovies.dto.MovieDTO;
import com.informatorio.festmovies.exception.ResourceNotFoundException;

import java.util.List;

public interface MovieService {

    MovieDTO addMovie(MovieDTO movieDTO) throws ResourceNotFoundException;

    List<MovieDTO> getAllMovies() throws ResourceNotFoundException;

    MovieDTO updateMovie(Long id, MovieDTO movieDTO) throws ResourceNotFoundException;

    void deleteMovieId(Long id) throws ResourceNotFoundException;

    MovieDTO addCharacterToMovie(Long id, List<Long> characterId) throws ResourceNotFoundException;
}
