package ru.aveskin.petclinic.security.mapper;

public interface Mapper<D, S> {
    D map(S source);
}
