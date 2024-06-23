package com.backend.tripmate.iam.interfaces.rest.transform;

import com.backend.tripmate.iam.domain.model.entities.Role;
import com.backend.tripmate.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role entity) {
        return new RoleResource(entity.getId(), entity.getStringName());

    }
}
