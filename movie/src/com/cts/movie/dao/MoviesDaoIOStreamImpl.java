package com.cts.movie.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.movie.exception.MoviesException;
import com.cts.movie.model.Movies;

public class MoviesDaoIOStreamImpl implements IMoviesDao {
	public static final String DATA_STORE_FILE_NAME = "movies.dat";

	private Map<String, Movies> movies;

	@SuppressWarnings("unchecked")
	public MoviesDaoIOStreamImpl() throws MoviesException {
		File file = new File(DATA_STORE_FILE_NAME);

		if (!file.exists()) {
			movies = new TreeMap<>();
		} else {
			try (ObjectInputStream fin = new ObjectInputStream(
					new FileInputStream(DATA_STORE_FILE_NAME))) {

				Object obj = fin.readObject();

				if (obj instanceof Map) {
					movies = (Map<String, Movies>) obj;
				} else {
					throw new MoviesException("Not a valid DataStore");
				}
			} catch (IOException | ClassNotFoundException exp) {
				throw new MoviesException("Loading Data Failed");
			}
		}
	}
	@Override
	public String add(Movies movie) throws MoviesException {
		String mvId = null;
		if (movie != null) {
			mvId = movie.getMvId();
			movies.put(mvId, movie);
		}
		return mvId;
	}

	@Override
	public boolean delete(String mvId) throws MoviesException {
		boolean isDone = false;
		if (mvId != null) {
			movies.remove(mvId);
			isDone = true;
		}
		return isDone;
	}

	@Override
	public Movies searchId(String mvId) throws MoviesException {
		return movies.get(mvId);
	}

	@Override
	public Movies searchName(String mvName) throws MoviesException {
		return movies.get(mvName);
	}

	@Override
	public Movies searchHero(String mvHero) throws MoviesException {
		return movies.get(mvHero);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Movies searchDate(LocalDate releaseDate) throws MoviesException {
		return movies.get(releaseDate);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Movies searchCollection(Double collection) throws MoviesException {
		return movies.get(collection);
	}

	@Override
	public List<Movies> getAll() throws MoviesException {
		return new ArrayList<Movies>(movies.values());
	}

	@Override
	public boolean update(Movies movie) throws MoviesException {
		boolean isDone = false;
		if (movie != null) {
			String mvId = movie.getMvId();
			movies.replace(mvId, movie);
		}
		return isDone;
	}

	@Override
	public void persist() throws MoviesException {
		try (ObjectOutputStream fout = new ObjectOutputStream(
				new FileOutputStream(DATA_STORE_FILE_NAME))) {
			fout.writeObject(movies);
		} catch (IOException exp) {
			throw new MoviesException("Saving Data Failed");
		}
	}
	@Override
	public Movies get(String id) throws MoviesException {
		// TODO Auto-generated method stub
		return null;
	}

}
