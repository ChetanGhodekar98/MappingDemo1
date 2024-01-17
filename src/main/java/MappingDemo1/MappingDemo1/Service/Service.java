package MappingDemo1.MappingDemo1.Service;

import MappingDemo1.MappingDemo1.Model.Passport;
import MappingDemo1.MappingDemo1.Model.Person;
import MappingDemo1.MappingDemo1.PayLoad.PersonPassport;
import MappingDemo1.MappingDemo1.Repository.PassportRepository;
import MappingDemo1.MappingDemo1.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PassportRepository passportRepository;
    public void saveData(PersonPassport temp){
        Person p1=new Person();

        Passport pass=new Passport();

        p1.setPersonName(temp.getPersonName());
        p1.setPersonAge(temp.getPersonAge());
        p1.setPersonSalary(temp.getPersonSalary());

        pass.setPassportNumber(temp.getPassportNumber());
        pass.setPassportCountry(temp.getPassportCountry());

        p1.setPassportRef(pass);

        personRepository.save(p1);
    }

    public List<Person> getData(){
       return personRepository.findAll();
    }

    public List<Passport> getPassportInformation(){
        return passportRepository.findAll();
    }

    public void updatePassportNumber(int  passportId,String passportNumber){
        passportRepository.updatePassportNumber(passportId,passportNumber);
    }
    public Person getPersonDataById(int id){
        return personRepository.getPersonObject(id);
    }
    public void updatePassportCountry(int perId,String country){
        Person p=personRepository.getPersonObject(perId);
        Passport pass=p.getPassportRef();
        pass.setPassportCountry(country);
        personRepository.save(p);
    }

    public void deleteById(int id){
        Person person=personRepository.getPersonObject(id);
        if(person!=null) {
            Passport passport = person.getPassportRef();
            personRepository.delete(person);
            passportRepository.delete(passport);
        }
    }
}
