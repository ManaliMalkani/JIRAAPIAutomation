package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.IOException;

import com.atlassian.sal.api.websudo.WebSudoManager;

import com.atlassian.jira.rest.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResource;
import resources.TestDataBuild;
import resources.Utils;
public class stepDefinitions {
	
	
	TestDataBuild data= new TestDataBuild();
	static SessionFilter session= new SessionFilter();
	RequestSpecification req;
	ResponseSpecification resspec;
	static Response response;
	String SessionIdValue;
	static String issue_id;
	static String project_key;
	String expectedMessage;
	static String attachmentId;
	static String commentId;
	
	
	//https://developer.atlassian.com/server/jira/platform/cookie-based-authentication/
	@Given("User create a new session with {string} and {string}")
	public void user_create_a_new_session_with_and(String string, String string2) throws IOException {
		    
		req=given().spec(Utils.requestSpecification())
            		.body(data.LoginJiraApiPayload())
            		.filter(session);
			}
		
	@When("user calls {string} with {string} http Request")
	public void user_calls_with_http_request(String resource, String method) {
			    
		APIResource resourceAPI= APIResource.valueOf(resource);
		resourceAPI.getResource();
		System.out.println(resourceAPI.getResource());
		resspec= new ResponseSpecBuilder().expectStatusCode(200)
					                      .expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
		response=req.when().post(resourceAPI.getResource()).then().extract().response();
		else if(method.equalsIgnoreCase("GET"))
		response =req.when().get(resourceAPI.getResource()).then().extract().response();
		else if(method.equalsIgnoreCase("DELETE"))
		response =req.when().delete(resourceAPI.getResource()).then().extract().response();
		else if(method.equalsIgnoreCase("PUT"))
		response =req.when().put(resourceAPI.getResource()).then().extract().response();
		}
		
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(int int1) {
			assertEquals(response.getStatusCode(),int1);	
		}
		
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {
			System.out.println(keyValue);
			assertEquals(Utils.getJsonPath(response,keyValue), ExpectedValue);	
		}
		
	@Then("get {string} from response body")
	public void get_from_response_body(String key) {
			        String value=Utils.getJsonPath(response, key);
				    System.out.println(key+":"+value);
		}
		
	//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/-getPermissions
		 
	@Given("User login with valid Session ID to a valid Project")
	public void user_login_with_valid_session_id_to_a_valid_project() throws IOException {
				req=given().spec(Utils.requestSpecification())
          		 .filter(session);
          		// .pathParam("projectKey", project_key);
			}

	//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/myself-getUser
		
	@Given("User login with valid session id and is valid user")
	public void user_login_with_valid_session_id_and_is_valid_user() throws IOException {
				req=given().spec(Utils.requestSpecification())
		          		 .filter(session);
			}
			
	//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/myself-updateUser
			
	@Given("User login with valid session id and update the user information")
	public void user_login_with_valid_session_id_and_update_the_user_information() throws IOException {
				req=given().spec(Utils.requestSpecification())
	            		.body(data.UpdateUserAPIPayload())
	            		.filter(session);  
				}
		
	//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/group-createGroup
	@Given("User login with valid session id and Get a Jira Group")
	public void user_login_with_valid_session_id_and_get_a_jira_group() throws IOException {
			    req=given().spec(Utils.requestSpecification())
	            		//.body(data.CreateGroup())
						.queryParam("groupname", "jira-administrators")
						.queryParam("expand", "users")
	            		.filter(session); 
			}

	 //https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/project-createProject
	 @Given("User login with valid session id and create a project")
	 public void user_login_with_valid_session_id_and_create_a_project() throws IOException {
				req=given().spec(Utils.requestSpecification())
			          		 .filter(session)
			          		 .body(data.CreateProjectAPIPayload());
			          		// .pathParam("projectKey", project_key);
				}

	 @Then("get {string} from response body and save the key")
	 public void get_from_response_body_and_save_the_key(String key) {
				project_key=Utils.getJsonPath(response, key);
			    System.out.println(key+":"+project_key);  
					}
				
