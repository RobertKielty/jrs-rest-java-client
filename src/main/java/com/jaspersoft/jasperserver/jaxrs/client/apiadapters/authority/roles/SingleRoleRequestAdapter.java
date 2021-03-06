/*
* Copyright (C) 2005 - 2014 Jaspersoft Corporation. All rights  reserved.
* http://www.jaspersoft.com.
*
* Unless you have purchased  a commercial license agreement from Jaspersoft,
* the following license terms  apply:
*
* This program is free software: you can redistribute it and/or  modify
* it under the terms of the GNU Affero General Public License  as
* published by the Free Software Foundation, either version 3 of  the
* License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Affero  General Public License for more details.
*
* You should have received a copy of the GNU Affero General Public  License
* along with this program.&nbsp; If not, see <http://www.gnu.org/licenses/>.
*/

package com.jaspersoft.jasperserver.jaxrs.client.apiadapters.authority.roles;

import com.jaspersoft.jasperserver.dto.authority.ClientRole;
import com.jaspersoft.jasperserver.jaxrs.client.apiadapters.AbstractAdapter;
import com.jaspersoft.jasperserver.jaxrs.client.core.JerseyRequestBuilder;
import com.jaspersoft.jasperserver.jaxrs.client.core.SessionStorage;
import com.jaspersoft.jasperserver.jaxrs.client.core.operationresult.OperationResult;

public class SingleRoleRequestAdapter extends AbstractAdapter {

    private final String rolename;

    public SingleRoleRequestAdapter(SessionStorage sessionStorage, String rolename) {
        super(sessionStorage);
        this.rolename = rolename;
    }

    public OperationResult<ClientRole> get(){
        return buildRequest().get();
    }

    public OperationResult<ClientRole> createOrUpdate(ClientRole user){
        return buildRequest().put(user);
    }

    public OperationResult delete(){
        return buildRequest().delete();
    }

    private JerseyRequestBuilder<ClientRole> buildRequest(){
        return JerseyRequestBuilder.buildRequest(sessionStorage, ClientRole.class, new String[]{"/roles", rolename});
    }

}
