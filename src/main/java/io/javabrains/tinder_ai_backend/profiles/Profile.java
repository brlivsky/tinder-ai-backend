package io.javabrains.tinder_ai_backend.profiles;

/* Why record?
- doesn't need a logic
- acts as DTO/model
- class requires setters/getters which aren't necessary
 */
public record Profile(
        String id,              // should be non-predictable, maybe guid?, disallow navigating profiles by passing values
        String firstName,
        String lastName,
        int age,
        String ethnicity,
        Gender gender,
        String bio,
        String imageUrl,
        String myersBriggsPersonalityType
) {
}
