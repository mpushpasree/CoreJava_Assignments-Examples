package com.cts.movie.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.movie.exception.MoviesException;
import com.cts.movie.model.Movies;

public class MovieDaoCollectionsImpl implements IMoviesDao {
	
	private Map<String, Movies> movies;
	public MovieDaoCollectionsImpl() {
		movies =new TreeMap<>();
	}
	
	
	@Override
	public String add(Movies movie) throws MoviesException {
		String id = null;
		if (movie != null) {
			id = movie.getMvId();
			movies.put(id, movie);	
		}
		return id;
	}

	@Override
	public boolean delete(String id) throws MoviesException {
		boolean isDone = false;
		if (id != null) {
			movies.remove(id);
			isDone = true;
		}
		return isDone;
	}

	@Override
	public Movies get(String id) throws MoviesException {

		return movies.get(id);
	}

	@Override
	public List<Movies> getAll() throws MoviesException {
		return new ArrayList<>(movies.values());
	}

	@Override
	public void persist() throws MoviesException {
		// TODO Auto-generated method stub

	}


	@Override
	public Movies searchId(String mvId) throws MoviesException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Movies searchName(String mvName) throws MoviesException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Movies searchHero(String mvHero) throws MoviesException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Movies searchDate(LocalDate releaseDate) throws MoviesException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Movies searchCollection(Double collection) throws MoviesException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean update(Movies movie) throws MoviesException {
		// TODO Auto-generated method stub
		return false;
	}

}
