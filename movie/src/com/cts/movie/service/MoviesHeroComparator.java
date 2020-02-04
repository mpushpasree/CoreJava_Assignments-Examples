package com.cts.movie.service;

import java.util.Comparator;

import com.cts.movie.model.Movies;

public class MoviesHeroComparator implements Comparator<Movies> 
{ 
    @Override
	public int compare(Movies a, Movies b) 
    { 
        return a.getMvHero().compareTo(b.getMvHero());
    } 

}
