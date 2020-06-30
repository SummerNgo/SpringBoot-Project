package Team4CA.LMS;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import Team4CA.LMS.repo.EmployeeRepo;
import Team4CA.LMS.repo.LeaveRequestRepo;
import Team4CA.LMS.repo.LeaveTypeRepo;
import Team4CA.LMS.repo.OvertimeRepo;
import Team4CA.LMS.repo.UserRepo;
import Team4CA.LMS.domain.*;
@SpringBootApplication
public class Team4CaApplication {
	@Autowired
	EmployeeRepo erepo;
	@Autowired
	LeaveRequestRepo lrrepo;
	@Autowired
	LeaveTypeRepo ltrepo;
	@Autowired
	OvertimeRepo orepo;
	@Autowired
	UserRepo urepo;





	public static void main(String[] args) {
		SpringApplication.run(Team4CaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String d0 = "2014-02-11";
			Date dob = sdf.parse(d0);
			
			String d1 = "2017-02-11";
			Date s1 = sdf.parse(d1);
			String d2 = "2020-06-11";
			Date end1 = sdf.parse(d2);
			//create Employee object
			Employee e1 = new Employee ("Summer",Role.ADMIN,Gender.FEMALE,dob,s1,end1);
			erepo.save(e1);
			String d3 = "2019-05-11";
			Date leavestart1 = sdf.parse(d3);
			String d4 = "2019-05-15";
			Date leaveend1 = sdf.parse(d4);
			
			//create LeaveType object
			LeaveType lt1 = new LeaveType("Annual Leave",18,9,e1);
			ltrepo.save(lt1);
			
			
			//create LeaveRequest Object
			LeaveRequest lr1 = new LeaveRequest(leavestart1,leaveend1,5,"Annual Leave"," ",LeaveStatus.APPLIED,e1,lt1);
			lrrepo.save(lr1);
			
			//create OverTime Object
			
			Overtime o1 = new Overtime(LocalDateTime.of(2020,4,10,18,0,0),LocalDateTime.of(2020,4,10,21,0,0),OvertimeStatus.APPLIED,3,"Urgent report",e1);
			orepo.save(o1);
		};
	}
	
		

}

