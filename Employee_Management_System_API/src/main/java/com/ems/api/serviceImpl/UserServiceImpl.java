package com.ems.api.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ems.api.dto.LoginForm;
import com.ems.api.dto.UserDTO;
import com.ems.api.dto.UserResponse;
import com.ems.api.entity.BranchEntity;
import com.ems.api.entity.DepartmentEntity;
import com.ems.api.entity.DesignationEntity;
import com.ems.api.entity.OrganizationEntity;
import com.ems.api.entity.UserEntity;
import com.ems.api.exception.BadRequestException;
import com.ems.api.exception.InActiveException;
import com.ems.api.exception.InvalidException;
import com.ems.api.exception.NotFoundException;
import com.ems.api.repository.BranchRepository;
import com.ems.api.repository.DepartmentRepo;
import com.ems.api.repository.DesignationRepo;
import com.ems.api.repository.OrganizationRepo;
import com.ems.api.repository.UserRepository;
import com.ems.api.service.UserService;


import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private DesignationRepo roleRepository;
	@Autowired
	private BranchRepository branchRepository;
	@Autowired
	private DepartmentRepo departmentRepository;
	@Autowired
	private OrganizationRepo organizationRepository;

	private static final String UPLOAD_DIR = "uploads/";

	@PostConstruct
	public void init() {
		Path uploadPath = Paths.get(UPLOAD_DIR);
		if (!Files.exists(uploadPath)) {
			try {
				Files.createDirectories(uploadPath);
			} catch (IOException e) {
				throw new RuntimeException("Could not create upload directory", e);
			}
		}
	}

	@Override
	public UserResponse login(LoginForm login) {
		UserResponse response = new UserResponse();
		if (login.getUserName() != null && !login.getUserName().isEmpty() && login.getPassword() != null
				&& !login.getPassword().isEmpty()) {
			Optional<UserEntity> findByEmail = userRepo.findByEmail(login.getUserName());
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if (findByEmail.isEmpty()) {
				throw new NotFoundException("User not found. Please sign up.");
			} else if (!findByEmail.get().getIsActive()) {
				throw new InActiveException("User account is inactive. Please contact support.");
			} else if (passwordEncoder.matches(login.getPassword(), findByEmail.get().getPassword())) {
				BeanUtils.copyProperties(findByEmail.get(), response);
				return response;
			} else {
				throw new InvalidException("Invalid credentials. Please try again.");
			}
		}
		throw new BadRequestException("Invalid input. Please provide correct data.");
	}
	
	

	@Override
	public UserEntity saveUser(MultipartFile image, String firstName, String lastName, String phoneNumber, String email,
			String password, Boolean isActive, Boolean isDeleted, String createdBy, String updatedBy, Integer roleId,
			Integer branchId, Integer departmentId, Integer organizationId) throws IOException {
		UserEntity user = new UserEntity();
		if (image != null && !image.isEmpty()) {
			String fileName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
			Path imagePath = Paths.get(UPLOAD_DIR, fileName);
			Files.write(imagePath, image.getBytes());
			user.setImage(fileName);
		}

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(password));

		user.setIsActive(isActive);
		user.setIsDeleted(isDeleted);

		user.setCreatedBy(createdBy);
		user.setUpdatedBy(updatedBy);
		user.setCreatedDate(LocalDateTime.now());
		user.setUpdatedDate(LocalDateTime.now());

		DesignationEntity role = roleRepository.findById(roleId)
				.orElseThrow(() -> new RuntimeException("Role not found"));
		BranchEntity branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new RuntimeException("Branch not found"));
		DepartmentEntity department = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new RuntimeException("Department not found"));
		OrganizationEntity organization = organizationRepository.findById(organizationId)
				.orElseThrow(() -> new RuntimeException("Organization not found"));

		user.setRole(role);
		user.setBranch(branch);
		user.setDepartment(department);
		user.setOrganization(organization);
		return userRepo.save(user);
	}

	@Override
	public UserEntity updateUser(Integer userId, MultipartFile image, String firstName, String lastName,
			String phoneNumber, String email, String password, Boolean isActive, Boolean isDeleted, String updatedBy,
			Integer roleId, Integer branchId, Integer departmentId, Integer organizationId) throws IOException {
		UserEntity user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		if (image != null && !image.isEmpty()) {
			String fileName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
			Path imagePath = Paths.get(UPLOAD_DIR, fileName);
			Files.write(imagePath, image.getBytes());
			user.setImage(fileName);
		}

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		if (password != null && !password.isEmpty()) {
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			user.setPassword(passwordEncoder.encode(password));
		}

		user.setIsActive(isActive);
		user.setIsDeleted(isDeleted);
		user.setUpdatedBy(updatedBy);
		user.setUpdatedDate(LocalDateTime.now());

		DesignationEntity role = roleRepository.findById(roleId)
				.orElseThrow(() -> new RuntimeException("Role not found"));
		BranchEntity branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new RuntimeException("Branch not found"));
		DepartmentEntity department = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new RuntimeException("Department not found"));
		OrganizationEntity organization = organizationRepository.findById(organizationId)
				.orElseThrow(() -> new RuntimeException("Organization not found"));

		user.setRole(role);
		user.setBranch(branch);
		user.setDepartment(department);
		user.setOrganization(organization);
		return userRepo.save(user);
	}

	@Override
	public UserDTO getUserById(Integer userId) {
	    UserEntity user = userRepo.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));
	    return new UserDTO(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
	    List<UserEntity> users = userRepo.findAll();
	    return users.stream().map(UserDTO::new).collect(Collectors.toList());
	}

	
	@Override
	public String deleteUserById(Integer userId) {
		if (!userRepo.existsById(userId)) {
			throw new RuntimeException("User not found");
		}
		userRepo.deleteById(userId);
		return "User with ID " + userId + " has been deleted successfully.";
	}
}
