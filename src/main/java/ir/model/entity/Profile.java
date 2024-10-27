package ir.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name="profileEntity")
@Table(name="profile_tbl")
public class Profile {

    @Id
    @SequenceGenerator(name = "profileSeq", sequenceName = "profile_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profileSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone", unique = true, length = 15)
    private String phone;

    @OneToOne
    @JoinColumn(
            name = "username",
            foreignKey = @ForeignKey(name = "fk_profile_user")
    )
    private User user;

}
