package com.daironiq.petclinic.services;

import com.daironiq.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

}
