# intellect

This application consists of following packages:

com.intellect.design
  -UserApplication.java --> SpringBootApplication
com.intellect.design.bean
  -User.java --> Pojo class for User
com.intellect.design.controller
  -UserController.java --> RestController of the app
com.intellect.design.service
  -UserService.java --> contains business logic
  -Response.java --> Response class pojo
  -Error.java --> Error class
  
 This application can be accessed via http:<url>:<port>/UserApp/users
 There are 3 methods:
  POST: creates new user
  PUT: Updates existing user
  DELETE: Deletes user
  
  
 HashMap is used to hold all users. Key is the id of the User whereas User object is the value for the hashmap
 
 resources folder contains application.properties where server can be configured
 As of now server.port=8081
