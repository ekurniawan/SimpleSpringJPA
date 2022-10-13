package com.rapidtech.springdatajpapgsql.repository;

import com.rapidtech.springdatajpapgsql.model.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDaoRepository extends JpaRepository<DAOUser,Long> {
    DAOUser findByUsername(String username);
}
