package MappingDemo1.MappingDemo1.Controller;

import MappingDemo1.MappingDemo1.Model.Passport;
import MappingDemo1.MappingDemo1.Model.Person;
import MappingDemo1.MappingDemo1.PayLoad.PersonPassport;
import MappingDemo1.MappingDemo1.Service.Service;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonPassportController {

    @Autowired
    private Service service;

    @PostMapping("/saveData")
    public void saveInformation(@RequestBody PersonPassport temp){
        service.saveData(temp);
    }

    @GetMapping("/getData")
    public List<Person> getData(){
        return service.getData();
    }

    @GetMapping("/getPassportInformation")
    public List<Passport> getPassportInformation(){
        return service.getPassportInformation();
    }

    @PutMapping("/updatePassportNumber")
    public void updatePassportData(@RequestParam int pId,@RequestParam String pNumber){
        service.updatePassportNumber(pId,pNumber);
    }


    @GetMapping("/getPersonObject/{id}")
    public Person getPersonObject(@PathVariable int id){
        return service.getPersonDataById(id);
    }

    @PutMapping("/updatePassportCountry/{perId}/{country}")
    public void updatePassportCountry(@PathVariable int perId,@PathVariable String country){
        service.updatePassportCountry(perId,country);
    }

    @DeleteMapping("/deleteById/{perId}")
    public void deleteById(@PathVariable(name = "perId") int id){
        service.deleteById(id);
    }
}
