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

package com.jaspersoft.jasperserver.jaxrs.client.dto.jobs;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "repositoryDestination")
public class RepositoryDestination {

    private String folderURI;
    private Long id;
    private String outputDescription;
    private Boolean overwriteFiles;
    private Boolean sequentialFilenames;
    private Long version;
    private String timestampPattern;
    private Boolean saveToRepository;
    private String defaultReportOutputFolderURI;
    private Boolean usingDefaultReportOutputFolderURI;
    private String outputLocalFolder;
    private FtpInfo outputFTPInfo;

    public String getFolderURI() {
        return folderURI;
    }

    public void setFolderURI(String folderURI) {
        this.folderURI = folderURI;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutputDescription() {
        return outputDescription;
    }

    public void setOutputDescription(String outputDescription) {
        this.outputDescription = outputDescription;
    }

    public Boolean isOverwriteFiles() {
        return overwriteFiles;
    }

    public void setOverwriteFiles(Boolean overwriteFiles) {
        this.overwriteFiles = overwriteFiles;
    }

    public Boolean isSequentialFilenames() {
        return sequentialFilenames;
    }

    public void setSequentialFilenames(Boolean sequentialFilenames) {
        this.sequentialFilenames = sequentialFilenames;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTimestampPattern() {
        return timestampPattern;
    }

    public void setTimestampPattern(String timestampPattern) {
        this.timestampPattern = timestampPattern;
    }

    public Boolean isSaveToRepository() {
        return saveToRepository;
    }

    public void setSaveToRepository(Boolean saveToRepository) {
        this.saveToRepository = saveToRepository;
    }

    public String getDefaultReportOutputFolderURI() {
        return defaultReportOutputFolderURI;
    }

    public void setDefaultReportOutputFolderURI(String defaultReportOutputFolderURI) {
        this.defaultReportOutputFolderURI = defaultReportOutputFolderURI;
    }

    public Boolean isUsingDefaultReportOutputFolderURI() {
        return usingDefaultReportOutputFolderURI;
    }

    public void setUsingDefaultReportOutputFolderURI(Boolean usingDefaultReportOutputFolderURI) {
        this.usingDefaultReportOutputFolderURI = usingDefaultReportOutputFolderURI;
    }

    public String getOutputLocalFolder() {
        return outputLocalFolder;
    }

    public void setOutputLocalFolder(String outputLocalFolder) {
        this.outputLocalFolder = outputLocalFolder;
    }

    public FtpInfo getOutputFTPInfo() {
        return outputFTPInfo;
    }

    public void setOutputFTPInfo(FtpInfo outputFTPInfo) {
        this.outputFTPInfo = outputFTPInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RepositoryDestination)) return false;

        RepositoryDestination that = (RepositoryDestination) o;

        if (defaultReportOutputFolderURI != null ? !defaultReportOutputFolderURI.equals(that.defaultReportOutputFolderURI) : that.defaultReportOutputFolderURI != null)
            return false;
        if (folderURI != null ? !folderURI.equals(that.folderURI) : that.folderURI != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (outputDescription != null ? !outputDescription.equals(that.outputDescription) : that.outputDescription != null)
            return false;
        if (outputFTPInfo != null ? !outputFTPInfo.equals(that.outputFTPInfo) : that.outputFTPInfo != null)
            return false;
        if (outputLocalFolder != null ? !outputLocalFolder.equals(that.outputLocalFolder) : that.outputLocalFolder != null)
            return false;
        if (overwriteFiles != null ? !overwriteFiles.equals(that.overwriteFiles) : that.overwriteFiles != null)
            return false;
        if (saveToRepository != null ? !saveToRepository.equals(that.saveToRepository) : that.saveToRepository != null)
            return false;
        if (sequentialFilenames != null ? !sequentialFilenames.equals(that.sequentialFilenames) : that.sequentialFilenames != null)
            return false;
        if (timestampPattern != null ? !timestampPattern.equals(that.timestampPattern) : that.timestampPattern != null)
            return false;
        if (usingDefaultReportOutputFolderURI != null ? !usingDefaultReportOutputFolderURI.equals(that.usingDefaultReportOutputFolderURI) : that.usingDefaultReportOutputFolderURI != null)
            return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = folderURI != null ? folderURI.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (outputDescription != null ? outputDescription.hashCode() : 0);
        result = 31 * result + (overwriteFiles != null ? overwriteFiles.hashCode() : 0);
        result = 31 * result + (sequentialFilenames != null ? sequentialFilenames.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (timestampPattern != null ? timestampPattern.hashCode() : 0);
        result = 31 * result + (saveToRepository != null ? saveToRepository.hashCode() : 0);
        result = 31 * result + (defaultReportOutputFolderURI != null ? defaultReportOutputFolderURI.hashCode() : 0);
        result = 31 * result + (usingDefaultReportOutputFolderURI != null ? usingDefaultReportOutputFolderURI.hashCode() : 0);
        result = 31 * result + (outputLocalFolder != null ? outputLocalFolder.hashCode() : 0);
        result = 31 * result + (outputFTPInfo != null ? outputFTPInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RepositoryDestination{" +
                "folderURI='" + folderURI + '\'' +
                ", id=" + id +
                ", outputDescription='" + outputDescription + '\'' +
                ", overwriteFiles=" + overwriteFiles +
                ", sequentialFilenames=" + sequentialFilenames +
                ", version=" + version +
                ", timestampPattern='" + timestampPattern + '\'' +
                ", saveToRepository=" + saveToRepository +
                ", defaultReportOutputFolderURI='" + defaultReportOutputFolderURI + '\'' +
                ", usingDefaultReportOutputFolderURI=" + usingDefaultReportOutputFolderURI +
                ", outputLocalFolder='" + outputLocalFolder + '\'' +
                ", outputFTPInfo=" + outputFTPInfo +
                '}';
    }
}
