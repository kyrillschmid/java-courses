package solid_exercise_01_starter_kit;

public class Book {
	private String id;
	private String title;
	private String author;
    private BookGenre genre;

    public Book(String id, String title, String author, BookGenre genre) {
    	this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public void printBookInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Genre: " + genre);
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", genre=" + genre + "]";
    }
    
    public String getTitle() {
		return title;
	}
    
    public String getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}
}