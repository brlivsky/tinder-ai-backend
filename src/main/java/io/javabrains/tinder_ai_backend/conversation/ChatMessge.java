package io.javabrains.tinder_ai_backend.conversation;

import java.time.LocalDateTime;

public record ChatMessge(
        String messageText,
        String authorId,
        LocalDateTime messageTime
) {
}
