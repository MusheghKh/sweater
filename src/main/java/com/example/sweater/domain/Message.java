package com.example.sweater.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill message")
    @Length(max = 2048, message = "Message too long (more than 2KB)")
    @NonNull
    private String text;

    @Length(max = 2048, message = "Tag too long (more than 255)")
    @NonNull
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @NonNull
    private User author;

    @Setter
    private String filename;

    public String getAuthorName() {
        return author.getUsername();
    }
}