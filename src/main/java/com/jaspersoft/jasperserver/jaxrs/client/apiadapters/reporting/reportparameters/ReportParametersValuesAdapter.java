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

package com.jaspersoft.jasperserver.jaxrs.client.apiadapters.reporting.reportparameters;

import com.jaspersoft.jasperserver.jaxrs.client.apiadapters.AbstractAdapter;
import com.jaspersoft.jasperserver.jaxrs.client.core.JerseyRequestBuilder;
import com.jaspersoft.jasperserver.jaxrs.client.core.SessionStorage;
import com.jaspersoft.jasperserver.jaxrs.client.core.operationresult.OperationResult;
import com.jaspersoft.jasperserver.jaxrs.client.dto.reports.inputcontrols.InputControlStateListWrapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import static com.jaspersoft.jasperserver.jaxrs.client.core.JerseyRequestBuilder.buildRequest;

public class ReportParametersValuesAdapter extends AbstractAdapter {

    protected final String reportUnitUri;
    protected final MultivaluedMap<String, String> params;
    private String idsPathSegment;

    public ReportParametersValuesAdapter(SessionStorage sessionStorage, String reportUnitUri) {
        super(sessionStorage);
        this.params = new MultivaluedHashMap<String, String>();
        this.reportUnitUri = reportUnitUri;
    }

    public ReportParametersValuesAdapter(SessionStorage sessionStorage, String reportUnitUri, String idsPathSegment) {
        this(sessionStorage, reportUnitUri);
        this.idsPathSegment = idsPathSegment;
    }

    public ReportParametersValuesAdapter parameter(String name, String value) {
        params.add(name, value);
        return this;
    }

    public OperationResult<InputControlStateListWrapper> get() {
        JerseyRequestBuilder<InputControlStateListWrapper> builder =
                buildRequest(sessionStorage, InputControlStateListWrapper.class, new String[]{"/reports", reportUnitUri, "/inputControls"});
        if (idsPathSegment != null) {
            builder.setPath(idsPathSegment);
        }
        builder.setPath("values");
        builder.addParams(params);
        return builder.get();
    }

    public OperationResult<InputControlStateListWrapper> update() {
        JerseyRequestBuilder<InputControlStateListWrapper> builder =
                buildRequest(sessionStorage, InputControlStateListWrapper.class,
                        new String[]{"/reports", reportUnitUri, "/inputControls"});

        builder.setContentType(MediaType.APPLICATION_XML);
        builder.setAccept(MediaType.APPLICATION_XML);
        if (idsPathSegment != null) {
            builder.setPath(idsPathSegment);
        }
        builder.setPath("values");
        return builder.post(ReportParametersUtils.toReportParameters(params));
    }


}
