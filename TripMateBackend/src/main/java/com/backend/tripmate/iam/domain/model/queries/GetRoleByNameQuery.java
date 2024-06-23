package com.backend.tripmate.iam.domain.model.queries;

import com.backend.tripmate.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
