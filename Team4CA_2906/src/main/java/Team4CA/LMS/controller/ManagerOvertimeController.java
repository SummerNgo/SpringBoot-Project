package Team4CA.LMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Team4CA.LMS.domain.Overtime;
import Team4CA.LMS.domain.OvertimeStatus;
import Team4CA.LMS.repo.OvertimeRepo;
import Team4CA.LMS.service.OvertimeService;

@Controller
public class ManagerOvertimeController {

	
	@Autowired
	OvertimeRepo overtimeRepo;
	
	@Autowired
	OvertimeService overtimeService;
	
	@RequestMapping(value = "/overtimelist")
	public String list(Model model) {
		//model.addAttribute("overtimeClaimList", overtimeService.findAll());
		
		model.addAttribute("overtimeClaimList",overtimeService.findOvertimeByOvertimeStatus(OvertimeStatus.APPLIED));
		return "ManagerOvertimeToApproveList";
	}

	@RequestMapping(value = "/overtimeApproved/{id}") //{id}
	public String approved(@PathVariable("id")Integer id, Model model) {
		
		boolean b = overtimeService.approvedOvertimeByManager(id);
		
		if(b == true) {
			model.addAttribute("approveflag",1);
		}else {
			model.addAttribute("approveflag",2);
		}
			return "forward:/overtimelist";
	}
	
	@RequestMapping(value = "/overtimeRejected/{id}") //{id}
	public String rejected(@PathVariable("id")Integer id, Model model) {
		
		boolean b = overtimeService.rejectedOvertimeByManager(id);
		
		if(b == true) {
			model.addAttribute("rejectflag",1);
		}else {
			model.addAttribute("rejectflag",2);
		}
			
			return "forward:/overtimelist";
	}
	
}