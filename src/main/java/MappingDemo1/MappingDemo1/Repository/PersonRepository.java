package MappingDemo1.MappingDemo1.Repository;

import MappingDemo1.MappingDemo1.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Query(value = "select * from person where person_id=:perId",nativeQuery = true)
    public Person getPersonObject(@Param("perId") int perId);
}
