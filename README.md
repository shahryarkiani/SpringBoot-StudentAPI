# SpringBoot-StudentAPI





| Endpoint | Description |
| --- | --- |
|`GET /student` | Lists all students in the database |
|`POST /student` | Creates new student based on parameters defined in request body |
|`DELETE /student/{studentId}`| Deletes the student with the ID specified in the path |
|`PUT /student/{studentId}` | Updates the student with the ID specified to the new name or email specified in the Request Parameters |
|`GET /course` | Lists all the courses in the database |
|`GET /course/{courseId}` | Returns the course information for the course specified by the path|
|`POST /course/{courseId}/email` | Sends the message in the request body as an email to all the students in the course specified |
|`POST /course` | Creates a new course with the name specified in JSON in the request body |
|`PUT /course/{courseId}/` | Adds the student with the studentID specified in the request body to the course specified in the path |
