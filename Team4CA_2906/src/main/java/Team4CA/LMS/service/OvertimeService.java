package Team4CA.LMS.service;

import java.util.List;

import Team4CA.LMS.domain.Overtime;
import Team4CA.LMS.domain.OvertimeStatus;

public interface OvertimeService {

	public boolean approvedOvertimeByManager(Integer id);

	public boolean rejectedOvertimeByManager(Integer id);
	
	public List<Overtime> findAll();
	
	public List<Overtime> findOvertimeByOvertimeStatus(OvertimeStatus os);
}
