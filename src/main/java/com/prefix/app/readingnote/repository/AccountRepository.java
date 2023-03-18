package com.prefix.app.readingnote.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prefix.app.readingnote.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByEmail(String email);
}
