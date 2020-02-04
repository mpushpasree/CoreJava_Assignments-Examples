package com.cts.movie.ui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.cts.movie.exception.MoviesException;
import com.cts.movie.model.Movies;
import com.cts.movie.model.MoviesAppMenu;
import com.cts.movie.service.IMoviesServices;
import com.cts.movie.service.MovieServices;
import com.cts.movie.service.MoviesHeroComparator;
import com.cts.movie.service.MoviesReleaseComparator;
import com.cts.movie.service.MoviesTitleComparator;
import com.cts.movie.service.MoviesTitleComparator;

public class MoviesManagement{
	private static IMoviesServices movieService;
	private static Scanner scan;
	private static DateTimeFormatter dtFormater;
	public static void main(String[] args) {

		try {
			movieService = new MovieServices();
		} catch (MoviesException e) {
			e.printStackTrace();
		}


		scan = new Scanner(System.in);
		dtFormater = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		MoviesAppMenu menu = null;

		while (menu != MoviesAppMenu.QUIT) {

			System.out.println("Choice\tMenu Item");
			System.out.println("===========================");
			for (MoviesAppMenu m : MoviesAppMenu.values()) {
				System.out.println(m.ordinal() + "\t" + m.name());
			}
			System.out.print("Choice: ");
			int choice = -1;
			if (scan.hasNextInt())
				choice = scan.nextInt();
			else {
				scan.next();
				System.out.println("Pleae choose a choice displayed");
				continue;
			}

			if (choice < 0 || choice >= MoviesAppMenu.values().length) {
				System.out.println("Invalid Choice");
			} else {
				menu = MoviesAppMenu.values()[choice];
				switch (menu) {
				case ADD:
					doAdd();
					break;
				case LIST:
					doList();
					break;
				case SEARCH:
					doSearch();
					break;
				case HERO_WISE:
					doHero();
					break;
				case DATE_WISE:
					doDate();
					break;
				case COLLECTION_WISE:
					doCollection();
					break;
				case TITLE_WISE:
					doTitle();
					break;
				case REMOVE:
					doRemove();
					break;
				case QUIT:
					System.out.println("ThanQ Come Again!");
					break;
				}
			}

		}

		scan.close();
		try {
			movieService.persist();
		} catch (MoviesException e) {
			e.printStackTrace();
		}

	}

	private static void doAdd() {
		try {
			Movies movie = new Movies();
			System.out.print("Movie Id: ");
			movie.setMvId(scan.next());
			System.out.print("Movie Name: ");
			movie.setMvName(scan.next());
			System.out.print("Movie Hero: ");
			movie.setMvHero(scan.next());
			System.out.print("Release Date(dd-MM-yyyy): ");
			String pubDtStr = scan.next();

			try {
				movie.setReleaseDate(LocalDate.parse(pubDtStr, dtFormater));
			} catch (DateTimeException exp) {
				throw new MoviesException(
						"Date must be in the format day(dd)-month(MM)-year(yyyy)");
			}
			System.out.print("Collection of Movie: ");
			if (scan.hasNextInt())
				movie.setCollection(scan.nextInt());
			else {
				scan.next();
				throw new MoviesException("Collection is a number");
			}

			String mvId =movieService.add(movie);
			System.out.println("Movie is Added with Id: " + mvId);
		} catch (MoviesException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doList() {
		List<Movies> movies;
		try {
			movies = movieService.getAll();
			if (movies.size() == 0) {
				System.out.println("No Moviess To display");
			} else {
				for (Movies m : movies)
					System.out.println(m);
			}
		} catch (MoviesException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doSearch() {
		System.out.print("Movie Id: ");
		String mvId = scan.next();

		try {
			Movies movie = movieService.searchMvId(mvId);
			if (movie != null) {
				System.out.println(movie);
			} else {
				System.out.println("No Such Movie");
			}
		} catch (MoviesException exp) {
			System.out.println(exp.getMessage());
		}
	}
	
	private static void doHero() {
		List<Movies> movies;
		try {
			movies = movieService.getAll();
			if(movies.size()==0) {
				System.out.println("No movies to display");
			}else {
					Collections.sort(movies, new MoviesHeroComparator());
					for(Movies m : movies) {
						System.out.println(m);
					}
					System.out.println("------------------------------------------------------------------------------------------------------------");
			}
		}catch (MoviesException exp) {
			System.out.println(exp.getMessage());
		}
	}
	
	private static void doDate() {
		List<Movies> movies;
		try {
			movies = movieService.getAll();
			if(movies.size()==0) {
				System.out.println("No movies to display");
			}else {
				Collections.sort(movies, new MoviesReleaseComparator());
				for(Movies movie : movies) {
					System.out.println(movie);
				}
				System.out.println("------------------------------------------------------------------------------------------------------------");
			}
		}catch (MoviesException exp) {
			System.out.println(exp.getMessage());
		}
	}
	private static void doTitle() {
		List<Movies> movies;
		try {
			movies = movieService.getAll();
			if(movies.size()==0) {
				System.out.println("No movies to display");
			}else {
					Collections.sort( movies,new MoviesTitleComparator());
					System.out.println("Movie list sorted according to their Titles:");
					for(Movies m: movies)
						System.out.println(m);
					System.out.println("------------------------------------------------------------------------------------------------------------");
			}
		}catch (MoviesException exp) {
			System.out.println(exp.getMessage());
		}
	}
	
	private static void doCollection() {
		List<Movies> movies;
		try {
			movies = movieService.getAll();
			if(movies.size()==0) {
				System.out.println("No movies to display");
			}else {
		Collections.sort(movies, new MoviesReleaseComparator());
		for(Movies movie : movies) {
			System.out.println(movie);
			}
		System.out.println("------------------------------------------------------------------------------------------------------------");
	}
		}catch (MoviesException exp) {
			System.out.println(exp.getMessage());
	}
	}
	private static void doRemove() {
		System.out.print("Movie Id: ");
		String mvId = scan.next();
		try {
			boolean isDone = movieService.delete(mvId);
			if (isDone) {
				System.out.println("Movie is Deleted");
			} else {
				System.out.println("No Such Movie");
			}
		} catch (MoviesException exp) {
			System.out.println(exp.getMessage());
		}
	}
}
