package ru.com.first.pochta.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.com.first.pochta.exception.ResourceNotFoundException;
import ru.com.first.pochta.model.Couriers;
import ru.com.first.pochta.repository.CouriersRepository;

@RestController
@RequestMapping("/")
public class CouriersController {
    @Autowired
    private CouriersRepository CouriersRepository;

    @GetMapping("/courier")
    public List<Couriers> getAllCourierss() {
        return CouriersRepository.findAll();
    }

    @GetMapping("/couriers/{id}")
    public ResponseEntity<Couriers> getCouriersById(@PathVariable(value = "id") Long CouriersId)
        throws ResourceNotFoundException {
        Couriers Couriers = CouriersRepository.findById(CouriersId)
          .orElseThrow(() -> new ResourceNotFoundException("Couriers not found for this id :: " + CouriersId));
        return ResponseEntity.ok().body(Couriers);
    }
    
    @PostMapping("/couriers")
    public Couriers createCouriers(@Valid @RequestBody Couriers Couriers) {
        return CouriersRepository.save(Couriers);
    }

    @PutMapping("/couriersput/{id}")
    public ResponseEntity<Couriers> updateCouriers(@PathVariable(value = "id") Long CouriersId,
         @Valid @RequestBody Couriers CouriersDetails) throws ResourceNotFoundException {
        Couriers Couriers = CouriersRepository.findById(CouriersId)
        .orElseThrow(() -> new ResourceNotFoundException("Couriers not found for this id :: " + CouriersId));

        Couriers.setId(CouriersDetails.getId());
        Couriers.setTrack(CouriersDetails.getTrack());
        Couriers.setAddress(CouriersDetails.getAddress());
        final Couriers updatedCouriers = CouriersRepository.save(Couriers);
        return ResponseEntity.ok(updatedCouriers);
    }

    @DeleteMapping("/couriersdel/{id}")
    public Map<String, Boolean> deleteCouriers(@PathVariable(value = "id") Long CouriersId)
         throws ResourceNotFoundException {
        Couriers Couriers = CouriersRepository.findById(CouriersId)
       .orElseThrow(() -> new ResourceNotFoundException("Couriers not found for this id :: " + CouriersId));

        CouriersRepository.delete(Couriers);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
