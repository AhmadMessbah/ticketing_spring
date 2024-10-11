package ir.service;

import ir.model.Message;
import ir.model.Ticket;
import ir.model.User;

import java.util.List;

public interface MessageService {
    void save(Message message);
    void update(Message message);
    void delete(Long id);
    List<Message> findAll();
    Message findById(Long id);
    List<Message> findByUser(User user);
    List<Message> findByUserUsername(String username);
    List<Message> findByTicket(Ticket ticket);
    List<Message> findByTicketId(Long ticketId);
}
