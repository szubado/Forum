package pl.camp.it.forum.session;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.camp.it.forum.model.User;

@NoArgsConstructor
@Getter
@Setter
@Component
@SessionScope
//kazda sesja pamieta jeden logged
public class SessionData {
    private User user = null;

    public boolean isLogged() {

        return this.user != null;
    }
    public boolean isAdmin() {
        if(this.user == null) {
            return false;
        }
        return this.user.getRole() == User.Role.ADMIN;
    }

    public String createAuthor() {
        return this.user.getLogin();
    }
}
