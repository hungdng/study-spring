package hung.tran.studyspring.bootstrap;

import hung.tran.studyspring.model.*;
import hung.tran.studyspring.service.OwnerService;
import hung.tran.studyspring.service.PetTypeService;
import hung.tran.studyspring.service.SpecialtyService;
import hung.tran.studyspring.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService){

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Hung");
        owner1.setLastName("Tran");
        owner1.setCity("Da Nang");
        owner1.setAddress("K137 Le Van Hien");
        owner1.setTelephone("0777505153");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Dinh");
        owner2.setLastName("Phan");
        owner2.setCity("Hue");
        owner2.setAddress("123 Van Tien Dung");
        owner2.setTelephone("077345987");

        Pet finosCat = new Pet();
        finosCat.setName("Just Cat");
        finosCat.setPetType(saveCatPetType);
        finosCat.setBirthDate(LocalDate.now());
        finosCat.setOwner(owner2);
        owner2.getPets().add(finosCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Lich");
        vet1.setLastName("Ho");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tan");
        vet2.setLastName("Le");
        vet1.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets......");

        vetService.save(vet2);
    }
}
