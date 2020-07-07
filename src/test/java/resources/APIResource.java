package resources;

public enum APIResource {
	
	CreateNewSession("/rest/auth/1/session"),
	GetPermissionsAPI("/rest/api/2/mypermissions"),
	CreateProjectAPI("/rest/api/2/project"),
	UpdateProjectAPI("/rest/api/2/project/{key}"),
	GetAllProjectsAPI("/rest/api/2/project"),
	GetProjectAPI("/rest/api/2/project/{key}"),
	DeleteProjectAPI("/rest/api/2/project/{key}"),
	GetUserAPI("/rest/api/2/myself"),
	UpdateUserAPI("/rest/api/2/myself"),
	CreateIssueAPI("/rest/api/2/issue"),
	AddCommentAPI("/rest/api/2/issue/{key}/comment"),
	AddAttachmentAPI("rest/api/2/issue/{key}/attachments"),
	GetAttachmentAPI("rest/api/2/attachment/{id}"),
	GetIssueAPI("/rest/api/2/issue/{key}"),
	DeleteIssueAPI("/rest/api/2/issue/{key}");
	
	private String resources;
	
	APIResource (String resources){	
		this.resources=resources;
	}
	
	public String getResource()
	{
		return resources;
	}
	

}


