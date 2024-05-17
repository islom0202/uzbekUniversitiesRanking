package univerranking.uz.univerranking.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import univerranking.uz.univerranking.Entity.UniversityData;
import univerranking.uz.univerranking.Entity.UniversityType;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UniversitySearchDao {

    private final EntityManager entityManager;
    public List<UniversityData> findAllBySimpleQuery(
            String name,
            String city,
            String subject,
            UniversityType type
    ) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UniversityData> query = cb.createQuery(UniversityData.class);

        Root<UniversityData> root = query.from(UniversityData.class);
        List<Predicate> predicates = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            Predicate namePredicate = cb.like(root.get("name"), "%" + name + "%");
            predicates.add(namePredicate);
        }

        if (city != null && !city.isEmpty()) {
            Predicate cityPredicate = cb.like(root.get("city"), "%" + city + "%");
            predicates.add(cityPredicate);
        }

        if (subject != null && !subject.isEmpty()) {
            Predicate subjectPredicate = cb.like(root.get("subject"), "%" + subject + "%");
            predicates.add(subjectPredicate);
        }

        if (type != null) {
            Predicate typePredicate = cb.equal(root.get("type"), type);
            predicates.add(typePredicate);
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        TypedQuery<UniversityData> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
