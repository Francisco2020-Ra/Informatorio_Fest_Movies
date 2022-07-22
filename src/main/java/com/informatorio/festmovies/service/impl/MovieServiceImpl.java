package com.informatorio.festmovies.service.impl;

import com.informatorio.festmovies.dto.MovieDTO;
import com.informatorio.festmovies.entities.MovieEntity;
import com.informatorio.festmovies.exception.ResourceNotFoundException;
import com.informatorio.festmovies.mapper.MovieMapper;
import com.informatorio.festmovies.repository.MovieRepository;
import com.informatorio.festmovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieMapper movieMapper, MovieRepository movieRepository){
        this.movieMapper = movieMapper;
        this.movieRepository = movieRepository;
    }
    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) throws ResourceNotFoundException {
        MovieEntity movieEntity = movieMapper.toEntity(movieDTO);
        movieRepository.findById(movieDTO.getCategory().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Not found category id: " + movieDTO.getCategory().getId()));
        MovieEntity movieEntity1 = movieRepository.save(movieEntity);
        return movieMapper.toDTO(movieEntity1);
    }

    @Override
    public List<MovieDTO> getAllMovies() throws ResourceNotFoundException {
        List<MovieEntity> listMovie = movieRepository.findAll();
        if(listMovie.size() == 0){
            throw new ResourceNotFoundException("List Empty");
        }
        return movieMapper.toListMovieDTO(listMovie);
    }
}
