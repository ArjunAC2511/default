package com.admin.service;

import java.util.List;
import java.util.Optional;

import com.admin.entity.Admin;
import com.admin.entity.UpdatePasswordForm;

public interface AdminService {
    Optional<Admin> getAdminById(Long id);
    Admin updateAdminProfile(Long id, Admin admin);
//    Admin updateAdminProfile(Admin updatedAdmin);
    Admin addAdmin(Admin admin);
    public String login(String email, String password);
    String updateAdminPassword(String email, String newPassword); // Updated method signature
    Optional<Admin> getEmailAndPasswordById(Long id); 
    public List<Admin> getAllAdmins() ;
	boolean authenticateAdmin(String email, String password);
	Long authenticateAndGetId(String email, String password);
	Admin findById(Long adminId);
	void saveOtp(String email, Long otp);
	Admin getAdminByEmail(String email);
	boolean doesEmailExist(String email);
	boolean verifyOtp(String email, Long otp);
	void updatePassword(String email, String newPassword);
	String updateAdminPassword(UpdatePasswordForm request);
}