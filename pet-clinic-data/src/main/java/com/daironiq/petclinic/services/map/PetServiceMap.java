package com.daironiq.petclinic.services.map;

import com.daironiq.petclinic.model.Pet;
import com.daironiq.petclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet,Long> implements CrudService<Pet,Long> {

    public Set<Pet> findAll() {
        return super.findAll();
    }

    public Pet findById(Long id) {
        return super.findById(id);
    }

    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }

    public void delete(Pet object) {
        super.delete(object);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
