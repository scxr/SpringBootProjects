## Simple auth service

### Endpoints

- api/v1/auth {GET} [Responds list of current user]
- api/v1/auth {POST} [Add new user] {"username":"username", "email":"email", "password":"password}
- api/v1/auth/users/\<email> {DELETE} [Delete user by email]
- api/v1/auth/users/\<email> {PUT} [Change users password] {"old_password":"old_password", "new_password":"new_password"}

### Todo

[ ] Database integration <br>
[ ]Password encryption