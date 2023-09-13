package org.unibl.etf.ip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
