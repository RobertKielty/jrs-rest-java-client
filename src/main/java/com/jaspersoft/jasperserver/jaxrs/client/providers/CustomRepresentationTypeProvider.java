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

package com.jaspersoft.jasperserver.jaxrs.client.providers;

import com.jaspersoft.jasperserver.dto.resources.ResourceMediaType;
import org.codehaus.jackson.jaxrs.Annotations;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;


@Provider
@Consumes({
        "application/collection+json",
        "application/job+json",
        ResourceMediaType.LIST_OF_VALUES_JSON,
        ResourceMediaType.ADHOC_DATA_VIEW_JSON,
        ResourceMediaType.AWS_DATA_SOURCE_JSON,
        ResourceMediaType.BEAN_DATA_SOURCE_JSON,
        ResourceMediaType.CUSTOM_DATA_SOURCE_JSON,
        ResourceMediaType.DATA_TYPE_JSON,
        ResourceMediaType.FILE_JSON,
        ResourceMediaType.FOLDER_JSON,
        ResourceMediaType.INPUT_CONTROL_JSON,
        ResourceMediaType.JDBC_DATA_SOURCE_JSON,
        ResourceMediaType.JNDI_JDBC_DATA_SOURCE_JSON,
        ResourceMediaType.MONDRIAN_CONNECTION_JSON,
        ResourceMediaType.MONDRIAN_XMLA_DEFINITION_JSON,
        ResourceMediaType.OLAP_UNIT_JSON,
        ResourceMediaType.QUERY_JSON,
        ResourceMediaType.REPORT_UNIT_JSON,
        ResourceMediaType.SECURE_MONDRIAN_CONNECTION_JSON,
        ResourceMediaType.SEMANTIC_LAYER_DATA_SOURCE_JSON,
        ResourceMediaType.VIRTUAL_DATA_SOURCE_JSON,
        ResourceMediaType.XMLA_CONNECTION_JSON,
        ResourceMediaType.RESOURCE_LOOKUP_JSON,
        "text/json"})
@Produces({
        "application/collection+json",
        "application/job+json",
        ResourceMediaType.LIST_OF_VALUES_JSON,
        ResourceMediaType.ADHOC_DATA_VIEW_JSON,
        ResourceMediaType.AWS_DATA_SOURCE_JSON,
        ResourceMediaType.BEAN_DATA_SOURCE_JSON,
        ResourceMediaType.CUSTOM_DATA_SOURCE_JSON,
        ResourceMediaType.DATA_TYPE_JSON,
        ResourceMediaType.FILE_JSON,
        ResourceMediaType.FOLDER_JSON,
        ResourceMediaType.INPUT_CONTROL_JSON,
        ResourceMediaType.JDBC_DATA_SOURCE_JSON,
        ResourceMediaType.JNDI_JDBC_DATA_SOURCE_JSON,
        ResourceMediaType.MONDRIAN_CONNECTION_JSON,
        ResourceMediaType.MONDRIAN_XMLA_DEFINITION_JSON,
        ResourceMediaType.OLAP_UNIT_JSON,
        ResourceMediaType.QUERY_JSON,
        ResourceMediaType.REPORT_UNIT_JSON,
        ResourceMediaType.SECURE_MONDRIAN_CONNECTION_JSON,
        ResourceMediaType.SEMANTIC_LAYER_DATA_SOURCE_JSON,
        ResourceMediaType.VIRTUAL_DATA_SOURCE_JSON,
        ResourceMediaType.XMLA_CONNECTION_JSON,
        ResourceMediaType.RESOURCE_LOOKUP_JSON,
        "text/json"})
public class CustomRepresentationTypeProvider extends JacksonJaxbJsonProvider{

    public CustomRepresentationTypeProvider() {
        super(Annotations.JACKSON, Annotations.JAXB);
    }

    @Override
    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return super.isReadable(aClass, type, annotations, mediaType);
    }

    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return super.isWriteable(aClass, type, annotations, mediaType);
    }

}

