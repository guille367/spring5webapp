package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain driven design", "1231231");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        this.authorRepository.save(eric);
        this.bookRepository.save(ddd);

        Author tito = new Author("Tito", "Escamoso");
        Book libraco = new Book("Segundo libraco", "54545");

        tito.getBooks().add(libraco);
        libraco.getAuthors().add(tito);

        this.authorRepository.save(tito);
        this.bookRepository.save(libraco);

        System.out.println("Bootstraping data....");
        System.out.println(this.authorRepository.count());
    }
}
