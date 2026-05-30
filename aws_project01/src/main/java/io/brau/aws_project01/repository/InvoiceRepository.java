package io.brau.aws_project01.repository;

import io.brau.aws_project01.model.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {
    Optional<Invoice> findByInvoiceNumber(String invoiceNumber);

    List<Invoice> findAllByCustomerName(String customerName);
}
