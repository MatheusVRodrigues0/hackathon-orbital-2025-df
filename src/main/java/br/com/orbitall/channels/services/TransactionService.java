package br.com.orbitall.channels.services;




import br.com.orbitall.channels.canonicals.CustomerOutput;
import br.com.orbitall.channels.canonicals.TransactionInput;
import br.com.orbitall.channels.canonicals.TransactionOutput;
import br.com.orbitall.channels.models.Transaction;
import br.com.orbitall.channels.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public TransactionOutput create(TransactionInput input) {
        LocalDateTime now = LocalDateTime.now();

        Transaction transaction = new Transaction();

        transaction.setCustomerId(input.customerId());
        transaction.setAmount(input.amount());
        transaction.setCardType(input.cardType());
        transaction.setId(UUID.randomUUID());
        transaction.setCreatedAt(now);
        transaction.setActive(true);

        repository.save(transaction);

        return new TransactionOutput(
                transaction.getId(),
                transaction.getCustomerId(),
                transaction.getAmount(),
                transaction.getCardType(),
                transaction.getCreatedAt(),
                transaction.isActive()
        );
    }

    public List<TransactionOutput> retrieve(UUID id) {
        List<TransactionOutput> list = new ArrayList<>();


        repository.findByCustomerId(id).forEach( transaction -> {

            if(transaction.isActive()) {
                TransactionOutput output = new TransactionOutput(
                        transaction.getId(),
                        transaction.getCustomerId(),
                        transaction.getAmount(),
                        transaction.getCardType(),
                        transaction.getCreatedAt(),
                        transaction.isActive());

                list.add(output);
            }
        });

        return list;
    }
}
