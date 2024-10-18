@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
header = @`
    <a href="/">Main Page</a>
    <a href="/users">All Users Page</a>
`,
content = @`
    @for(var user : page.getUsers())
        <div>${user.getLastName() + " " + user.getFirstName()}</div>
        <span>${user.getEmail()}</span>
    @endfor
`,
footer = @`
    <p>This is a FOOTER of index.jte!</p>
`
)