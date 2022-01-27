# talking-rest
Let us explore and learn to talk REST and REST APIs

REST is a form of comunication and a software architecture, it is stateless and how the various components of the internet talk to each other.
It is a set of architectural constraints and not a protocol or a standard.

### Prologue: HTTP

The HyperText Transfer Protocol, no need explain anything here we have mdn below.

##### Further Reading
 - https://developer.mozilla.org/en-US/docs/Web/HTTP

### Prologue: Parts of a URL

![Parts of a URL](https://github.com/StillSomehowSane/talking-rest/blob/main/image/urldiag.PNG)

##### Further Reading
 - https://www.geeksforgeeks.org/components-of-a-url/
 - https://blog.hubspot.com/marketing/parts-url
 - https://www.baeldung.com/spring-requestmapping

### Part-1: The various HTTP Request Methods
- GET
- HEAD
- POST
- PUT
- DELETE
- CONNECT
- OPTIONS
- TRACE
- PATCH

But we mainly care about only GET, POST, PUT and sometimes DELETE

##### Further Reading
 - https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods

### Part-2: The HTTP Request Headers
These are additional information about the reuqest/response, are non case-sensitive key value strings separated by a :

Example:
``` HTTP
Content-Type: application/json
Content-Length: 3815
```

##### Further Reading
 - https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers


### Part-3: The HTTP Status Codes
Most common of these are
 - 200 OK
 - 201 Created
 - 400 Bad Request
 - 401 Unatuorised
 - 403 Forbidden
 - 404 Not Found
 - 405 Method Not Allowed
 - 500 Internal Server Error

Example in Spring
``` java
   HttpStatus.OK // 200 OK.
```

But there are a ton more!

##### Further Reading
 - https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods

### Part-4: The HTTP Request
Being able to read the request line is a critical skill in Talking Rest

``` HTTP
POST /idms/v1/inspection/E092BB24A4B047AF8AA21769244AA050/published HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 129

{
    "lastInspectionDate": "2021-12-30",
    "notifications": [],
    "workorders": [],
    "assignedObjectIds": [
    ]
}
```

##### Further Reading
 - https://developer.mozilla.org/en-US/docs/Web/HTTP/Messages
