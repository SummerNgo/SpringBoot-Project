package Team4CA.LMS.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import Team4CA.LMS.domain.LeaveRequest;
import Team4CA.LMS.domain.LeaveStatus;

public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, Integer> {
	public ArrayList<LeaveRequest> findByLeaveStatus(LeaveStatus ls);
}
