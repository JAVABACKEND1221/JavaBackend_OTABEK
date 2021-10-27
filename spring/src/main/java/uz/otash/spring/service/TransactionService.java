package uz.otash.spring.service;


import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.otash.spring.model.TransactionApp;

import java.util.Arrays;
import java.util.List;

@Service
public class TransactionService {
    private final String URI = "http://localhost:8082/api/transactions";

    public String getMessage() {
        RestTemplate restTemplate = new RestTemplate();
        String msg = restTemplate.getForObject(URI + "/test", String.class);
        return msg;
    }

    public ResponseEntity<TransactionApp> save(TransactionApp transaction) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TransactionApp> transaction1 = restTemplate.postForEntity(URI, transaction, TransactionApp.class);
        return transaction1;
    }

    public List getAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<TransactionApp>> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(URI + "/test", HttpMethod.GET ,entity, List.class).getBody();
    }

    public TransactionApp saveExch(TransactionApp transaction){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<TransactionApp> entity = new HttpEntity<>(transaction,headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(URI , HttpMethod.POST ,entity, TransactionApp.class).getBody();
    }

    public TransactionApp update(TransactionApp transaction){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<TransactionApp> entity = new HttpEntity<>(transaction,headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(URI , HttpMethod.PUT ,entity, TransactionApp.class).getBody();
    }
}
