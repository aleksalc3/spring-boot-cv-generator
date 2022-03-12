##Spring Boot CV Generator

### Endpoints

#### Sign-Up

POST /api/authentication/sign-up HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 73

{
"name" :"user",
"username": "user",
"password":"user"
}

#### Sign-In

POST /api/authentication/sign-in HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 52

{
"username": "user",
"password":"user"
}

#### Make-Admin

PUT /api/internal/make-admin/admin HTTP/1.1
Host: localhost:8080
Authorization: Bearer InternalApiKey1234!