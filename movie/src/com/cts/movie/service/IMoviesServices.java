package com.cts.movie.service;

import java.time.LocalDate;
import java.util.List;

import com.cts.movie.exception.MoviesException;
import com.cts.movie.model.Movies;

public interface IMoviesServices {
	String add(Movies movie) throws MoviesException;
	boolean delete(String mvId) throws MoviesException;
	Movies searchMvId(String mvId) throws MoviesException;
	Movies searchMvName(String mvName) throws MoviesException;
	Movies searchMvHero(String mvHero) throws MoviesException;
	Movies searchRDate(LocalDate releaseDate) throws MoviesException;
	Movies searchCollection(Double collection) throws MoviesException;
	List<Movies> getAll() throws MoviesException;;
	boolean update(Movies movie) throws MoviesException;
	void persist()throws MoviesException;
}
