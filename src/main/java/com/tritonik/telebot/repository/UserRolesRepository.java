package com.tritonik.telebot.repository;

import com.tritonik.telebot.model.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRolesRepository extends CrudRepository<UserRole, Long> {
}