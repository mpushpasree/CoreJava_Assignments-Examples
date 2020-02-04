package com.cts.movie.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cts.movie.exception.MoviesException;
import com.cts.movie.model.Movies;
import com.cts.movie.util.ConnectionProvider;


public class MovieDAOJDBCImpl implements IMoviesDao {
		ConnectionProvider conProvider;
		private Map<String, Movies> movies;

		public MovieDAOJDBCImpl() throws MoviesException {
			
			try {
				conProvider = ConnectionProvider.getInstance();
			} catch (IOException | ClassNotFoundException exp) {
				
				throw new MoviesException("Database is not reachable");
			}
		}
		public String add(Movies movie) throws MoviesException {
			String mvId = null;
			if (movie != null) {
				try (Connection con = conProvider.getConnection();
						PreparedStatement pInsert = con
								.prepareStatement(IQueryMapper.ADD_BOOK_QRY)) {

					pInsert.setString(1, movie.getMvId());
					pInsert.setString(2, movie.getMvName());
					pInsert.setString(3,movie.getMvHero());
					pInsert.setDate(4, Date.valueOf(movie.getReleaseDate()));
					pInsert.setInt(5,movie.getCollection());

					int rowCount = pInsert.executeUpdate();

					if (rowCount == 1) {
						mvId = movie.getMvId();
					}
				} catch (SQLException exp) {
					throw new MoviesException("Movie is not inserted");
				}
			}
			return mvId;
		}
		
		@Override
		public boolean delete(String mvId) throws MoviesException {
			boolean isDone = false;

			try (Connection con = conProvider.getConnection();
					PreparedStatement pDelete = con
							.prepareStatement(IQueryMapper.DEL_BOOK_QRY)) {

				pDelete.setString(1, mvId);

				int rowCount = pDelete.executeUpdate();

				if (rowCount == 1) {
					isDone = true;
				}
			} catch (SQLException exp) {
				throw new MoviesException("Movie is not deleted");
			}

			return isDone;
		}
		
		
		
		@Override
		public List<Movies> getAll() throws MoviesException {
			List<Movies> movies=null;
			try (Connection con = conProvider.getConnection();
					PreparedStatement pSelect = con
							.prepareStatement(IQueryMapper.GET_ALL_BOOKS_QRY)) {

				ResultSet rs = pSelect.executeQuery();
				
				movies = new ArrayList<Movies>();
				
				while(rs.next()){
					Movies movie = new Movies();
					movie.setMvId(rs.getString("mvId"));
					movie.setMvName(rs.getString("mvName"));
					movie.setMvHero(rs.getString("mvHero"));
					movie.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
					movie.setCollection(rs.getInt("collection"));
					movies.add(movie);
				}
				
			} catch (SQLException exp) {
				throw new MoviesException("No Movies are available.");
			}		
			return movies;	
		}
		
		@Override
		public boolean update(Movies movie) throws MoviesException {
			boolean isDone = false;
			if (movie != null) {
				try (Connection con = conProvider.getConnection();
						PreparedStatement pUpdate = con
								.prepareStatement(IQueryMapper.MODIFY_BOOK_QRY)) {

					
					pUpdate.setString(1, movie.getMvName());
					pUpdate.setString(2, movie.getMvHero());
					pUpdate.setDate(3, Date.valueOf(movie.getReleaseDate()));
					pUpdate.setInt(4, movie.getCollection());
					pUpdate.setString(5, movie.getMvId());
					

					int rowCount = pUpdate.executeUpdate();

					if (rowCount == 1) {
						isDone = true;
					}
				} catch (SQLException exp) {
					throw new MoviesException("Movie is not updated.");
				}
			}
			return isDone;
		}
		
		@Override
		public void persist() throws MoviesException {
			/* no implementation required */
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
		public Movies get(String id) throws MoviesException {
			// TODO Auto-generated method stub
			return null;
		}
	}


