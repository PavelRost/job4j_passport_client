package ru.job4j.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.job4j.domain.Passport;
import java.util.Collections;
import java.util.List;


public class ClientController {

    private RestTemplate rest;

    public ClientController(RestTemplate rest) {
        this.rest = rest;
    }

    private static final String API = "http://localhost:8080/api/passport";

    public Passport save(Passport passport) {
        return rest.postForEntity(
                String.format("%s/save", API),
                passport,
                Passport.class
        ).getBody();
    }

    public boolean update(int id, Passport passport) {
        return rest.exchange(
                String.format("%s/update/%s", API, id),
                HttpMethod.PUT,
                new HttpEntity<>(passport),
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    public boolean delete(@PathVariable int id) {
        return rest.exchange(
                String.format("%s/delete/%s", API, id),
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    public List<Passport> findAll() {
        return getList(String.format(
                "%s/findAll", API
        ));
    }

    public List<Passport> findBySerial(int serial) {
        return getList(String.format(
                "%s/findBySerial/%s", API, serial
        ));
    }

    public List<Passport> findNoValid() {
        return getList(String.format(
                "%s/findPassNoValid", API
        ));
    }

    public List<Passport> findReplaceable() {
        return getList(String.format(
                "%s/findPassReplaceable", API
        ));
    }

    private List<Passport> getList(String url) {
        List<Passport> body = rest.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Passport>>() {
                }
        ).getBody();
        return body == null ? Collections.emptyList() : body;
    }

}
