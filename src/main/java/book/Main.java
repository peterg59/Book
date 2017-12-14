package book;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import book.repository.*;


public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		BookDAO bookDao = context.getBean(BookDAO.class);
		Book book = new Book(5, "Lion", "Pierre", 150);
		Book book2 = new Book(11, "Rat", "Pierre", 140);
		Book book3 = new Book(12, "Aigle", "Pierre", 130);
		Book book4 = new Book(13, "Renard", "Pierre", 180);
		Book book5 = new Book(14, "Renard", "Pierre", 180);
		Book book6 = new Book(15, "Renard", "Pierre", 180);
		List<Book> books;
		
		
		
		bookDao.delete(book5);
		
		books = bookDao.getAll();
		for(Book b : books) {
			System.out.println(b);
		}
		/*bookDao.delete(book5);
		books = bookDao.getAll();
		for(Book b : books) {
			System.out.println(b);
		}*/
	}
}
