package ru.job4j.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.job4j.domain.Passport;
import ru.job4j.repository.PassportRepository;

import java.util.Collections;
import java.util.List;

@Service
public class ClientService {

    private final PassportRepository passportRepository;

    public ClientService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public Passport save(Passport passport) {
        return passportRepository.save(passport);
    }

    public boolean update(int id, Passport passport) {
        return passportRepository.update(id, passport);
    }

    public boolean delete(@PathVariable int id) {
        return passportRepository.delete(id);
    }

    public List<Passport> findAll() {
        return passportRepository.findAll();
    }

    public List<Passport> findBySerial(int serial) {
        return passportRepository.findBySerial(serial);
    }

    public List<Passport> findNoValid() {
        return passportRepository.findNoValid();
    }

    public List<Passport> findReplaceable() {
        return passportRepository.findNoValid();
    }
}
