package io.javabrains.tinder_ai_backend.conversation;

import io.javabrains.tinder_ai_backend.profiles.Profile;

import java.util.List;

public record Conversation(
        String id,
        String profileId,
        List<ChatMessge> messages
) {
}
