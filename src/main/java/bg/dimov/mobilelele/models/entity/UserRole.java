package bg.dimov.mobilelele.models.entity;

import bg.dimov.mobilelele.models.entity.enums.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_role")
public class UserRole extends BaseEntity{

    private Role role;

    private Set<User> users;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
