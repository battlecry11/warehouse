package ge.softlab.warehouse.controller;

import ge.softlab.warehouse.exceptions.NotFoundException;
import ge.softlab.warehouse.model.Provider;
import ge.softlab.warehouse.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("providers")
@RequiredArgsConstructor
public class ProviderController {
    private final ProviderRepository providerRepository;

    @GetMapping
    public List<Provider> getProviders() {
        return providerRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Provider> addProvider(@RequestBody Provider provider) {
        provider.setId(null);
        providerRepository.save(provider);
        return ResponseEntity.status(HttpStatus.CREATED).body(provider);

    }

    @PutMapping("{id}")
    public Provider updateProvider(@PathVariable long id, @RequestBody Provider unsafeTask) {
        Provider provider = getProvider(id);
        provider.setProvider(unsafeTask.getProvider());
        return providerRepository.save(provider);
    }

    @GetMapping("{id}")
    public Provider getProvider(@PathVariable long id) {
        return providerRepository.findById(id).orElseThrow(() -> new NotFoundException("Task Not Found"));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable long id) {
        Provider task = getProvider(id);
        providerRepository.delete(task);
        return ResponseEntity.noContent().build();

    }
}