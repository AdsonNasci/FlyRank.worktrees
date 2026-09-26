# FlyRank Internship

## Description:
That's a repository designated for the FlyRank Internship program. It contains the Backend AI projects and other related resources for the internship. The repository is structured to facilitate collaboration and development of AI-based solutions.

## Stack

- **Backend** : Java, Spring, PostgreSQL, Bcrypt, Auth0, Swagger, Docker, Postman.


## Pre-requisites:
- Java Development Kit (JDK) 11 or higher
- Maven 3.6 or higher
- PostgreSQL 12 or higher
- Docker (for containerization)
- Postman (for API testing)

## Instructions to run the project: 
1. Clone the repository to your local machine using the command:
   ```
   git clone https://github.com/AdsonNasci/FlyRank.worktrees.git
   ```

## How to run the project using Docker:
1. Ensure Docker is installed and running on your machine.
2. Navigate to the project directory in your terminal.
3. Make sure your running a PostgreSQL container or have a PostgreSQL database running and update the `application.properties` file with the correct database connection details.
4. Build the Docker image using the command:
   ```
   docker build -t flyrank-backend .
5. Run the Docker container using the command:
   ```
   docker run -p 8080:8080 flyrank-backend
   ```
6. The application should now be accessible at `http://localhost:8080`.


## API Documentation:
The API documentation is available via Swagger. Once the application is running, you can access the Swagger UI at `http://localhost:8080/swagger-ui.html` to explore the available endpoints and their
    functionalities.
```
 GET /Controller/listTasks - retrives a list of all tasks registered.
```
```json
    [{
        "id": 1,
        "name": "Task 1",
        "description": "Description of Task 1",
        "status": "Pending"
    },
    {
        "id": 2,
        "name": "Task 2",
        "description": "Description of Task 2",
        "status": "Completed"
    }]
```
```
GET /Controller/obtainTask/{id} - retrieves a specific task by its ID.
```
```json
    {
        "id": 1,
        "name": "Task 1",
        "description": "Description of Task 1",
        "status": "Pending"
    }
```
```
Post /Controller/addTask - registers a new task.
```
```json
    {
        "id": 3,
        "name": "Task 3",
        "description": "Description of Task 3",
        "status": "Pending"
    }
```
```
    Post /Controller/updateTask/{id} - updates an existing task by its ID.
```
```json
    {
        "id": 1,
        "name": "Updated Task 1",
        "description": "Updated description of Task 1",
        "status": "Completed"
    }
```
```
    Delete /Controller/deleteTask/{id} - deletes a specific task by its ID. 
```
```json
    {
        "message": "Task with ID 1 has been deleted successfully."
    }
```

## Authentication:
The application uses Auth0 for authentication. You will need to set up an Auth0 account and
    configure the application with your Auth0 credentials. Update the `application.properties` file with your Auth0 domain and client ID.   

## Contributing:
 This repository is free for any kind of contribution.

## Gitflow Workflow:
1. **Fork the repository**: Click on the "Fork" button at the top right corner of the repository page to create a copy of the repository under your GitHub account.
2. **Clone the forked repository**: Use the following command to clone the forked repository to your local machine:
   ```
   git clone https://github.com/your-username/FlyRank.worktrees.git
   ```
   


