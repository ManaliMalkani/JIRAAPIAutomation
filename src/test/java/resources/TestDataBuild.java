package resources;

public class TestDataBuild {
	
	
	public String LoginJiraApiPayload(){
		
		return "{ \"username\": \"manali.malkani\", \"password\": \"admin@123\" }";
		
	}
	
	public String CreateIssueAPIPayload(){
		
		return"{\r\n" + 
				"	\"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"RES\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"Manali Automation Testing\",\r\n" + 
				"        \"description\": \"API Automation\",\r\n" + 
				"        \"issuetype\": {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"        }\r\n" + 
				"        }\r\n" + 
				"       \r\n" + 
				"}";
	}
	
public String UpdateIssueAPIPayload(){
		
		return"{\r\n" + 
				"	\"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"RES\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"Manali Rest API Automation Testing\",\r\n" + 
				"        \"description\": \"Rest API Automation\",\r\n" + 
				"        \"issuetype\": {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"        }\r\n" + 
				"        }\r\n" + 
				"       \r\n" + 
				"}";
	}
	
public String AddCommentAPIPayload(String expectedMessage){
		
		return"{\r\n" + 
				"    \"body\": \""+expectedMessage+"\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
	}public String UpdateCommentAPIPayload(String expectedMessage){
		
		return"{\r\n" + 
				"    \"body\": \""+expectedMessage+"update"+"\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
	}



public String CreateProjectAPIPayload(){
	
	return"{\r\n" + 
			"    \"key\": \"EX\",\r\n" + 
			"    \"name\": \"Example\",\r\n" + 
			"    \"projectTypeKey\": \"business\",\r\n" + 
			"    \"projectTemplateKey\": \"com.atlassian.jira-core-project-templates:jira-core-project-management\",\r\n" + 
			"    \"description\": \"Example Project description\",\r\n" + 
			"    \"lead\": \"manali.malkani\",\r\n" + 
			"    \"url\": \"http://atlassian.com\",\r\n" + 
			"    \"assigneeType\": \"PROJECT_LEAD\"\r\n" + 
			"}";
}

public String UpdateProjectAPIPayload(){
	
	return"{\r\n" + 
			"    \"key\": \"EX\",\r\n" + 
			"    \"name\": \"Example\",\r\n" + 
			"    \"projectTypeKey\": \"business\",\r\n" + 
			"    \"projectTemplateKey\": \"com.atlassian.jira-core-project-templates:jira-core-project-management\",\r\n" + 
			"    \"description\": \"Example Project description\",\r\n" + 
			"    \"lead\": \"manali.malkani\",\r\n" + 
			"    \"url\": \"http://google.com\",\r\n" + 
			"    \"assigneeType\": \"PROJECT_LEAD\"\r\n" + 
			"}";
}

public String UpdateUserAPIPayload(){
	
	return "{\r\n" + 
			"    \"password\": \"admin@123\",\r\n" + 
			"    \"emailAddress\": \"manali.malkani@atlassian.com\",\r\n" + 
			"    \"displayName\": \"Manali of Atlassian\"\r\n" + 
			"}";
}

public String AssignAPIPayload(){
	
	return "{\r\n" + 
			"    \"name\": \"manali.malkani\"\r\n" + 
			"}";
}

public String CreateGroup(){
	
	return "{\r\n" + 
			"    \"id\": \"https://docs.atlassian.com/jira/REST/schema/add-group#\",\r\n" + 
			"    \"title\": \"Manali Group\",\r\n" + 
			"    \"type\": \"object\",\r\n" + 
			"    \"properties\": {\r\n" + 
			"        \"name\": {\r\n" + 
			"            \"type\": \"string\"\r\n" + 
			"        }\r\n" + 
			"    },\r\n" + 
			"    \"additionalProperties\": false\r\n" + 
			"}";
}

}
