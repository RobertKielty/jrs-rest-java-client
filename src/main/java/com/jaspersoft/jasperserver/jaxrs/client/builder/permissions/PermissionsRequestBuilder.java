package com.jaspersoft.jasperserver.jaxrs.client.builder.permissions;

import com.jaspersoft.jasperserver.dto.permissions.RepositoryPermission;
import com.jaspersoft.jasperserver.jaxrs.client.builder.RequestBuilder;

import javax.ws.rs.client.WebTarget;

public class PermissionsRequestBuilder<T> extends RequestBuilder<T> {

    private static final String URI = "/permissions";

    public PermissionsRequestBuilder(Class responseClass) {
        super(responseClass);
        this.setPath(URI);
    }

    private PermissionsRequestBuilder(WebTarget webTarget, Class responseClass) {
        super(responseClass);
        this.setTarget(webTarget);
    }

    public RequestBuilder<RepositoryPermission> permissionRecipient(PermissionRecipient recipient, String name) {
        String protocol = recipient.getProtocol();
        String uri = protocol + ":%2F" + name;
        this.addMatrixParam("recipient", uri);
        return new PermissionsRequestBuilder<RepositoryPermission>(this.getPath(), RepositoryPermission.class);
    }

}