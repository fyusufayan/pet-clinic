package com.daironiq.petclinic.services.map;

import com.daironiq.petclinic.model.Specialty;
import com.daironiq.petclinic.model.Vet;
import com.daironiq.petclinic.services.SpecialtyService;
import com.daironiq.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    public Set<Vet> findAll() {
        return super.findAll();
    }

    public Vet findById(Long id) {
        return super.findById(id);
    }

    public Vet save(Vet object) {
        if (object.getSpecialties().size()>0){
            object.getSpecialties().forEach(specialty -> {
                if (specialty.getId()==null){
                    Specialty savedSpecialty=specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    public void delete(Vet object) {
        super.delete(object);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
