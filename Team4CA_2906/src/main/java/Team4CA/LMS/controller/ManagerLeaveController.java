package Team4CA.LMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Team4CA.LMS.domain.LeaveStatus;
import Team4CA.LMS.repo.LeaveRequestRepo;
import Team4CA.LMS.service.LeaveRequestService;
import Team4CA.LMS.service.LeaveRequestServiceImpl;

@Controller
public class ManagerLeaveController {
	@Autowired
	private LeaveRequestService lrs;
	
    @Autowired
	public void setLeaveRequestService(LeaveRequestServiceImpl lrsImpl) {
		lrs = lrsImpl;
	}
    @Autowired
    private LeaveRequestRepo lrrepo;
	
	@RequestMapping(value="/pendingLeavelist")
	public String pendingLeaveList(Model model)
	{
		model.addAttribute("pendingLeaveList", lrs.findByLeaveStatus(LeaveStatus.APPLIED));
		return "ManagerLeaveToApproveList";
	}
	
	@RequestMapping(value = "/leaveApproved/{id}") 
	public String leaveApproved(@PathVariable("id")Integer id, Model model) {
		
		boolean b = lrs.approvedLeaveByManager(id);
		
		if(b == true) {
			model.addAttribute("leaveApproveflag",1);
		}else {
			model.addAttribute("leaveApproveflag",2);
		}
			return "forward:/pendingLeavelist";
	}
	
	@RequestMapping(value = "/leaveRejected/{id}") //{id}
	public String leaveRejected(@PathVariable("id")Integer id, Model model) {
		
		boolean b = lrs.rejectLeaveByManager(id);
		
		if(b == true) {
			model.addAttribute("leaveRejectflag",1);
		}else {
			model.addAttribute("leaveRejectflag",2);
		}
			
			return "forward:/pendingLeavelist";
	}

}