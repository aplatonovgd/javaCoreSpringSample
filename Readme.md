# JavaCore final project (Spring Sample)
## Description
Simple REST API shop service created with Spring Framework.
Created as additional task for my java core course.

Property of https://griddynamics.com

## Requirements
- MySQL server
- Maven

### Supported Rest methods

#### Shop operations
1. **/showShopItems  - get all products (GET)**
2. **/showCartItems - display your cart (GET)**
3. **/addItemToCart - add item to the cart(POST)** Example request:
```
{"id":3, "quantity":1}
id - product id
quantity - product quantity
```
4. **/removeItemFromCart - remove item from the cart(POST)** Example request:
```
{"id":1}
id - id of the item in the cart
```
5. **/checkoutCart - checkout cart (GET)**
6. **/addItemToShop - add item to shop**
```
{
    "title": "Grey Polo",
    "price": 13.33,
    "quantity": 23
}
title - product title
price - product price
quantity - product quantity
```

#### Application.properties params
1. spring.jpa.hibernate.ddl-auto=create 
2. spring.datasource.url=jdbc:mysql://localhost:3306/springSampleAP
3. spring.datasource.username=root
4. spring.datasource.password=123456

#### Installation and deployment guide

1. Make sure that you have Maven, Tomcat and MySql installed.
2. Create database 
3. Set up correct properties in Application.properties file

#### Troubleshooting

- Note! Only MySql is supported.
- If the application doesn't start, make sure that you correctly specified all the settings

#### How to test
For acceptance testing I recommend using Postman. There is a settings file with all requests - 'javaCore.postman_collection.json'.

1. Start Postman
2. Import file "SpringSample.postman_collection.json" from the root project's folder.
