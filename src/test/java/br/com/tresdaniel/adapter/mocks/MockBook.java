package br.com.tresdaniel.adapter.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.tresdaniel.data.models.Book;
import br.com.tresdaniel.data.vo.v1.BookVO;

public class MockBook {

	public Book mockEntity() {
		return mockEntity(0);
	}
	
	public Book mockVO() {
		return mockEntity(0);
	}
	
	public List<Book> mockEntityList(){
		List<Book> books = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			books.add(mockEntity(i));
		}
		return books;
	}
	
	public List<BookVO> mockVOList(){
		List<BookVO> books = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			books.add(mockVO(i));
		}
		return books;
	}
	
	public Book mockEntity(Integer number) {
		Book book = new Book();
		book.setAuthor("Edgar Allan Poe");
		book.setLaunchDate(new Date());
		book.setPrice(10.99);
		book.setTitle("Livro de Contos " + number);
		book.setId(number.longValue());
		return book;
	}
	
	public BookVO mockVO(Integer number) {
		BookVO book = new BookVO();
		book.setAuthor("Edgar Allan Poe");
		book.setLaunchDate(new Date());
		book.setPrice(10.99);
		book.setTitle("Livro de Contos " + number);
		book.setKey(number.longValue());
		return book;
	}
}
