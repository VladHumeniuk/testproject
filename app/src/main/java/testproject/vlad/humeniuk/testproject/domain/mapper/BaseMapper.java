package testproject.vlad.humeniuk.testproject.domain.mapper;

public interface BaseMapper<E, T> {

    T map(E entity);
}
