package com.daironiq.petclinic.services.map;

import com.daironiq.petclinic.model.Owner;
import com.daironiq.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    public Set<Owner> findAll() {
        return super.findAll();
    }

    public Owner findById(Long id) {
        return super.findById(id);
    }

    public Owner save(Owner object) {
        return super.save(object);
    }

    public void delete(Owner object) {
        super.delete(object);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
