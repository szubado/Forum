package pl.camp.it.forum.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Post {
    public Post(int topicId) {
        this.topicId = topicId;
    }

    private int id;
    private String text;
    private String author;
    private int topicId;
}
