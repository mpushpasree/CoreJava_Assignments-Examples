package com.cts.movie.dao;

import java.time.LocalDate;
import java.util.List;

import com.cts.movie.exception.MoviesException;
import com.cts.movie.model.Movies;

public interface IMoviesDao {
	String add(Movies movie) throws MoviesException;
	boolean delete(String mvId)throws MoviesException;
	Movies get(String id)throws MoviesException;
	Movies searchId(String mvId) throws MoviesException;
	Movies searchName(String mvName) throws MoviesException;
	Movies searchHero(String mvHero) throws MoviesException;
	Movies searchDate(LocalDate releaseDate) throws MoviesException;
	Movies searchCollection(Double collection) throws MoviesException;
	List<Movies> getAll() throws MoviesException;;
	boolean update(Movies movie) throws MoviesException;
	void persist()throws MoviesException;
	//Movies get(String id) throws MoviesException;
}