	 //https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/project-updateProject
	 @Given("User login with valid session id and valid {string} and Update a project")
	 public void user_login_with_valid_session_id_and_valid_and_update_a_project(String string) throws IOException {
						req=given().spec(Utils.requestSpecification())
				          		 .filter(session)
				          		 .body(data.UpdateProjectAPIPayload())
				          		. pathParam("key", project_key);
					}

	   //https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/project-getAllProjects
					
		@Given("User login with valid session id and Get all Project")
		public void user_login_with_valid_session_id_and_get_all_project() throws IOException {
							req=given().spec(Utils.requestSpecification())
					          		 .filter(session);
						}

		//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/project-getProject
		
			@Given("User login with valid session id and project key")
			public void user_login_with_valid_session_id_and_project_key() throws IOException {
			    req=given().spec(Utils.requestSpecification())
	          		 .filter(session)
	          		. pathParam("key", project_key);	    
							}

	   //https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/project-deleteProject
		@Given("User login with valid session id and valid {string} and Delete a project")
		public void user_login_with_valid_session_id_and_valid_and_delete_a_project(String string) throws IOException {
					   req=given().spec(Utils.requestSpecification())
			          		 .filter(session)
			          		. pathParam("key", project_key);
					}

//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/issue-createIssue
				
			
		@Given("User login with valid Session Id")
		public void user_login_with_valid_session_id() throws IOException {
						
						 req=given().spec(Utils.requestSpecification())
			            		  .body(data.CreateIssueAPIPayload())
			            		  .filter(session);
						}
					
					
						@Then("get {string} from response body and save it")
						public void get_from_response_body_and_save_it(String key) {
							issue_id=Utils.getJsonPath(response, key);
						    System.out.println(key+":"+issue_id);
						}
						
//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/issue-assign
						
							@Given("User login with valid Session Id and IssueID and assignee details")
							public void user_login_with_valid_session_id_and_issue_id_and_assignee_details() throws IOException {
								req=given().spec(Utils.requestSpecification())
										.pathParam("key", issue_id).log().all()
										.body(data.AssignAPIPayload())
										.filter(session);
							}



						
						
						//Add Comment
//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/issue-addComment


							@Given("User login with valid Session Id and IssueID")
							public void user_login_with_valid_session_id_and_issue_id() throws IOException {
							    expectedMessage="Jira API automation";
								req=given().spec(Utils.requestSpecification())
								.pathParam("key", issue_id).log().all()
								.body(data.AddCommentAPIPayload(expectedMessage))
								.filter(session);
								//.when().post("/rest/api/2/issue/{key}/comment")
								//.then().log().all().assertThat().statusCode(201).extract().response();
								
								//to get comment id
								//JsonPath js1= new JsonPath(addCommentResponse);
								//String commentid=js1.getString("id");
								//System.out.println(commentid);
								
								
							}
							
							
								@Then("get {string} from response body and save it and compare it")
								public void get_from_response_body_and_save_it_and_compare_it(String key) {
									String commentBody=Utils.getJsonPath(response, key);
								    System.out.println(key+":"+commentBody);
								  assertEquals(commentBody,expectedMessage);
								}
								
								

									@Then("get {string} from response body and store it")
									public void get_from_response_body_and_store_it(String key) {
										commentId=Utils.getJsonPath(response, key);
									    System.out.println(key+":"+commentId);
									   
									}
//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/issue-updateComment
									
									
										@Given("User login with valid Session Id and IssueID and CommentID to update the comment")
										public void user_login_with_valid_session_id_and_issue_id_and_comment_id_to_update_the_comment() throws IOException {
											req=given().spec(Utils.requestSpecification())
									          		   .filter(session)
									          		   .pathParam("key", issue_id)
									          		   .pathParam("id",commentId)
									          		   .body(data.UpdateCommentAPIPayload(expectedMessage));
										}




//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/issue-getComment
									
									
										@Given("User login with valid Session Id and IssueID and CommentID")
										public void user_login_with_valid_session_id_and_issue_id_and_comment_id() throws IOException {
											req=given().spec(Utils.requestSpecification())
									          		   .filter(session)
									          		   .pathParam("key", issue_id)
									          		   .pathParam("id",commentId);
										}




//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/issue/{issueIdOrKey}/attachments-addAttachment
								
								

