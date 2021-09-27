package bg.dimov.mobilelele.models.entity;

import bg.dimov.mobilelele.models.entity.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity{

    private Role role;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
