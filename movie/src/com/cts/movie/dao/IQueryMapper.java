package com.cts.movie.dao;

public interface IQueryMapper {

	public static final String ADD_BOOK_QRY = 
			"INSERT INTO movies(mvId,  mvName, mvHero, releaseDate,collection) VALUES(?,?,?,?,?)";
	public static final String MODIFY_BOOK_QRY = 
			"UPDATE movies SET mvName=?,mvHero=?,collection=? WHERE mvId=?";
	public static final String DEL_BOOK_QRY = 
			"DELETE FROM movies WHERE mvId=?";
	public static final String GET_ALL_BOOKS_QRY = 
			"SELECT * FROM movies";
	public static final String GET_BOOK_QRY = 
			"SELECT * FROM movies WHERE mvId=?";
}