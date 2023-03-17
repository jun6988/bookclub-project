package com.prefix.app.modules.account.infra.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import com.prefix.app.modules.account.domain.entity.Account;

@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long>,
    QuerydslPredicateExecutor<Account> {

  boolean existsByEmail(String email);

  boolean existsByNickname(String nickname);
  
  //boolean existByPassword(String password);

  Account findByEmail(String email);

  Account findByNickname(String nickname);
  
  // Account findByPassword(String password);

  @EntityGraph(attributePaths = {"tags", "zones"})
  Account findAccountWithTagsAndZonesById(Long id);

  //june
  Account getReferenceById(String userId);
 
  UserDetails findById(String username);
}
