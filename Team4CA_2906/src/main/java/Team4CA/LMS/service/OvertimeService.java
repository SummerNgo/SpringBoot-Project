package Team4CA.LMS.service;

public interface OvertimeService {

	public boolean approvedOvertimeByManager(Integer id);

	public boolean rejectedOvertimeByManager(Integer id);
}
