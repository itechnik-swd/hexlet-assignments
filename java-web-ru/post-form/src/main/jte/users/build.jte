<form action="/users" method="post">
    <div>
        <label>
            firstName
            <input type="text" name="firstName" />
        </label>
    </div>
    <div>
        <label>
            lastName
            <input type="text" name="lastName" />
        </label>
    </div>
    <div>
        <label>
            Email
            <input type="email" required name="email" />
        </label>
    </div>
    <div>
        <label>
            Password
            <input type="password" required name="password" />
        </label>
    </div>
    <input type="submit" value="Зарегистрировать" />
</form>