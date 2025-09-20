package br.com.orbitall.channels.repositories;


import br.com.orbitall.channels.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, UUID> {


    List<Transaction> findByCustomerId(UUID customerId);
}
