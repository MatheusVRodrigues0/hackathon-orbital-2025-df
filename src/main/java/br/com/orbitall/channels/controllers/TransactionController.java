package br.com.orbitall.channels.controllers;



import br.com.orbitall.channels.canonicals.CustomerOutput;
import br.com.orbitall.channels.canonicals.TransactionInput;
import br.com.orbitall.channels.canonicals.TransactionOutput;
import br.com.orbitall.channels.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transactions")

public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping
    public TransactionOutput create(@RequestBody @Valid TransactionInput input) {
        return service.create(input);
    }

    @GetMapping("/{id}")
    public List<TransactionOutput> retrieve(@PathVariable UUID id) {
        return service.retrieve(id);
    }
}
