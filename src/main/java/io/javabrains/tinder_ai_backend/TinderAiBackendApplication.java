package io.javabrains.tinder_ai_backend;

import io.javabrains.tinder_ai_backend.conversations.Conversation;
import io.javabrains.tinder_ai_backend.conversations.ConversationRepository;
import io.javabrains.tinder_ai_backend.matches.MatchRepository;
import io.javabrains.tinder_ai_backend.profiles.ProfileCreationService;
import io.javabrains.tinder_ai_backend.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

	@Autowired
	private ProfileCreationService profileCreationService;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private ConversationRepository conversationRepository;
	@Autowired
	private MatchRepository matchRepository;

	public static void main(String[] args) {
		SpringApplication.run(TinderAiBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		clearAllData();
		profileCreationService.saveProfilesToDB();
	}

	private void clearAllData() {
		conversationRepository.deleteAll();
		matchRepository.deleteAll();
		profileRepository.deleteAll();
	}

}
/*
Notes:
- Not using package by layer, rather package by feature.
-
CommandLineRunner, run(), tell the compiler that whenever the application starts, the run method executes
 */
