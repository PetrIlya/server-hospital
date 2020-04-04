# Help
### What is it ?
It's me attempt to make restful server. It'll work as a part of the [FXHospital](https://github.com/PetrIlya/FXHospital)
### How to run it ?
For local running with Heroku you should provide `.env` file with variables, you can see in the `application.properties` file.\
`SPRING_DATABASE_URL`\
`SPRING_DATASOURCE_PASSWORD`\
`SPRING_DATASOURCE_USERNAME`\
`PORT`\
Use command `heroku local web`\
Don't forget to provide postgres extension
### How to deploy it ?
Make sure you've created heroku application for this project and provided 
`SPRING_DATABASE_URL`
`SPRING_DATASOURCE_PASSWORD`
`SPRING_DATASOURCE_USERNAME`
`PORT` variables and please, don't forget to provide postgres extension
