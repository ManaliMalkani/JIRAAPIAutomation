Feature: Validating Jira Issue API's

Scenario: Verify Login for Jira API

Given User create a new session with "UserName" and "Password"
When user calls "CreateNewSession" with "Post" http Request
Then the API call got success with status code 200
And "session.name" in response body is "JSESSIONID"
And get "session.value" from response body

Scenario: Get Jira Group

Given User login with valid session id and Get a Jira Group
When user calls "GetGroupAPI" with "GET" http Request
Then the API call got success with status code 200

Scenario: Get Jira uses from Group

Given User login with valid session id and Get a Jira Group
When user calls "GetGroupUsersAPI" with "GET" http Request
Then the API call got success with status code 200

Scenario: Get Jira User

Given User login with valid session id and is valid user
When user calls "GetUserAPI" with "GET" http Request
Then the API call got success with status code 200
And get "self" from response body
And get "name" from response body
And get "emailAddress" from response body

Scenario: Update Jira User

Given User login with valid session id and update the user information
When user calls "UpdateUserAPI" with "PUT" http Request
Then the API call got success with status code 200
And get "key" from response body
And get "name" from response body
And get "emailAddress" from response body
And get "displayName" from response body


Scenario: Add Issue in Jira

Given User login with valid Session Id
When user calls "CreateIssueAPI" with "Post" http Request
Then the API call got success with status code 201
And get "id" from response body and save it
And get "key" from response body
And get "self" from response body

Scenario: Assign a user in Jira
Given User login with valid Session Id and IssueID and assignee details
When user calls "AssignAPI" with "Put" http Request
Then the API call got success with status code 204

Scenario: Add Comment for Existing Issue in Jira

Given User login with valid Session Id and IssueID
When user calls "AddCommentAPI" with "Post" http Request
Then the API call got success with status code 201
And get "id" from response body
And get "author.name" from response body
And get "author.key" from response body
And get "self" from response body
And get "body" from response body and save it and compare it
And get "id" from response body and store it

Scenario: Update Comment for Existing Issue in Jira

Given User login with valid Session Id and IssueID and CommentID to update the comment
When user calls "UpdateCommentAPI" with "Put" http Request
Then the API call got success with status code 200
And get "id" from response body
And get "author.name" from response body
And get "author.key" from response body
And get "self" from response body
And get "id" from response body and store it

Scenario: Get Comment for Existing Issue in Jira

Given User login with valid Session Id and IssueID and CommentID
When user calls "GetCommentAPI" with "Get" http Request
Then the API call got success with status code 200
And get "id" from response body
And get "author.name" from response body
And get "author.key" from response body
And get "self" from response body
And get "body" from response body
And get "id" from response body

Scenario: Get Statuses of Issues in Jira 
Given User login with valid session id and is valid user
When user calls "GetStatusesAPI" with "GET" http Request
Then the API call got success with status code 200
And get "id" from response body

Scenario: Get Status of Issue in Jira 
Given User login with valid Session Id and Status name
When user calls "GetStatusAPI" with "GET" http Request
Then the API call got success with status code 200
And get "id" from response body
And get "self" from response body

Scenario: Get Status Categories in Jira 
Given User login with valid session id and is valid user
When user calls "GetStatuscategoriesAPI" with "GET" http Request
Then the API call got success with status code 200
And get "id" from response body

Scenario: Get Status Category in Jira for Status name
Given User login with valid session id and valid status name
When user calls "GetStatuscategoryAPI" with "GET" http Request
Then the API call got success with status code 200

Scenario: Add Attachment for Existing Issue in Jira

Given User login with valid Session Id, header and IssueID
When user calls "AddAttachmentAPI" with "Post" http Request
Then the API call got success with status code 200
And get "self" from response body
And get "filename" from response body
And get "created" from response body
And get "size" from response body
And get "content" from response body
And get "id" from response and save it

Scenario: Get Attachment for Existing Issue in Jira

Given User login with valid Session Id and attachment ID
When user calls "GetAttachmentAPI" with "Get" http Request
Then the API call got success with status code 200
And get "self" from response body
And get "filename" from response body
And get "created" from response body
And get "size" from response body
And get "content" from response body

Scenario: Remove Attachment for Existing Issue in Jira

Given User login with valid Session Id and attachment ID and remove the attachmentId
When user calls "DeleteAttachmentAPI" with "Delete" http Request
Then the API call got success with status code 204

Scenario: Update Existing Issue in Jira
Given User login with valid Session Id and Jira ID for updating the existing issue
When user calls "UpdateIssueAPI" with "PUT" http Request
Then the API call got success with status code 204

Scenario: Get the issue details

Given User login with valid Session Id and Jira ID
When user calls "GetIssueAPI" with "GET" http Request
Then the API call got success with status code 200
And get "id" from response body
And get "self" from response body
And get "key" from response body
And get "fields.comment.comments[0].id" from response body
And get "fields.attachment.filename" from response body

Scenario: Get All Workflows in Jira

Given User login with valid Session ID to a valid Project
When user calls "GetAllWorkflowsAPI" with "GET" http Request
Then the API call got success with status code 200
And get "id" from response body
And get "title" from response body

Scenario: Get All Types of isssues

Given User login with valid Session ID to a valid Project
When user calls "GetIssueAllTypes" with "GET" http Request
Then the API call got success with status code 200
And get "id" from response body
And get "description" from response body

Scenario: Get Notification Schemes

Given User login with valid Session ID to a valid Project
When user calls "GetNotificationSchemes" with "GET" http Request
Then the API call got success with status code 200
And get "total" from response body
And get "maxResults" from response body

#Scenario: Get Property

#Given User login with valid Session ID to a valid Project
#When user calls "GetProperty" with "GET" http Request
#Then the API call got success with status code 200
#And get "id" from response body
#And get "key" from response body

Scenario: Delete Comment for Existing Issue in Jira

Given User login with valid Session Id and IssueID and CommentID
When user calls "DeleteCommentAPI" with "Delete" http Request
Then the API call got success with status code 204


Scenario: Delete the Issue

Given User login with valid Session Id and IssueID for Deleting the Issue
When user calls "DeleteIssueAPI" with "DELETE" http Request
Then the API call got success with status code 204

