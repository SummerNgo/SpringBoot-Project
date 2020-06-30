package Team4CA.LMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Team4CA.LMS.domain.Overtime;
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
		model.addAttribute("elist", overtimeRepo.findAll());
		return "ManagerOvertimeToApproveList";
	}

	/*@RequestMapping(value = "overtime/approved") //{id}
	public String approved(@PathVariable("id") Integer id, Model model) {
		boolean b = overtimeService.approvedOvertimeByManager(id);
		if(b == true) {
			model.addAttribute("flag",1);
			return "ApprovedSuccessfulPage";
		}
		return "Overtimeadd";
	}*/
	
	@RequestMapping(value = "/overtimeApproved") //{id}
	public String approved(Model model) {
		//boolean b = overtimeService.approvedOvertimeByManager(id);
			model.addAttribute("approveflag",1);
			return "ManagerOvertimeToApproveList";
	}
	
}