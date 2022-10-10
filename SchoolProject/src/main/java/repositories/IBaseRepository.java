package repositories;

import java.util.List;
import java.util.Optional;

public interface IBaseRepository<T, CODE>{

    /**
     * Saves a given entity.
     *
     * @param entity must not be {@literal null}.
     * @return the saved entity; will never be {@literal null}.
     * @throws IllegalArgumentException in case the given {@literal entity} is {@literal null}.
     */
    <S extends T> S save(S entity);

    /**
     * Retrieves an entity by its code.
     *
     * @param code must not be {@literal null}.
     * @return the entity with the given code or {@literal Optional#empty()} if none found.
     * @throws IllegalArgumentException if {@literal code} is {@literal null}.
     */
    Optional<T> findByCode(CODE code);

    /**
     * Returns whether an entity with the given code exists.
     *
     * @param code must not be {@literal null}.
     * @return {@literal true} if an entity with the given code exists, {@literal false} otherwise.
     * @throws IllegalArgumentException if {@literal code} is {@literal null}.
     */
    boolean existsByCode(CODE code);

    /**
     * Returns all instances of the type.
     * @return all entities
     */
    List<T> findAll();

    /**
     * Delete a given entity.
     *
     * @param entity must not be {@literal null}.
     * @return the delete entity; will never be {@literal null}.
     * @throws IllegalArgumentException in case the given {@literal entity} is {@literal null}.
     */
    <S extends T> S delete(S entity);

}
