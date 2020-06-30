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

}