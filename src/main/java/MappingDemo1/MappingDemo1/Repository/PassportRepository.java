package MappingDemo1.MappingDemo1.Repository;

import MappingDemo1.MappingDemo1.Model.Passport;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport,Integer> {

    @Transactional
    @Modifying
    @Query("update Passport p set p.passportNumber=:pNumber where p.passportId=:pId")
    public void updatePassportNumber(@Param("pId") int pId,@Param("pNumber") String pNumber);


}
