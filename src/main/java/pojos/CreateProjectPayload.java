package pojos;

public class CreateProjectPayload {
	
	private String createdBy;
	private String projectName;
	private String status;
	private int teamSize;
	
	public CreateProjectPayload(String c, String p, String s, int t)
	{
		createdBy = c;
		projectName = p;
		status = s;
		teamSize = t;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getStatus() {
		return status;
	}

	public int getTeamSize() {
		return teamSize;
	}

}
