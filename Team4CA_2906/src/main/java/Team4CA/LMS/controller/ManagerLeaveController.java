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
	
	@RequestMapping(value="/pendingleavelist")
	public String pendingLeaveList(Model model)
	{
		model.addAttribute("pendingLeaveList", lrs.findByLeaveStatus(LeaveStatus.APPLIED));
		return "ManagerLeaveToApproveList";
	}
	
	/*
	 * @RequestMapping(value="/approve/{id}") public String approveLeaveList(Model
	 * model, @PathVariable("id") Integer id) { model.addAttribute("leaveRequest",
	 * lrrepo.findById(id).get());
	 * 
	 * return "ManagerLeaveToApproveList";
	 */
	

}