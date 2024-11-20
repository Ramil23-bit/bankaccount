package org.example.bankaccount.repository;

import org.example.bankaccount.entity.UserBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBankJpaRepository extends JpaRepository<UserBank, Long> {
}
