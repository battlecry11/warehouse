package ge.softlab.warehouse.controller;

import ge.softlab.warehouse.exceptions.NotFoundException;
import ge.softlab.warehouse.model.Store;
import ge.softlab.warehouse.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stores")
@RequiredArgsConstructor
public class StoreController {
    private final StoreRepository storeRepository;

    @GetMapping
    public List<Store> getStores() {
        return storeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Store> addStore(@RequestBody Store store) {
        store.setId(null);
        storeRepository.save(store);
        return ResponseEntity.status(HttpStatus.CREATED).body(store);

    }

    @PutMapping("{id}")
    public Store updateStore(@PathVariable long id, @RequestBody Store unsafeStore) {

        return storeRepository.save(unsafeStore);
    }

    @GetMapping("{id}")
    public Store getStore(@PathVariable long id) {
        return storeRepository.findById(id).orElseThrow(() -> new NotFoundException("Task Not Found"));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable long id) {
        Store task = getStore(id);
        storeRepository.delete(task);
        return ResponseEntity.noContent().build();

    }
}