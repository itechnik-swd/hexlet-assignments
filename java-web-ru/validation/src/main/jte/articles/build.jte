@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif
    <form action="/articles" method="post">
        <div class="mb-3">
            <label class="form-label">
                Название статьи
                <input type="text" class="form-control" name="title" value="${page.getTitle()}" />
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Содержимое статьи
                <textarea name="content">${page.getContent()}</textarea>
            </label>
        </div>
    </form>
`
)