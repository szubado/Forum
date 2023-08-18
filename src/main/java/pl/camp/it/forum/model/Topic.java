package pl.camp.it.forum.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import pl.camp.it.forum.services.ITopicService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Topic {
/*    @Autowired
    ITopicService topicService;*/
    private int id;
    private String title;
    private User user;
    private final Set<Post> posts = new HashSet<>();/* = topicService.getTopicByTopicId(id).size()*/; //Post quantity
    private LocalDateTime dateTime;
    public String getPrettyTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return this.dateTime.format(formatter);
    }
}