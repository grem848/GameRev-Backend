## Spring-Boot-integrations



### start app by running 
docker-compose up

## docker toolbox
92.168.99.100:8082 phpadmin <br>
92.168.99.100:8080 webapp <br>
92.168.99.100:3306 mysql <br>


## docker-desktop
localhost:8082 phpadmin <br>
localhost:8080 webapp <br>
localhost:3306 mysql <br>


## Restfull api docs 

GET 8080/api/v1/users <br>
returns a list of users

GET 8080/api/v1/users/id <br>
return a user with that id

POST 8080/api/v1/users <br>
create a user 

PUT 8080/api/v1/users/id <br>
update a user if exist, if not make an user

DELETE 8080/api/v1/users/id <br>
deletes a user
<br>


a user
```json
{
    "id": 1,
    "userName": "test",
    "createdAt": null,
    "updatedAt": null,
    "email": "test"
}
```



