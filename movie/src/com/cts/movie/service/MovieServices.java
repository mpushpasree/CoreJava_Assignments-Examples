package com.cts.movie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cts.movie.dao.IMoviesDao;
import com.cts.movie.dao.MovieDAOJDBCImpl;
import com.cts.movie.dao.MoviesDaoIOStreamImpl;
import com.cts.movie.exception.MoviesException;
import com.cts.movie.model.Movies;
public class MovieServices implements IMoviesServices {
	private IMoviesDao movieDao;

	public IMoviesDao getDAO(){
		return movieDao;
	}
	
	public MovieServices() throws MoviesException {
		// bookDao = new BookDAOCollectionImpl();
		//movieDao = new MoviesDaoIOStreamImpl();
		movieDao= new MovieDAOJDBCImpl();
		
	}
	
	public boolean isValidMvId(String mvId){
		
		/*
		 * First letter must be capital
		 * Followed by three digits
		 */
		Pattern mvIdPattern = Pattern.compile("[A-Z]\\d{3}");
		Matcher mvidMatcher = mvIdPattern.matcher(mvId);
		
		return mvidMatcher.matches();
	}
	
	public boolean isValidTitle(String mvName){
		
		
		/*
		 * First Letter should be capital
		 * Minimum length is 4 chars
		 * Maximum length is 20 chars.		
		 */
		Pattern titlePattern = Pattern.compile("[A-Z]\\w{3,19}");
		Matcher titleMatcher = titlePattern.matcher(mvName);
		
		return titleMatcher.matches();
	}
	
	public boolean isValidHero(String mvHero){
		/*
		 * First Letter should be capital
		 * Minimum length is 4 chars
		 * Maximum length is 20 chars.		
		 */
		Pattern HeroPattern = Pattern.compile("[A-Z]\\w{3,19}");
		Matcher HeroMatcher = HeroPattern.matcher(mvHero);
		
		return HeroMatcher.matches();
	}
	
	public boolean isValidPrice(double collection){
		/*
		 * collection is between 5000 and 500000
		 */
		return collection>=5 && collection<=5000;
	}
	
	public boolean isValidReleaseDate(LocalDate releaseDate){
		/*
		 * publish date should not be greater than the current day.
		 */
		LocalDate today = LocalDate.now();
		//return publishDate.isBefore(today) || publishDate.equals(today);
		return today.isAfter(releaseDate) || releaseDate.equals(today);
	}
	
	public boolean isValidMovie(Movies movie) throws MoviesException{
		boolean isValid=false;
		
		List<String> errMsgs = new ArrayList<>();
		
		
		if(!isValidMvId(movie.getMvId())) {
			errMsgs.add("MovieId should start with a capital alphabet followed by 3 digits");
		}
		
		if(!isValidTitle(movie.getMvName()))
			errMsgs.add("Movie must start with capital and must be in between 4 to 20 chars in length");
		
		if(!isValidHero(movie.getMvHero()))
			errMsgs.add("MovieHero name should start with a capital alphabet followed by 3 digits");
		
		if(!isValidPrice(movie.getCollection()))
			errMsgs.add("Collection must be between INR.5 and INR.5000");
		
		if(!isValidReleaseDate(movie.getReleaseDate()))
			errMsgs.add("Release Date should not be a future date");
		
		if(errMsgs.size()==0)
			isValid=true;
		else
			throw new MoviesException(errMsgs.toString());
		
		return isValid;
	}


	@Override
	public String add(Movies movie) throws MoviesException {
		String mvId=null;
		if(movie!=null && isValidMovie(movie)){
			mvId=movieDao.add(movie);
		}
		return mvId;
	}

	@Override
	public boolean delete(String mvId) throws MoviesException {
		boolean isDone=false;
		if(mvId!=null && isValidMvId(mvId)){
			movieDao.delete(mvId);
			isDone = true;
		}else{
			throw new MoviesException("mvId should be a capital letter followed by 3 digits");
		}
		return isDone;
	}

	@Override
	public Movies searchMvId(String mvId) throws MoviesException {
		return movieDao.searchId(mvId);
	}
	
	@Override
	public Movies searchMvName(String mvName) throws MoviesException {
		return movieDao.searchName(mvName);
	}
	
	@Override
	public Movies searchMvHero(String mvHero) throws MoviesException {
		return movieDao.searchHero(mvHero);
	}
	
	@Override
	public Movies searchRDate(LocalDate releaseDate) throws MoviesException {
		return movieDao.searchDate(releaseDate);
	}
	
	@Override
	public Movies searchCollection(Double collection) throws MoviesException {
		return movieDao.searchCollection(collection);
	}

	@Override
	public List<Movies> getAll() throws MoviesException {
		return movieDao.getAll();
	}

	@Override
	public boolean update(Movies movie) throws MoviesException {
		boolean isDone = false;
		
		if(movie!=null && isValidMovie(movie)){
			isDone = movieDao.update(movie);
		}
		
		return isDone;
	}


	@Override
	public void persist() throws MoviesException {
		movieDao.persist();
	}
}

