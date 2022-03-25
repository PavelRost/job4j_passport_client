package ru.job4j.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import ru.job4j.domain.Passport;

import java.util.Collections;
import java.util.List;

@Repository
public class PassportRepository {

    private final RestTemplate rest;

    public PassportRepository(RestTemplate rest) {
        this.rest = rest;
    }

    @Value("${api-url}")
    private String url;

    public Passport save(Passport passport) {
        return rest.postForEntity(
                String.format("%s/save", url),
                passport,
                Passport.class
        ).getBody();
    }

    public boolean update(int id, Passport passport) {
        return rest.exchange(
                String.format("%s/update/%s", url, id),
                HttpMethod.PUT,
                new HttpEntity<>(passport),
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    public boolean delete(@PathVariable int id) {
        return rest.exchange(
                String.format("%s/delete/%s", url, id),
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    public List<Passport> findAll() {
        return getList(String.format(
                "%s/findAll", url
        ));
    }

    public List<Passport> findBySerial(int serial) {
        return getList(String.format(
                "%s/findBySerial/%s", url, serial
        ));
    }

    public List<Passport> findNoValid() {
        return getList(String.format(
                "%s/findPassNoValid", url
        ));
    }

    public List<Passport> findReplaceable() {
        return getList(String.format(
                "%s/findPassReplaceable", url
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
