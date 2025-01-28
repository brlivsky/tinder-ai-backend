package io.javabrains.tinder_ai_backend.conversation;

import java.util.List;

public record Conversation(
        String id,
        String profileId,
        List<ChatMessge> messages
) {
}
