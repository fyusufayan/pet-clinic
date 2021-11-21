package com.daironiq.petclinic.bootstrap;

import com.daironiq.petclinic.model.*;
import com.daironiq.petclinic.services.OwnerService;
import com.daironiq.petclinic.services.PetTypeService;
import com.daironiq.petclinic.services.SpecialtyService;
import com.daironiq.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService,SpecialtyService specialtyService) {
        this.specialtyService=specialtyService;
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService=petTypeService;
    }

    //SpringContext tam olarak hazır olunca bu run çağırılıp. Load yapılır
    @Override
    public void run(String... args) throws Exception {

        int count=petTypeService.findAll().size();

        if (count==0){
            loadData();
        }



    }

    private void loadData() {
        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogPetType=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("Cat");
        PetType savedCatPetType=petTypeService.save(cat);

        Specialty radiology=new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology=specialtyService.save(radiology);

        Specialty surgery=new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery=specialtyService.save(surgery);

        Specialty dentistry=new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry=specialtyService.save(dentistry);

        Owner owner1=new Owner();
        //owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 brickarel");
        owner1.setCity("miami");
        owner1.setTelephone("12341234");

        Pet mikesPet=new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2=new Owner();
        //owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 brickarel");
        owner2.setCity("miami");
        owner2.setTelephone("12341234");

        Pet fionasCat=new Pet();
        fionasCat.setName("just cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1=new Vet();
        //vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2=new Vet();
        //vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
