package ir.repository;

import ir.model.Message;
import ir.model.Ticket;
import ir.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByOrderByDateTime();
    List<Message> findByUserOrderByDateTime(User user);
    List<Message> findByUserUsernameOrderByDateTime(String username);
    List<Message> findByTicketOrderByDateTime(Ticket ticket);
    List<Message> findByTicketIdOrderByDateTime(Long ticketId);
}