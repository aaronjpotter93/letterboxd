# ADR 001: Include User Attributes in Movie Entity

- **Date**: 2023-10-10

## Context

We need a way to track if a movie has been watched, liked, and rated by the user. Currently, the application is intended for a single user.

## Decision

We will include `watched`, `liked`, and `rating` attributes directly in the `Movie` entity.

## Reasoning

- **Simplicity**: Reduces the complexity of the data model for initial development.
- **Ease of Development**: Allows focus on core features without the overhead of managing user entities and relationships.
- **Learning**: Provides a straightforward approach suitable for our current experience level.

## Consequences

- **Positive**:
    - Faster development and implementation.
    - Easier to understand and maintain in the short term.

- **Negative**:
    - Not scalable to multiple users.
    - Will require refactoring when multi-user support is added.
    - Violates normalization principles by mixing user-specific data with global movie data.

## Future Actions

- Plan to refactor the data model to support multiple users by:
    - Introducing a `User` entity.
    - Creating a `UserMovie` join entity.
- Reassess this decision when preparing to implement multi-user features.

---