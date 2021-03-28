package com.example.sweater.domain.dto;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.domain.util.MessageHelper;
import lombok.Getter;
import lombok.ToString;

@ToString(of = { "id", "author", "likes", "meLiked" })
public class MessageDto {
    @Getter
    private Long id;
    @Getter
    private String text;
    @Getter
    private String tag;
    @Getter
    private User author;
    @Getter
    private String filename;
    @Getter
    private Long likes;
    @Getter
    private Boolean meLiked;

    public MessageDto(Message message, Long likes, Boolean meLiked) {
        id = message.getId();
        text = message.getText();
        tag = message.getTag();
        author = message.getAuthor();
        filename = message.getFilename();
        this.likes = likes;
        this.meLiked = meLiked;
    }

    public String getAuthorName() {
        return MessageHelper.getAuthorName(author);
    }
}
