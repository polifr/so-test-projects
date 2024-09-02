package it.poli.predicate;

import it.poli.entity.InternalMessage;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class InternalMessageSpecification implements Specification<InternalMessage> {

  private static final long serialVersionUID = 8487122340618312663L;

  private final String search;

  public Predicate toPredicate(
      Root<InternalMessage> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    List<Predicate> predicates = new ArrayList<>();

    if (search == null || search.trim().isEmpty()) {
      // this part is causing me issue
      //      Expression<InternalMessage> parent = root.get("parent").as(InternalMessage.class);
      //      Predicate p = criteriaBuilder.isNull(parent);
      Predicate p = criteriaBuilder.isNull(root.get("parent"));
      predicates.add(p);
      query.distinct(true);
      return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    } else {
      // this part works
      return null;
    }
  }
}
