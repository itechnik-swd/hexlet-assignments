package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::map)
                .toList();
    }

    public BookDTO getById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }

    public BookDTO create(BookCreateDTO bookData) {
        var author = authorRepository.findById(bookData.getAuthorId())
                .orElseThrow(() -> new ConstraintViolationException("Author with id " + bookData.getAuthorId() + " not found", null));
        return bookMapper.map(bookRepository.save(bookMapper.map(bookData)));
    }

    public BookDTO update(Long id, BookUpdateDTO bookData) {
        var author = authorRepository.findById(bookData.getAuthorId().get())
                .orElseThrow(() -> new ConstraintViolationException("Author with id " + bookData.getAuthorId() + " not found", null));
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        bookMapper.update(bookData, book);
        return bookMapper.map(bookRepository.save(book));
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
