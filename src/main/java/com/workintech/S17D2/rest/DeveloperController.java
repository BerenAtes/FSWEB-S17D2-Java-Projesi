package com.workintech.S17D2.rest;


import com.workintech.S17D2.dto.DeveloperResponse;
import com.workintech.S17D2.model.Developer;
import com.workintech.S17D2.model.DeveloperFactory;
import com.workintech.S17D2.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
    private Map<Integer, Developer> developers;
    private Taxable taxable;

    @Autowired
    public DeveloperController(Taxable taxable) {
        this.taxable = taxable;
    }

    @PostConstruct
    public void init(){
    developers=new HashMap<>();
    }

    @PostMapping
    @ResponseStatus
    public DeveloperResponse save(@RequestBody Developer developer){
    Developer createdDeveloper= DeveloperFactory.createDeveloper(developer,taxable);
    if (Objects.nonNull(createdDeveloper)){
        developers.put(developer.getId(),createdDeveloper);
    }
        return new DeveloperResponse("create succesfull",createdDeveloper.getId(),createdDeveloper.getName(),createdDeveloper.getSalary(),createdDeveloper.getExperience());
    }

    @GetMapping
    public List<Developer> getAll(){
        return developers.values().stream().toList();
    }

    @GetMapping("/{id}")
    public DeveloperResponse get(@PathVariable Integer id){
        Developer developer=developers.get(id);
        if (Objects.isNull(developer)){
            return new DeveloperResponse("developer is not found with given id"+ id,id,null,null,null);
        }
        return new DeveloperResponse("get succesfull",developer.getId(),developer.getName(),developer.getSalary(),developer.getExperience());
    }


    @PutMapping("/{id}")
    public DeveloperResponse update(@PathVariable Integer id,@RequestBody Developer developer){
        if (Objects.isNull(developer)){
            return new DeveloperResponse("new developer is not valid",null,null,null,null);
        }
        Developer found=developers.get(id);
        if (Objects.isNull(found)){
            return new DeveloperResponse("new developer is not valid",null,null,null,null);
        }
        Developer updatedDeveloper= DeveloperFactory.createDeveloper(developer,taxable);
        this.developers.put(id,updatedDeveloper);
        return new DeveloperResponse("update success",id,updatedDeveloper.getName(),updatedDeveloper.getSalary(),updatedDeveloper.getExperience());
    }



    @DeleteMapping("/{id}")
    public DeveloperResponse delete(@PathVariable Integer id){
        Developer developer=developers.get(id);
        if (Objects.isNull(developer)){
            return new DeveloperResponse("developer is not found with given id"+ id,id,null,null,null);
        }
        developers.remove(id);
        return new DeveloperResponse("get succesfull",developer.getId(),developer.getName(),developer.getSalary(),developer.getExperience());
    }



}
