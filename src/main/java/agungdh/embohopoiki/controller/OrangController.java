package agungdh.embohopoiki.controller;

import agungdh.embohopoiki.exception.ResourceNotFoundException;
import agungdh.embohopoiki.model.Orang;
import agungdh.embohopoiki.repository.OrangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class OrangController {

    @Autowired
    OrangRepository orangRepository;

    @GetMapping("/orangs")
    public List<Orang> getAllOrangs() {
        return orangRepository.findAll();
    }
    
    @PostMapping("/orangs")
    public Orang createOrang(@Valid @RequestBody Orang orang) {
        return orangRepository.save(orang);
    }
    
    @GetMapping("/orangs/{id}")
    public Orang getOrangById(@PathVariable(value = "id") Long orangId) {
        return orangRepository.findById(orangId)
                .orElseThrow(() -> new ResourceNotFoundException("Orang", "id", orangId));
    }
    
    @PutMapping("/orangs/{id}")
    public Orang updateOrang(@PathVariable(value = "id") Long orangId,
                                            @Valid @RequestBody Orang orangDetails) {

        Orang orang = orangRepository.findById(orangId)
                .orElseThrow(() -> new ResourceNotFoundException("Orang", "id", orangId));

        orang.setNama(orangDetails.getNama());
        orang.setUmur(orangDetails.getUmur());
        orang.setAlamat(orangDetails.getAlamat());

        Orang updatedOrang = orangRepository.save(orang);
        return updatedOrang;
    }
    
    @DeleteMapping("/orangs/{id}")
    public ResponseEntity<?> deleteOrang(@PathVariable(value = "id") Long orangId) {
        Orang orang = orangRepository.findById(orangId)
                .orElseThrow(() -> new ResourceNotFoundException("Orang", "id", orangId));

        orangRepository.delete(orang);

        return ResponseEntity.ok().build();
    }
}
