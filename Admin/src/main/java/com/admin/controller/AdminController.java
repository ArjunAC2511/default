package com.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import com.admin.binding.ForgotBinding;
import com.admin.binding.ResetPasswordRequest;
import com.admin.binding.VerificationRequest;
import com.admin.entity.Admin;
import com.admin.entity.UpdatePasswordForm;
//import com.admin.entity.User;
import com.admin.exception.UserNotFoundException;
import com.admin.repo.AdminRepository;
import com.admin.service.AdminService;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private AdminRepository adminrepo;
    
    @Autowired
    private JavaMailSender emailSender;

    @GetMapping("/profile/{id}")
    public Optional<Admin> getAdminProfile(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }
    
    @PostMapping("/update-profile/{id}")
    public ResponseEntity<Admin> updateAdminProfile(@PathVariable Long id, @RequestBody Admin admin) {
        Admin updatedAdmin = adminService.updateAdminProfile(id, admin);
        return ResponseEntity.ok(updatedAdmin);
    }

//    @PostMapping("/update-profile")
//    public Admin updateAdminProfile(@RequestBody Admin updatedAdmin) {
//        return adminService.updateAdminProfile(updatedAdmin);
//    }

    @PostMapping("/addadmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }

    @GetMapping("/logout")
    public String logout() {
        return "Logout successful";
    }
//    @PostMapping("/loginadmin")
//    public String login(@RequestBody Admin loginAdmin) {
//        return adminService.login(loginAdmin.getEmail(), loginAdmin.getPassword());
//    }
    
    @PostMapping("/loginadmin")
    public ResponseEntity<?> login(@RequestBody Admin loginAdmin) {
    	boolean isAuthenticated = adminService.authenticateAdmin(loginAdmin.getEmail(), loginAdmin.getPassword());
    	
    	if (isAuthenticated) {
    		Long Id = adminService.authenticateAndGetId(loginAdmin.getEmail(), loginAdmin.getPassword());
    		if (Id != null) {
    			return ResponseEntity.ok(Id);
    		} else {
    			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Retrieving Id");
    		}
    	} else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }
    }   
    
//    @PutMapping("/adminupdatePassword")
//    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordForm request) {
//        String email = request.getEmail();
//        String newPassword = request.getPassword();
//        if (email == null || newPassword == null) {
//            return ResponseEntity.badRequest().body("Email and newPassword must be provided.");
//        }
//
//        String result = adminService.updateAdminPassword(request);
//        return ResponseEntity.ok(result);
//    }
    
    @PostMapping("/send-reset-email")
    public ResponseEntity<String> sendResetEmail(@RequestBody ForgotBinding forgotBinding) {
        try {
            Admin user = adminService.getAdminByEmail(forgotBinding.getEmail());
            if (user == null) {
                return new ResponseEntity<>("Email not found", HttpStatus.NOT_FOUND);
            }

            Long otp = generateOTP();

            sendEmail(forgotBinding.getEmail(), otp);

            adminService.saveOtp(forgotBinding.getEmail(), otp);

            return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void sendEmail(String email, Long otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset OTP");
        message.setText("Your one-time password (OTP) for password reset is: " + otp);
        emailSender.send(message);
    }



    

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody VerificationRequest request) {
        try {
            boolean isOtpValid = adminService.verifyOtp(request.getEmail(), request.getOtp());
            if (isOtpValid) {
                return new ResponseEntity<>("OTP verified successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid OTP", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // Log the exception details for debugging
            e.printStackTrace();
            return new ResponseEntity<>("Error verifying OTP", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    private Long generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // Generates a random number between 100000 and 999999
        return Long.valueOf(otp);
    }
    
   


    
 
	@GetMapping("/admin/{id}/credentials")
    public Optional<Admin> getEmailAndPasswordById(@PathVariable Long id) {
        return adminService.getEmailAndPasswordById(id);
//        return new ResponseEntity<>(admin, HttpStatus.OK);
    }
	
	
    @GetMapping("/All")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }
    
    @PutMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {
        try {
            adminService.updatePassword(request.getEmail(), request.getNewPassword());
            return ResponseEntity.ok("Password updated successfully");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found with email: " + request.getEmail());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update password");
        }
    }


    // Method to update password in the database (replace this with your actual database logic)
    private boolean updatePasswordInDatabase(String email, String newPassword) {
        return true;
    }


    
}
