package ru.job4j.controller;

import org.springframework.web.bind.annotation.*;
import ru.job4j.domain.Passport;
import ru.job4j.service.ClientService;
import java.util.List;

public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public Passport save(Passport passport) {
        return clientService.save(passport);
    }

    public boolean update(int id, Passport passport) {
        return clientService.update(id, passport);
    }

    public boolean delete(@PathVariable int id) {
        return clientService.delete(id);
    }

    public List<Passport> findAll() {
        return clientService.findAll();
    }

    public List<Passport> findBySerial(int serial) {
        return clientService.findBySerial(serial);
    }

    public List<Passport> findNoValid() {
        return clientService.findNoValid();
    }

    public List<Passport> findReplaceable() {
        return clientService.findReplaceable();
    }
}
