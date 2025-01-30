package io.javabrains.tinder_ai_backend.conversations;

import io.javabrains.tinder_ai_backend.profiles.Profile;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.*;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;
import org.springframework.ai.ollama.OllamaChatClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConversationService {
    private final OllamaChatClient chatClient;

    public ConversationService(OllamaChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public Conversation generateProfileResponse(Conversation conversation, Profile profile, Profile user) {
        SystemMessage systemMessage = new SystemMessage("Pretend to be a Tinder user with name " + profile.firstName() + " " + profile.lastName()
        + " age " + profile.age() + "myersBriggsPersonalityType " + profile.myersBriggsPersonalityType() + "bio " + profile.bio()
        + "ethnicity " + profile.ethnicity() + "gender " + profile.gender() + "Keep the chat clear, concise and fun");

        // What does the below code do?
        List<AbstractMessage> conversationMessages = conversation.messages().stream().map(chatMessage -> {
            if (chatMessage.authorId().equals(profile.id())) {
                return new AssistantMessage(chatMessage.messageText());
            } else {
                return new UserMessage(chatMessage.messageText());
            }
        }).toList();

        List<Message> allMessages = new ArrayList<>();
        allMessages.add(systemMessage);
        allMessages.addAll(conversationMessages);

        Prompt prompt = new Prompt(allMessages);
        ChatResponse response = chatClient.call(prompt);

        conversation.messages().add(new ChatMessage(
                response.getResult().getOutput().getContent(),
                profile.id(),
                LocalDateTime.now()
        ));

        return conversation;
    }
}
