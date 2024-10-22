@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Список постов</h1>
            <table class="table table-striped">
                @for(var post : page.getPosts())
                    <tr>
                        <td>
                            <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                        </td>
                        <td>
                            ${post.getBody()}
                        </td>
                    </tr>
                @endfor
            </table>
        </main>
    </div>
    <span>
        @if(page.getCurrentPageNumber() > 1)
            <a href="${NamedRoutes.postsPath()}?page=${page.getCurrentPageNumber() - 1}">Previous page</a>
        @endif
    </span>
    <span>
        @if(page.getCurrentPageNumber() < 7)
            <a href="${NamedRoutes.postsPath()}?page=${page.getCurrentPageNumber() + 1}">Next page</a>
        @endif
    </span>
`
)