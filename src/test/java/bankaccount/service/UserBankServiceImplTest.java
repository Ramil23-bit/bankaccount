package bankaccount.service;

import org.example.bankaccount.entity.UserBank;
import org.example.bankaccount.exception.UserBankIncorrectData;
import org.example.bankaccount.exception.UserNotFoundException;
import org.example.bankaccount.repository.UserBankJpaRepository;
import org.example.bankaccount.service.UserBankServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserBankServiceImplTest {
    @Mock
    private UserBankJpaRepository userBankJpaRepository;
    @InjectMocks
    private UserBankServiceImpl userBankService;

    @Test
    public void getByIdWhenIdCorrected(){
        Long id = 2L;
        UserBank userBankExpected = new UserBank();
        userBankExpected.setId(id);

        Mockito.when(userBankJpaRepository.findById(id))
                .thenReturn(Optional.of(userBankExpected));

        UserBank userBankActual = userBankService.getById(id);
        Assertions.assertEquals(userBankExpected, userBankActual);
    }

    @Test
    public void getByIdWhenIdIncorrect(){
        Long id = 2L;
        Mockito.when(userBankJpaRepository.findById(id))
                .thenThrow(new UserNotFoundException("User Not Found"));

        Assertions.assertThrows(UserNotFoundException.class,
                ()->userBankService.getById(id));
    }

    @Test
    public void createUserBankWhenIncorrectData(){
        UserBank userBank = new UserBank();
        userBank.setId(2L);
        userBank.setName("Igor");
        userBank.setLogin("Igor12");
        userBank.setEmail("igor@igor.com");

        Mockito.when(userBankJpaRepository.save(userBank))
                .thenThrow(new UserBankIncorrectData("Incomplete data entered"));

        Assertions.assertThrows(UserBankIncorrectData.class,
                ()->userBankService.create(userBank));
    }

    @Test
    public void createUserBankWhenCorrectData(){
        UserBank userBank = new UserBank();
        userBank.setId(2L);
        userBank.setName("Igor");
        userBank.setLogin("Igor12");
        userBank.setEmail("igor@igor.com");
        userBank.setPassword("12451");

        Mockito.when(userBankJpaRepository.save(userBank))
                .thenReturn(userBank);

        UserBank userBankActual = userBankService.create(userBank);

        Assertions.assertEquals(userBank, userBankActual);
    }

    @Test
    public void deleteByIdWhenCorrectId(){
        Long id = 3L;

        userBankService.deleteById(id);

        verify(userBankJpaRepository, times(1)).deleteById(id);
    }

    @Test
    public void deleteByIdWhenIncorrectId(){
        Long id = 3L;
        doThrow(new UserNotFoundException("User Bank not Found")).when(userBankJpaRepository).deleteById(id);

        Assertions.assertThrows(UserNotFoundException.class,
                ()->userBankService.deleteById(id));
    }
}
