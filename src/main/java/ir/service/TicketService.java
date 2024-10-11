package ir.service;

import ir.model.Ticket;
import ir.model.User;
import ir.model.enums.TicketStatus;

import java.util.List;

public interface TicketService {
    void save(Ticket ticket);
    void update(Ticket ticket);
    void delete(Long id);
    List<Ticket> findAll();
    Ticket findById(Long id);
    List<Ticket> findByUser(User user);
    List<Ticket> findByUserUsername(String username);
    List<Ticket> findByStatus(TicketStatus status);
    List<Ticket> findByTitleContains(String title);
}
