package kg.megacom.atm.mappers.base;

import java.util.HashSet;
import java.util.List;

public interface CrudMapper<E, D>{
    E toEntity(D d);
    D toDto(E e);
    List<E> toEntities(List<D> ds);
    HashSet<D> toDtos(List<E> es);
}