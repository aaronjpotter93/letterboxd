# Project Design Document

## Overview

This document outlines the design decisions and architecture for the Movie Tracking App.

## Current Design

### Movie Entity

- **Purpose**: Represents movies with attributes from TMDB and Letterboxd.
- **User-Specific Attributes**: `watched`, `liked`, `rating` are included directly in the `Movie` entity.

#### Reasoning

- **Simplicity**: Including these attributes directly simplifies the code for a single-user application.
- **Development Speed**: Allows for faster initial development and learning.

#### Implications

- **Limited Scalability**: This design won't support multiple users without significant changes.
- **Data Redundancy**: Mixing user-specific data with movie data can lead to complications.

#### Future Improvements

- **Introduce `User` Entity**: To represent different users in the system.
- **Create `UserMovie` Join Entity**:
    - Handles many-to-many relationships between users and movies.
    - Stores user-specific data like `watched`, `liked`, `rating`.

#### Steps for Future Implementation

1. **Add `User` Entity**:
    - Fields: `id`, `username`, `email`, etc.

2. **Refactor `Movie` Entity**:
    - Remove user-specific attributes.

3. **Create `UserMovie` Entity**:
    - Fields: `id`, `user_id`, `movie_id`, `watched`, `liked`, `rating`, `watched_date`, `watch_count`.

4. **Update Codebase**:
    - Modify services and repositories to use new entities.
    - Ensure all existing functionality works with the updated schema.

5. **Data Migration**:
    - Migrate existing data to the new structure.
    - Write scripts or use ORM tools to assist with migration.

6. **Testing**:
    - Thoroughly test all parts of the application after changes.

---

## Conclusion

The current design suits the immediate needs of the application. As we move towards supporting more features and users, we'll refactor the schema following the steps outlined.