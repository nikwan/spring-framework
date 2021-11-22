package niks.poc.spring.demo.patterns.builder;

public class Book {

	private final String isbn;
	private final String title;
	private String description;

	public Book(BookBuilder builder) {
		this.title = builder.title;
		this.isbn = builder.isbn;
		this.description = builder.description;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public static class BookBuilder{
		private final String isbn;
		private final String title;
		private String description;
		
		public BookBuilder(String isbn, String title) {
			this.isbn = isbn;
			this.title = title;
		}
		
		public String isbn() {
			return isbn;
		}
		public String title() {
			return title;
		}

		public BookBuilder description(String description) {
			this.description = description;
			return this;
		}
		
		public Book build() {
			return new Book(this);
		}
	}

	public static void main(String[] args) {
		Book.BookBuilder bookBuilder = new Book.BookBuilder("ISBVN122", "Java The Complete Reference")
		.description("Its a Java Universe");
		
		Book b1 = bookBuilder.build();
		
		System.out.println(b1);
		
		
		///re-usability limitations
		Book b2 = bookBuilder.description("comes with java 8 power!").build();
		
		System.out.println(b2);
		
		
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", description=" + description + "]";
	}
	
}
