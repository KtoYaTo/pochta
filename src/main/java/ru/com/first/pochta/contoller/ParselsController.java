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
import ru.com.first.pochta.model.Parsels;
import ru.com.first.pochta.repository.ParselsRepository;

@RestController
@RequestMapping("/")
public class ParselsController {
    @Autowired
    private ParselsRepository ParselsRepository;

    @GetMapping("/parsels")
    public List<Parsels> getAllParselss() {
        return ParselsRepository.findAll();
    }

    @GetMapping("/parsels/{id}")
    public ResponseEntity<Parsels> getParselsById(@PathVariable(value = "id") Long ParselsId)
        throws ResourceNotFoundException {
        Parsels Parsels = ParselsRepository.findById(ParselsId)
          .orElseThrow(() -> new ResourceNotFoundException("Parsels not found for this id :: " + ParselsId));
        return ResponseEntity.ok().body(Parsels);
    }
    
    @PostMapping("/parsels")
    public Parsels createParsels(@Valid @RequestBody Parsels Parsels) {
        return ParselsRepository.save(Parsels);
    }

    @PutMapping("/parsels/{id}")
    public ResponseEntity<Parsels> updateParsels(@PathVariable(value = "id") Long ParselsId,
         @Valid @RequestBody Parsels ParselsDetails) throws ResourceNotFoundException {
        Parsels Parsels = ParselsRepository.findById(ParselsId)
        .orElseThrow(() -> new ResourceNotFoundException("Parsels not found for this id :: " + ParselsId));

        Parsels.setId(ParselsDetails.getId());
        Parsels.setTrack(ParselsDetails.getTrack());
        Parsels.setAddress(ParselsDetails.getAddress());
        final Parsels updatedParsels = ParselsRepository.save(Parsels);
        return ResponseEntity.ok(updatedParsels);
    }

    @DeleteMapping("/parsels/{id}")
    public Map<String, Boolean> deleteParsels(@PathVariable(value = "id") Long ParselsId)
         throws ResourceNotFoundException {
        Parsels Parsels = ParselsRepository.findById(ParselsId)
       .orElseThrow(() -> new ResourceNotFoundException("Parsels not found for this id :: " + ParselsId));

        ParselsRepository.delete(Parsels);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
