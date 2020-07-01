package Team4CA.LMS.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Team4CA.LMS.domain.LeaveRequest;
import Team4CA.LMS.domain.LeaveStatus;
import Team4CA.LMS.repo.LeaveRequestRepo;


@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {
	@Autowired 
	LeaveRequestRepo lrrepo;

	@Override
	public ArrayList<LeaveRequest> findByLeaveStatus(LeaveStatus ls) {
		ArrayList<LeaveRequest> pendingList = (ArrayList<LeaveRequest>)lrrepo.findByLeaveStatus(LeaveStatus.APPLIED);
			return pendingList;
	
	}

	@Override
	public boolean approvedLeaveByManager(Integer id) {
		LeaveRequest leaveRequest = lrrepo.findById(id).get();
		leaveRequest.setLeaveStatus(LeaveStatus.APPROVED);
		if (lrrepo.save(leaveRequest) != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean rejectLeaveByManager(Integer id) {
		LeaveRequest leaveRequest1 = lrrepo.findById(id).get();
		leaveRequest1.setLeaveStatus(LeaveStatus.REJECTED);
		if ( lrrepo.save(leaveRequest1) != null)
			return true;
		else
			return false;
	}

}