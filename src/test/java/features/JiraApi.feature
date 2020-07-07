Feature: Validating Jira Issue API's

Scenario: Verify Login for Jira API

Given User create a new session with "UserName" and "Password"
When user calls "CreateNewSession" with "Post" http Request
Then the API call got success with status code 200
And "session.name" in response body is "JSESSIONID"
And get "session.value" from response body

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

Scenario: Add Comment for Existing Issue in Jira

Given User login with valid Session Id and IssueID
When user calls "AddCommentAPI" with "Post" http Request
Then the API call got success with status code 201
And get "id" from response body
And get "author.name" from response body
And get "author.key" from response body
And get "self" from response body
And get "body" from response body and save it and compare it

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


Scenario: Get the issue details

Given User login with valid Session Id and Jira ID
When user calls "GetIssueAPI" with "GET" http Request
Then the API call got success with status code 200
And get "id" from response body
And get "self" from response body
And get "key" from response body
And get "fields.comment.comments[0].id" from response body
And get "fields.attachment.filename" from response body


Scenario: Delete the Issue

Given User login with valid Session Id and IssueID for Deleting the Issue
When user calls "DeleteIssueAPI" with "DELETE" http Request
Then the API call got success with status code 204

