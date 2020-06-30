package Team4CA.LMS.service;

import java.util.ArrayList;

import Team4CA.LMS.domain.LeaveRequest;
import Team4CA.LMS.domain.LeaveStatus;


public interface LeaveRequestService {
	public ArrayList<LeaveRequest> findByLeaveStatus(LeaveStatus ls);
}
