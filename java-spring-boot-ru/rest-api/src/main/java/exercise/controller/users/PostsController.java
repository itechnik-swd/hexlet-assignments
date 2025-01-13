package exercise.controller.users;

import exercise.Data;
import exercise.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


import java.util.List;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public List<Post> index(@PathVariable String id) {
        return posts.stream()
                .filter(p -> String.valueOf(p.getUserId()).equals(id))
                .toList();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> create(@PathVariable String id, @RequestBody Post post) {
        post.setUserId(Integer.parseInt(id));
        posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
}
// END
