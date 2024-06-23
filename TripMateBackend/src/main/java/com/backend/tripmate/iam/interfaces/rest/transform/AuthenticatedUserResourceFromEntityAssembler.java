package com.backend.tripmate.iam.interfaces.rest.transform;

import com.backend.tripmate.iam.domain.model.aggregates.User;
import com.backend.tripmate.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User entity, String token) {
        return new AuthenticatedUserResource(entity.getId(), entity.getUsername(), token);
    }
}
