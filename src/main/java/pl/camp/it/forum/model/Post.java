package pl.camp.it.forum.model;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Post {
/*    public Post(int topicId) {
        this.topicId = topicId;
    }*/

    private int id;
    private String text;
    private User user;
/*
    private Topic topic;
*/
    private LocalDateTime dateTime;
    public String getPrettyTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return this.dateTime.format(formatter);
    }
}
