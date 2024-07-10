package com.admin.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.Admin;
//import com.admin.entity.Tutor;
import com.admin.entity.UpdatePasswordForm;
//import com.admin.entity.User;
import com.admin.exception.UserNotFoundException;
import com.admin.repo.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
@Autowired
    private AdminRepository adminRepository;

   

    @Override
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin updateAdminProfile(Long id, Admin admin) {
        admin.setId(id); // Ensure the ID is set correctly
        return adminRepository.save(admin);
    }
//    @Override
//    public Admin updateAdminProfile(Admin updatedAdmin) {
//        return adminRepository.save(updatedAdmin);
//    }

	@Override
	public Admin addAdmin(Admin admin) {	
		return adminRepository.save(admin);
	}
	@Override
	public String login(String email, String password) {
		Admin adminEntity = adminRepository.findByEmailAndPassword(email, password);
		if (adminEntity!=null) {
			return "login success";
		}
		return "check eamil and password";
	}
	   public String updateAdminPassword(UpdatePasswordForm form) {
	        Admin adminEntity = adminRepository.findByEmail(form.getEmail());
	        if (adminEntity != null) {
	            adminEntity.setPassword(form.getPassword());
	            adminEntity.setConfirmPassword(form.getConfirmPassword());
	            adminRepository.save(adminEntity);
	            return "Password updated successfully";
	        } else {
	            return "Admin not found with email: ";
	        }
	    }
	   @Override
	    public Optional<Admin> getEmailAndPasswordById(Long id) {
	        return adminRepository.findById(id);
//	            .orElseThrow();
//	        return new Admin();
	    }
	   public List<Admin> getAllAdmins() {
	        return adminRepository.findAll();
	    }

	   @Override
	    public boolean authenticateAdmin(String email, String password) {
	        Admin admin = adminRepository.findByEmail(email);
	        
	        return admin != null && admin.getPassword().equals(password);
	    }

	    @Override
	    public Long authenticateAndGetId(String email, String password) {
	        Admin admin = adminRepository.findByEmail(email);
	        
	        if (admin != null && admin.getPassword().equals(password)) {
	            return admin.getId();
	        } else {
	            return null;
	        }
	    }

	    @Override
	    public Admin findById(Long adminId) {
	        return adminRepository.findById(adminId).orElse(null);
	    }

		@Override
		public Admin getAdminByEmail(String email) {
		    return adminRepository.findByEmail(email);
		}
		
		 @Override
		    public boolean doesEmailExist(String email) {
		        Admin admin = adminRepository.findByEmail(email);
		        return admin != null;
		    }


		 @Override
		 public boolean verifyOtp(String email, Long otp) {
		     Admin adminEntity = adminRepository.findByEmail(email);
		     if (adminEntity != null && adminEntity.getOtp() != null && adminEntity.getOtp().equals(otp)) {
		         return true;
		     } else {
		         // Otherwise, return false
		         return false;
		     }
		 }

		    
		    @Override
		    public void saveOtp(String email, Long otp) {
		        Admin adminEntity = adminRepository.findByEmail(email);
		        if (adminEntity != null) {
		            adminEntity.setOtp(otp); // Set the OTP for the admin entity
		            adminRepository.save(adminEntity); // Save the updated entity to the database
		        } else {
		            // Handle the case where the admin entity is not found
		            // You can log an error or throw an exception depending on your application's requirements
		        }
		    }

		    @Override
		    public String updateAdminPassword(String email, String newPassword) {
		        Admin adminEntity = adminRepository.findByEmail(email);
		        if (adminEntity != null) {
		            adminEntity.setPassword(newPassword);
		            adminEntity.setConfirmPassword(newPassword); // Update confirm password field
		            adminRepository.save(adminEntity);
		            return "Password updated successfully";
		        } else {
		            return "Admin not found with email: " + email;
		        }
		    }


		    @Override
		    public void updatePassword(String email, String newPassword) {
		        Admin adminEntity = adminRepository.findByEmail(email);
		        if (adminEntity != null) {
		            adminEntity.setPassword(newPassword);
		            adminEntity.setConfirmPassword(newPassword); // Update confirm password field
		            adminRepository.save(adminEntity);
		        } else {
		            throw new UserNotFoundException("User with email " + email + " not found");
		        }
		    }



}
