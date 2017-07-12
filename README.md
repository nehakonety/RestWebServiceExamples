# RestWebServiceExamples
Basic CRUD operation via REST API

Below GET request have been tested in browser.

URI for getting all list of employee : http://localhost:8080/employee
Output : [{"id":1,"name":"Neha","salary":50000},{"id":2,"name":"Jay","salary":60000},{"id":3,"name":"Simi","salary":70000}]

URI for to get a details of a employee : http://localhost:8080/employee/1
Output : {"id":2,"name":"Jay","salary":60000}

URI for database healthcheck is : http://localhost:8081/healthcheck
Output : {"database":{"healthy":true},"deadlocks":{"healthy":true},"h2":{"healthy":true}}

To Test PUT, POST, DELETE need a REST CLIENT . I have used Postmen and all these operations works successfully.
