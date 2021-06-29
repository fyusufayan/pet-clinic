package com.daironiq.petclinic.services.map;

import com.daironiq.petclinic.model.Owner;
import com.daironiq.petclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements CrudService<Owner,Long> {

    public Set<Owner> findAll() {
        return super.findAll();
    }

    public Owner findById(Long id) {
        return super.findById(id);
    }

    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }

    public void delete(Owner object) {
        super.delete(object);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
