package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<AuthorDTO> getAll() {
        return authorRepository.findAll().stream()
                .map(authorMapper::map)
                .toList();
    }

    public AuthorDTO getById(Long id) {
        return authorRepository.findById(id)
                .map(authorMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    }

    public AuthorDTO create(AuthorCreateDTO authorData) {
        return authorMapper.map(authorRepository.save(authorMapper.map(authorData)));
    }

    public AuthorDTO update(Long id, AuthorUpdateDTO authorData) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));
        authorMapper.update(authorData, author);
        return authorMapper.map(authorRepository.save(author));
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
    // END
}
