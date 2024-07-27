package com.ems.api.service;

import java.util.List;

import com.ems.api.dto.BranchForm;
import com.ems.api.entity.BranchEntity;

public interface BranchService {

	public String saveBranch(Integer organizationId, BranchForm form);

	public List<BranchForm> getAllBranches();

	public BranchEntity updateBranch(Integer id, BranchEntity branchDetails) throws Exception;

	public BranchForm getBranchById(Integer branchId);

}