									@Given("User login with valid Session Id, header and IssueID")
									public void user_login_with_valid_session_id_header_and_issue_id() throws IOException {
									    
										req=given().spec(Utils.requestSpecification())
												.header("X-Atlassian-Token","no-check")
												.filter(session)
												.pathParam("key", issue_id).log().all().header("Content-Type","multipart/form-data")
												.multiPart("file",new File("jira.txt"));
												
									}
									
									

										@Then("get {string} from response and save it")
										public void get_from_response_and_save_it(String id) {
											attachmentId=Utils.getJsonPath(response, id);
										    System.out.println(id+":"+attachmentId); 
										    attachmentId=attachmentId.substring(1, 6);
										}




//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/attachment-getAttachment
									

									
	@Given("User login with valid Session Id and attachment ID")
	public void user_login_with_valid_session_id_and_attachment_id() throws IOException {
			req=given().spec(Utils.requestSpecification())
			           .filter(session)
					   .pathParam("id", attachmentId);	    
																}

											
	//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/attachment-removeAttachment

	

		@Given("User login with valid Session Id and attachment ID and remove the attachmentId")
		public void user_login_with_valid_session_id_and_attachment_id_and_remove_the_attachment_id() throws IOException {
			req=given().spec(Utils.requestSpecification())
			           .filter(session)
					   .pathParam("id", attachmentId);
		}
		
		//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/status-getStatus

			@Given("User login with valid Session Id and Status name")
			public void user_login_with_valid_session_id_and_status_name() throws IOException {
				req=given().spec(Utils.requestSpecification())
						.filter(session)
						.pathParam("name", "To Do");
			   
			}
			//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/statuscategory-getStatusCategory
			

				@Given("User login with valid session id and valid status name")
				public void user_login_with_valid_session_id_and_valid_status_name() throws IOException {
					req=given().spec(Utils.requestSpecification())
							.filter(session)
							.pathParam("key", "new");
				}





		//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/issue-editIssue
			@Given("User login with valid Session Id and Jira ID for updating the existing issue")
			public void user_login_with_valid_session_id_and_jira_id_for_updating_the_existing_issue() throws IOException {
				req=given().spec(Utils.requestSpecification())
						.filter(session)
						.pathParam("key", issue_id)
						.body(data.UpdateIssueAPIPayload());
			}
				
			
			//io.cucumber.junit.UndefinedStepException: The step "User login with valid Session ID for GetProperty" is undefined. You can implement it using the snippet(s) below:
			 /*
				@Given("User login with valid Session ID for GetProperty")
				public void user_login_with_valid_session_id_for_get_property() {
					 cookie_string = 
							 Cookies.join(";")
							def resp
							log.debug "Authorizing user with WebSudo: &lt;${config.rest_api_client.username}"
							resp = myRESTClient.post(
							     path : 'jira/secure/admin/WebSudoAuthenticate.jspa',
							     headers: ['Cookie': cookie_string],
							                requestContentType : URLENC,
							                query : [webSudoPassword: config.rest_api_client.password.toString()]
							)
				}
*/



//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/issue-getIssue

									
										@Given("User login with valid Session Id and Jira ID")
										public void user_login_with_valid_session_id_and_jira_id() throws IOException {
											req=given().spec(Utils.requestSpecification())
													.filter(session)
													.pathParam("key", issue_id);
													//.queryParams("fields","comment")-If you want to do query parameter to generate only get single field to limit the response
										}

										//https://docs.atlassian.com/software/jira/docs/api/REST/7.6.1/#api/2/issue-deleteIssue

											@Given("User login with valid Session Id and IssueID for Deleting the Issue")
											public void user_login_with_valid_session_id_and_issue_id_for_deleting_the_issue() throws IOException {
												req=given().spec(Utils.requestSpecification())
														.filter(session)
														.pathParam("key", issue_id)
														.queryParam("deleteSubtasks", "true");
											}

}
