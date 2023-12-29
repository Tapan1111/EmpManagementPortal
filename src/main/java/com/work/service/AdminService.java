package com.work.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.model.Admin;
import com.work.repository.AdminRepository;
import com.work.utils.ServiceResponse;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin saveAdmin(Admin admin) {
		
		return adminRepository.save(admin);
	}
	
	public ServiceResponse fetchAdminByEmailId(Admin admin) {
		Admin data = adminRepository.findByEmailId(admin.getEmailId());
		ServiceResponse serviceResponse = new ServiceResponse();
		if(data != null) {
			serviceResponse.setServiceResponse("Email already exists");
			serviceResponse.setServiceStatus("Fail");
			
						
		}else {
			adminRepository.save(admin);
			serviceResponse.setServiceResponse("Admin registered success");
			serviceResponse.setServiceStatus("Success");
			
					
		}
		return serviceResponse;
		
	}
	
	public ServiceResponse fetchAdminByEmailAndPassword(String email, String password) {
		Admin admin = new Admin();
		ServiceResponse serviceResponse = new ServiceResponse();
		admin = adminRepository.findByEmailIdAndPassword(email, password);
		
		if(admin==null) {
			serviceResponse.setServiceResponse("no user found Please Register");
			serviceResponse.setServiceStatus("Fail");
		}else {
			serviceResponse.setServiceResponse(admin);
			serviceResponse.setServiceStatus("Success");
		}
		return serviceResponse;
	}
	
	public ServiceResponse generateOtp(Admin admin) {
	    int staticOtp = 12341234;
	    ServiceResponse serviceResponse = new ServiceResponse();
	    
	    Admin data = adminRepository.findByEmailIdAndPassword(admin.getEmailId(), admin.getPassword());
	    System.out.println(data.toString());
	    	
	    if (admin.getOtp() == staticOtp) {
	        serviceResponse.setServiceResponse(data);
	        serviceResponse.setServiceStatus("Success");
	    } else {
	        serviceResponse.setServiceResponse("Wrong OTP");
	        serviceResponse.setServiceStatus("Fail");
	    }
	    return serviceResponse;
	}
	
    public ServiceResponse getAllEntries() {
    	ServiceResponse serviceResponse = new ServiceResponse();
    	List<Admin> allEmployeeList = adminRepository.findAll();

    	if(!allEmployeeList.isEmpty()) {
    		serviceResponse.setServiceStatus("Sucess");
    		serviceResponse.setServiceResponse(allEmployeeList);
    	}else {
    		serviceResponse.setServiceStatus("Fail");
    		serviceResponse.setServiceResponse("Employee List is Empty.");
    	}
    	
		return serviceResponse;
	}
    
    public ServiceResponse getEmployeeById(int id) {
    	ServiceResponse serviceResponse = new ServiceResponse();
    	Optional<Admin> data = adminRepository.findById(id);
    	
    	if(data.isPresent()) {
    		serviceResponse.setServiceStatus("Sucess");
    		serviceResponse.setServiceResponse(data.get());
    	}else {
    		serviceResponse.setServiceStatus("Fail");
    		serviceResponse.setServiceResponse("Employeeinfo not present");
    	}
    	
    	return serviceResponse;
    }
    
    public ServiceResponse deleteEntriesById(int id) {
    	ServiceResponse serviceResponse = new ServiceResponse();
    	    Optional<Admin> deleteData = adminRepository.findById(id);
    	    
    	    if(deleteData.isPresent()) {
    	    	adminRepository.deleteById(id);
    	    serviceResponse.setServiceResponse(deleteData);
    	    serviceResponse.setServiceStatus("Entry deleted successfully");
    	    	
    	    }else {
    	    	serviceResponse.setServiceStatus("Fail");
    	        serviceResponse.setServiceResponse("Entry not found");
    	    }
			return serviceResponse;	
    }
    public Admin updateEntries(Admin admin) {
    	int id = admin.getId();
    	Admin usr = adminRepository.findById(id).get();
    	usr.setUserName(admin.getUserName());
    	usr.setEmailId(admin.getEmailId());
    	usr.setPassword(admin.getPassword());
    	usr.setPhone(admin.getPhone());
    	usr.setAddress(admin.getAddress());
    	usr.setOtp(admin.getOtp());
    	usr.setRole(admin.getRole());
		usr.setSalary(admin.getSalary());
		usr.setDepartment(admin.getDepartment());
		usr.setAnnualSalary(admin.getAnnualSalary());
		usr.setDoB(admin.getDoB());
    		
		return adminRepository.save(usr);  	
    }
  
	
    


	

}
