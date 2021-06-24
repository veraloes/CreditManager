# CreditManager

Credit Manager is an app, which gives ability to manage Credits.

### Specification
- Java: 11
- Database: H2
- Build automation tool: Apache Maven
- Spring Boot starter version: 2.4.5
- UI framework: Thymeleaf

### Data Model
![Persistence](https://user-images.githubusercontent.com/48919716/116630460-74aff380-a953-11eb-88c4-3c556ab29a08.png)
### Storage Layer
There are three Repositories to handle the main entities: Credit, Customer and Product. These Repositories are based on Spring JPA framework and what is basic for Spring JPA, these Repositories contains minimal code. Some of initial data is hard coded inside Application Class.
### Structure
![structure](https://user-images.githubusercontent.com/48919716/116634593-ce68eb80-a95c-11eb-86aa-e6d4a4461d8c.png)
## Spring application architecture
Credit Manager is created with typical architecture of a Spring application.
![img.png](https://www.programmersought.com/images/45/c362377c7839fb163acf0e8fc6ae7705.png)
```python
default server.port=8090
default homepage adress: http://localhost:8090/home
```
## Controller 
Controller consists of GET and POST requests to handle REST APIs, both from web browser and tool for rest api testing (Postman).
### UI interface
Interface is created from template framework - Thymeleaf. 
Main interfaces are: Home Page, Create Credit Page and Get Credits Page. On pages are implemented "Back" buttons to help with navigation.

Home page:
```python
@GetMapping(value = "/home")
```
![home](https://user-images.githubusercontent.com/48919716/116630510-914c2b80-a953-11eb-999f-9b6272940640.png)

```python
@GetMapping(value = "/createCredit")
```
Thymeleaf form collects data needed to create Credit.

![create](https://user-images.githubusercontent.com/48919716/116630504-8d200e00-a953-11eb-844d-ffd02a1ffc77.png)

### Additional feature
Web form has validation to inserted values, every cell has to have lenght bigger than 0 and @NoNull, pesel number has to have 11 characters.

```python
@GetMapping(value = {"/getList"})
```
Thymeleaf view shows table witch created Credits
![get](https://user-images.githubusercontent.com/48919716/116630507-8f826800-a953-11eb-8038-74584cefe4ec.png)

### Postman
It's possible to manage data or test from Postman or other similar tool, example requests:
```python
@PostMapping("/create/credit")
@GetMapping("/get/credits")
@PostMapping("/create/customer")
@GetMapping("/get/customers")
@PostMapping("/create/product")
@GetMapping("/get/products")
```


