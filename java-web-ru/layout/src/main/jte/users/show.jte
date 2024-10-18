@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
header = @`
    <a href="/">Main Page</a>
    <a href="/users">All Users Page</a>
`,
content = @`
    <p>Welcome, ${page.getUser().getLastName() + " " + page.getUser().getFirstName()}.</p>
`,
footer = @`
    <p>This is a FOOTER of show.jte!</p>
`
)