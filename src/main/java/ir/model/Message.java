package ir.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name="messageEntity")
@Table(name="message_tbl")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;

    @Column(name="date_time")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name="ticket_id")
    private Ticket ticket;


    @ManyToOne
    @JoinColumn(name="username")
    private User user;
}
