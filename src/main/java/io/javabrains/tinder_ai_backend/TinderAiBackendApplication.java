package io.javabrains.tinder_ai_backend;

import io.javabrains.tinder_ai_backend.conversation.ChatMessge;
import io.javabrains.tinder_ai_backend.conversation.Conversation;
import io.javabrains.tinder_ai_backend.conversation.ConversationRepository;
import io.javabrains.tinder_ai_backend.profiles.Gender;
import io.javabrains.tinder_ai_backend.profiles.Profile;
import io.javabrains.tinder_ai_backend.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ConversationRepository conversationRepository;

	public static void main(String[] args) {
		SpringApplication.run(TinderAiBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("The app is running");

		// temporary
		profileRepository.deleteAll();
		conversationRepository.deleteAll();

		Profile profile = new Profile(
				"1",
				"Vysakh",
				"Ramesh",
				28,
				"Indian",
				Gender.MALE,
				"Software Engineer",
				"foo.jpg",
				"IJFK"
		);
		profileRepository.save(profile);
		profileRepository.findAll().forEach(System.out::println);		// method reference in functional programming
//		profileRepository.findAll().forEach(x -> System.out.println(x));		// lambda function in functional programming

		Conversation conversation = new Conversation(
				"1",
				profile.id(),
				List.of(
						new ChatMessge("Hello", profile.id(), LocalDateTime.now())
				)
		);

		conversationRepository.save(conversation);
		conversationRepository.findAll().forEach(System.out::println);
	}
	// timestamp ends at : 1:15:20
	// timestamp ends at : 1:38:58

}
/*
Notes:
- Not using package by layer, rather package by feature.
-
CommandLineRunner, run(), tell the compiler that whenever the application starts, the run method executes
 */
