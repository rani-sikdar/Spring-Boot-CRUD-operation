package com.example.demo.repo;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Book;

import java.lang.*;

public interface BookRepository extends JpaRepository<Book, Long>{

	
	public static final BookRepository repo = null;
     
    public List<Book> listAll() {
        return repo.findAll();
    }
     
    public void save(Book book) {
        repo.save(book);
    }
     
    public Book get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
	

}
