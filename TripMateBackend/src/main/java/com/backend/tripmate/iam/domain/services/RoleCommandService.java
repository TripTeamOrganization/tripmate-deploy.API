package com.backend.tripmate.iam.domain.services;

import com.backend.tripmate.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
