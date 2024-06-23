package com.backend.tripmate.iam.interfaces.rest.transform;

import com.backend.tripmate.iam.domain.model.commands.SignInCommand;
import com.backend.tripmate.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource resource) {
        return new SignInCommand(resource.username(), resource.password());
    }
}