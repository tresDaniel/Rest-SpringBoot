package br.com.tresdaniel.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tresdaniel.data.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
