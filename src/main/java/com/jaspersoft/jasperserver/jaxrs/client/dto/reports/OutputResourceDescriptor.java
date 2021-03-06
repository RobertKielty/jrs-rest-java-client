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

package com.jaspersoft.jasperserver.jaxrs.client.dto.reports;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "outputResource")
public class OutputResourceDescriptor {

    private String contentType;
    private String fileName;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutputResourceDescriptor that = (OutputResourceDescriptor) o;

        if (contentType != null ? !contentType.equals(that.contentType) : that.contentType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return contentType != null ? contentType.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OutputResourceDescriptor{" +
                "contentType='" + contentType + '\'' +
                '}';
    }
}
