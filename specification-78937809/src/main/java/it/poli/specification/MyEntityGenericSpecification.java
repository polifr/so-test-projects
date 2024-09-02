package it.poli.specification;

import it.poli.entity.MyEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class MyEntityGenericSpecification<T> implements Specification<MyEntity> {

  private static final long serialVersionUID = 5142379341911056096L;

  private final String columnName;
  private final T searchTerm;

  @Override
  public Predicate toPredicate(
      Root<MyEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

    Path<T> field = root.<T>get(this.columnName);
    Class<? extends T> javaType = field.getJavaType();

    if (javaType.isAssignableFrom(String.class)) {
      return criteriaBuilder.like(
          criteriaBuilder.lower(root.<String>get(this.columnName)),
          "%" + this.searchTerm.toString().toLowerCase() + "%");
    } else if (javaType.isAssignableFrom(LocalDate.class)) {
      return criteriaBuilder.equal(field, searchTerm);
    }

    return criteriaBuilder.and();
  }
}
