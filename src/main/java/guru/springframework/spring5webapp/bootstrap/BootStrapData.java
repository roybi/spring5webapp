package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.BookRepository;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData( AuthorRepository authorRepository, BookRepository bookRepository ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run( String... args ) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book ddd= new Book("Domain Driven Design","123123123");

        eric.getBooks().add(ddd);

        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod =new Author("Rod","Jonshon");
        Book noEJB= new Book("old J2EE","344343");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        System.out.printf("Started in bootStrap");
        System.out.printf("Number of books: "+bookRepository.count());
    }




}
