package br.com.tresdaniel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresdaniel.adapter.DozerAdapter;
import br.com.tresdaniel.data.models.Book;
import br.com.tresdaniel.data.vo.v1.BookVO;
import br.com.tresdaniel.exception.ResourceNotFoundException;
import br.com.tresdaniel.request.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repository;
	
	public BookVO create(BookVO book) {
		var entity = DozerAdapter.parseObject(book, Book.class);
		return DozerAdapter.parseObject(repository.save(entity), BookVO.class);
	}

	public List<BookVO> findAll() {
		return DozerAdapter.parseListObject(repository.findAll(), BookVO.class);
	}
	
	public BookVO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerAdapter.parseObject(entity, BookVO.class);
		
	}
	
	public BookVO update(BookVO book) {
		var entity = repository.findById(book.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		return DozerAdapter.parseObject(repository.save(entity), BookVO.class);
	}
	
	public void delete(Long id) {
		Book entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
}
