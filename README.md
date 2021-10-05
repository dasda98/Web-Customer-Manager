# Web-Customer-Manager

## About

Web-Customer-Manager is a simple application that uses Spring MVC and 
CRUD functionalities. The project demonstrates the use of a database, 
Spring MVC and Hibernate.

The project was implemented to educate.

## Informations

- `Java 11`
- `Spring 5.3.9`
- `Hibernate 5.5.7`
- `MySQL` database server on `docker`
- `Tomcat 9.0.43`  

## Application Schema

Project contains 2 controllers, services and DAOs.
The connection between the customer controller and the product service is caused
to receive all products at the time of creating the customer.

![](gitimages/app-schema.png "App Schema")

## Database structure

Database contains 3 tables:

- customer
- product
- customer_product

![](gitimages/tables.png "Tables")

## Sample screenshots

### Customer

#### Customer list

![](gitimages/customer-list.png)

#### Customer products

![](gitimages/customer-products.png)

#### Customer update-crate

![](gitimages/customer-update-create.png)

#### Customer search by text

![](gitimages/customer-search.png)

### Product

Product has the same functionalities as the Customer.

#### Product list

![](gitimages/product-list.png)