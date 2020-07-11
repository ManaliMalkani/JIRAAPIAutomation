package resources;

public enum APIResource {
	
	CreateNewSession("/rest/auth/1/session"),
	GetPermissionsAPI("/rest/api/2/mypermissions"),
	CreateProjectAPI("/rest/api/2/project"),
	UpdateProjectAPI("/rest/api/2/project/{key}"),
	GetAllProjectsAPI("/rest/api/2/project"),
	GetProjectAPI("/rest/api/2/project/{key}"),
	GetProjectRolesAPI("/rest/api/2/project/{key}/role"),
	DeleteProjectAPI("/rest/api/2/project/{key}"),
	GetGroupAPI("/rest/api/2/group"),
	GetGroupUsersAPI("/rest/api/2/group/member"),
	GetUserAPI("/rest/api/2/myself"),
	UpdateUserAPI("/rest/api/2/myself"),
	CreateIssueAPI("/rest/api/2/issue"),
	AssignAPI("/rest/api/2/issue/{key}/assignee"),
	GetStatusesAPI("rest/api/2/status"),
	GetStatusAPI("/rest/api/2/status/{name}"),
	GetStatuscategoriesAPI("/rest/api/2/statuscategory"),
	GetStatuscategoryAPI("/rest/api/2/statuscategory/{key}"),
	GetAllWorkflowsAPI("/rest/api/2/workflow"),
	GetIssueAllTypes("/rest/api/2/issuetype"),
	GetNotificationSchemes("/rest/api/2/notificationscheme"),
	GetProperty("/rest/api/2/application-properties"),
	AddCommentAPI("/rest/api/2/issue/{key}/comment"),
	UpdateCommentAPI("/rest/api/2/issue/{key}/comment/{id}"),
	DeleteCommentAPI("/rest/api/2/issue/{key}/comment/{id}"),
	GetCommentAPI("/rest/api/2/issue/{key}/comment/{id}"),
	AddAttachmentAPI("rest/api/2/issue/{key}/attachments"),
	GetAttachmentAPI("rest/api/2/attachment/{id}"),
	DeleteAttachmentAPI("rest/api/2/attachment/{id}"),
	UpdateIssueAPI("/rest/api/2/issue/{key}"),
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


