# Java Coding Challenge

## Introduction
Given is a Spring Boot application that implements a REST service for manipulating ads and customers. This application is already runnable, but does not do anything useful, yet. Your task is to make it more useful. The scenario of this application is a very simplified version of mobile.de's domain - we have customers, and these customers want to list ads on our platform.

It is very likely that you will not be able to finish all subtasks in the given time frame. You are basically free to choose which subtasks you work on, but keep in mind that some of the subtasks depend on others. They are listed here in no particular order. Some of the subtasks will have a bigger impact on the overall assessment than others.

You have one week to finish this challenge.

## Tasks
1. The classes in this artifact are all in one package called `de.mobile`. Create a proper package structure and move the classes to where they belong.
2. Make the domain objects `MobileAd` and `MobileCustomer` persist, either on a local `mysqld` or a local `mongodb`.
3. Currently the application only handles read use cases for ads. Extend the application so that ads can also be created.
4. There is a `MobileCustomer` class in the artifact. Extend the application so that it is also possible to create and delete customers.
5. Make sure that the ad related usecases become customer-aware (meaning that an ad needs a customer in every case).
6. Add validation to the calls that create new entities. The following rules should apply:
   - An ad needs a customer id, a make name, a model name and a category.
   - A customer needs a formally valid email address, a firstname and a lastname composed of alphanumeric characters.
7. Configure logging properly so that log messages are logged to a file.
8. Implement a proper error handling for 404 and 500, with different error messages. Please describe how to reproduce both error statuses.
9. Change the project so that it builds an executable jar.
10. Create a simple HTML/Javascript application that talks to the above REST service. It should be able to list all ads. Making it look pretty would be a plus.
11. If the ad data and the customer data were not accessible from the database but from other RESTful services, what approach would you use to integrate these services? 
12. If you decide not to write tests for your work for reasons of timeboxing, please spend a few minutes to describe what parts of the application you would write tests for, and what aspects these tests would cover, and what role they play in the development process.

Good Luck!


//Feedback

So i think that i have managed all the points for this Coding Challenge.

Some info :

I have used H2 Memory DB so there is no need to configure the application with some local DB.
You can check db on --> http://localhost:8080/h2




1- To start using the application you can import it as maven project or run the .jar file.After running it 
   it is better to create some car ads first, you can use this request paylod on postman on port http://localhost:8080/ad/create

{
    "make": "BMW"
    "model": "M2",
    "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
    "price": 20000,
        "customer": {
        "companyName": "Car GBmH",
        "email": "cardealer@gmail.com",
        "firstName": "Eraldo",
        "lastName" : "Harizi"
    }
}


2 -After there is some list of ads on DB,  I have build a simple UI displaying the list running at : http://localhost:8080/ad/welcome

3 - After that you can test other crud operation for ads and customers seperately.

Regarding the point 11 , 12

11- Each microservice has its own instance and process. Therefore, services must 
interact using an inter-service communication protocols like HTTP, gRPC or message brokers AMQP protocol
That depends on your choice, weather you want sync communication or async communication between your services.
For Async you can use messaging solutions like:
ActiveMQ
RabitMQ
Kafka
For sync services you can 3rd party tools:
Netflix Eureka

12- Regarding Test , i have test some endpoints for demostration but its not fully completed.
When it comes to testing there are several different types of tests 
that you can write to help test and automate the health of your application


1- A unit test covers a single “unit”, where a unit commonly is a single class
2- Integration test covers multiple layers. This is actually a specialization of the first case 
and might cover the interaction between a business service and the persistence layer, for instance.

In simple terms, test cases for each functionality are created and tested first and if the test fails 
then the new code is written in order to pass the test and making code simple and bug-free.
The simple concept of Test Development Driven is to write and correct the failed tests before writing new code (before development). 
This helps to avoid duplication of code





