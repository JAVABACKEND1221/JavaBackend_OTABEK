package uz.otash.spring.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.otash.spring.model.TransactionApp;
import uz.otash.spring.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionResourceApp {
    private final TransactionService transactionService;

    public TransactionResourceApp(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public ResponseEntity getMsg() {
        return ResponseEntity.ok(transactionService.getAll());
    }

    @PostMapping("/transactions")
    public ResponseEntity create(@RequestBody TransactionApp transaction) {
        return ResponseEntity.ok(transactionService.saveExch(transaction));
    }

    @PutMapping("/transactions")
    public ResponseEntity update(@RequestBody TransactionApp transaction) {
        return ResponseEntity.ok(transactionService.update(transaction));
    }
}
