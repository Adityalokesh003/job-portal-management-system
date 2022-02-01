package com.jpms.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpms.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	// need to inject the session factory
	@Autowired
	private EntityManager entityManager;

	@Override
	public Role findRoleByName(String theRoleName) {

		// now retrieve/read from database using name
		TypedQuery<Role> theQuery = entityManager.createQuery("from Role where name=:roleName", Role.class);
		theQuery.setParameter("roleName", theRoleName);

		Role theRole = null;

		try {
			theRole = theQuery.getSingleResult();
		} catch (Exception e) {
			theRole = null;
		}

		return theRole;
	}
}
