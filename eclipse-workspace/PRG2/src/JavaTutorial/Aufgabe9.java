package JavaTutorial;

import java.util.*;


public class Aufgabe9 {
	
	private enum Genre { HIPHOP, ROCK, EDM, POP, DNB, DUBSTEP, TRANCE, HOUSE, FOLK, JAZZ, COUNTRY, DEFAULT };
	
	public static class Collection {
		private class Album{
			String artist;
			String title = "N/A";
			Genre genre = Genre.DEFAULT;
			
			Album(String singer, String title, char genre) {
				artist = singer;
				changeA(title);
				changeG(genre);
			}
			
			public void changeA(String name) { artist = name; }
			
			public void changeG(char c) { 
				switch(c) {
					case 'h': genre = Genre.HIPHOP;	 break;
					case 'r': genre = Genre.ROCK;	 break;
					case 'e': genre = Genre.EDM;	 break;
					case 'P': genre = Genre.POP; 	 break;
					case 'd': genre = Genre.DNB; 	 break;
					case 'u': genre = Genre.DUBSTEP; break;
					case 't': genre = Genre.TRANCE;	 break;
					case 's': genre = Genre.HOUSE;	 break;	
					case 'f': genre = Genre.FOLK;	 break;
					case 'j': genre = Genre.JAZZ;	 break;
					case 'c': genre = Genre.COUNTRY; break;		
					default: try {
						throw new Exception("Falsche Eingabe!");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			public void details() {
				System.out.println("Title: " + title);
				System.out.println("Artist: " + artist);
				System.out.println("Genre: " + genre.name());
				
			}
		};
		
		private Vector<Album> collection;

		Collection() { collection = new Vector<Album>(); }
		
		void addAlbum(String artist, String name, char genre) {
			Album alb = new Album(artist, name, genre);
			collection.addElement(alb);
		}
		
		boolean searchAlb(String album) {
			for (Album a : collection) {
				if(a.title == album) {
					a.details();
					return true;
				}			
			}
			System.out.println("No match found!");
			return false;
		}
		
		boolean searchArt(String artist) {
			boolean hasAlbum = false;
			for (Album a : collection) {
				if(a.artist == artist) {
					a.details();
					if (!hasAlbum) { hasAlbum = true; }
				}
			}
			if (!hasAlbum) System.out.println("No match found!");
			return hasAlbum;
		}
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
