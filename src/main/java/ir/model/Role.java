package ir.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name="roleEntity")
@Table(name="role_tbl")
public class Role {
    @Id
    @Column(name="role_name", length = 30)
    private String roleName;
}
