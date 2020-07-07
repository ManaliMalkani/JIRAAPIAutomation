Feature: Validating Jira Issue API's



Scenario: Get Permissions of the CurrentUser

Given User login with valid Session ID to a valid Project
When user calls "GetPermissionsAPI" with "Get" http Request
Then the API call got success with status code 200

Scenario: Create a Project in the Jira

Given User login with valid session id and create a project
When user calls "CreateProjectAPI" with "Post" http Request
Then the API call got success with status code 201
And get "self" from response body
And get "id" from response body
And get "key" from response body and save the key

Scenario: Update a Project in the Jira

Given User login with valid session id and valid "project_id" and Update a project
When user calls "UpdateProjectAPI" with "PUT" http Request
Then the API call got success with status code 200
And get "self" from response body
And get "id" from response body
And get "key" from response body

Scenario: Get All Projects in the Jira

Given User login with valid session id and Get all Project
When user calls "GetAllProjectsAPI" with "GET" http Request
Then the API call got success with status code 200
And get "self" from response body
And get "id" from response body
And get "key" from response body

Scenario: Get Project in the Jira

Given User login with valid session id and project key and Get Project
When user calls "GetProjectAPI" with "GET" http Request
Then the API call got success with status code 200
And get "self" from response body
And get "id" from response body
And get "key" from response body

Scenario: Delete a Project in the Jira

Given User login with valid session id and valid "project_id" and Delete a project
When user calls "DeleteProjectAPI" with "DELETE" http Request
Then the API call got success with status code 204

