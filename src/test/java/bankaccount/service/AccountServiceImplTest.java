package bankaccount.service;

import org.example.bankaccount.entity.Account;
import org.example.bankaccount.enums.CurrencyType;
import org.example.bankaccount.exception.AccountIncorrectData;
import org.example.bankaccount.exception.AccountNotFoundException;
import org.example.bankaccount.repository.AccountJpaRepository;
import org.example.bankaccount.service.AccountServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {
    @Mock
    private AccountJpaRepository accountJpaRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    public void getByIdWhenIdCorrected(){
        Long id = 3L;
        Account accountExpected = new Account();
        accountExpected.setId(id);
        when(accountJpaRepository.findById(id))
                .thenReturn(Optional.of(accountExpected));

        Account accountActual = accountService.getById(id);
        Assertions.assertEquals(accountExpected.getId(), accountActual.getId());
    }

    @Test
    public void getByIdWhenIdNotFound(){
        Long id = 3L;
        when(accountJpaRepository.findById(id))
                .thenThrow(new AccountNotFoundException("Account bot Found"));
        Assertions.assertThrows(AccountNotFoundException.class,
                () -> accountService.getById(id));
    }

    @Test
    public void createAccountWhenEnteredNotCompletedData(){
        Account accountExpected = new Account();
        BigDecimal amount = new BigDecimal(623);
        accountExpected.setId(1L);
        accountExpected.setAmount(amount);
        accountExpected.setCurrencyType(CurrencyType.USD);

        when(accountJpaRepository.save(accountExpected))
                .thenThrow(new AccountIncorrectData("Not all account information has been entered"));

        Assertions.assertThrows(AccountIncorrectData.class,
                ()->accountService.create(accountExpected));
    }

    @Test
    public void createAccountWhenCorrectedData(){
        Account accountExpected = new Account();
        BigDecimal amount = new BigDecimal(623);
        accountExpected.setId(1L);
        accountExpected.setNumber(184203L);
        accountExpected.setAmount(amount);
        accountExpected.setCurrencyType(CurrencyType.USD);

        when(accountJpaRepository.save(accountExpected))
                .thenReturn(accountExpected);

        Account accountActual = accountService.create(accountExpected);
        Assertions.assertEquals(accountExpected, accountActual);
    }

    @Test
    public void deleteByIdWhenIdIncorrect(){
        Long id = 3L;
        doThrow(new AccountNotFoundException("Account not Found")).when(accountJpaRepository).deleteById(id);

        Assertions.assertThrows(AccountNotFoundException.class,
                ()-> accountService.delete(id));
    }

    @Test
    public void deleteByIdWhenCorrectId(){
        Long id = 3L;

        accountService.delete(id);

        verify(accountJpaRepository, times(1)).deleteById(id);
    }
}
