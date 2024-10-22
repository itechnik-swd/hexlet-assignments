@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <div>
        <p>${page.getPost().getId()}</p>
        <p>${page.getPost().getName()}</p>
        <p>${page.getPost().getBody()}</p>
    </div>
    <div>
        <a href="${NamedRoutes.postsPath()}">Вернуться в список всех постов</a>
    </div>
`
)