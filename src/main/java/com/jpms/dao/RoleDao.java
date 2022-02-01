package com.jpms.dao;

import com.jpms.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);

}
