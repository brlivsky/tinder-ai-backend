package io.javabrains.tinder_ai_backend.profiles;

import org.springframework.data.mongodb.repository.MongoRepository;

/*
This is a Mongo repository: why? db is mongo
repository should be interface, why?
- where is the impl?
It should extend mongorepo,
 */
public interface ProfileRepository extends MongoRepository<Profile, String> {

}
