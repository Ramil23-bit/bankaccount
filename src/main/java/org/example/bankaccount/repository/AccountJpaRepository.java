package org.example.bankaccount.repository;

import org.example.bankaccount.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Long> {


}
