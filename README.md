# Ticket selling and management web-application
> A university project for Sofware Design, UTCN

## User guide

- clone the repository
`git clone https://github.com/godraadam/tellerede.git`

- start a MySql server and create a new schema
- configure database url, username and password for database acces in
`untold\src\main\resources\application.properties`
- start the backend server:
`cd untold`
`gradle bootRun`
default port is 8080, you can configure it in `untold\src\main\resources\application.properties`

- start the frontend server
`cd untold-frontend`
`npm start`

- configure sql import on backend startup in `untold\src\main\resources\import.sql`