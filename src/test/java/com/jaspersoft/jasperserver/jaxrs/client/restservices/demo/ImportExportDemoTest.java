package com.jaspersoft.jasperserver.jaxrs.client.restservices.demo;

import com.jaspersoft.jasperserver.dto.authority.ClientUser;
import com.jaspersoft.jasperserver.jaxrs.client.apiadapters.importexport.exportservice.ExportParameter;
import com.jaspersoft.jasperserver.jaxrs.client.core.JasperserverRestClient;
import com.jaspersoft.jasperserver.jaxrs.client.core.ResponseStatus;
import com.jaspersoft.jasperserver.jaxrs.client.core.RestClientConfiguration;
import com.jaspersoft.jasperserver.jaxrs.client.core.exceptions.JSClientWebException;
import com.jaspersoft.jasperserver.jaxrs.client.core.operationresult.OperationResult;
import com.jaspersoft.jasperserver.jaxrs.client.dto.importexport.StateDto;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.InputStream;

@Test(dependsOnGroups = {"AuthorityDemo", "UsersServiceTests"})
public class ImportExportDemoTest extends Assert {

    private static JasperserverRestClient client;
    private InputStream export;

    @BeforeClass
    public static void setUp() {
        RestClientConfiguration configuration = RestClientConfiguration.loadConfiguration("url.properties");
        client = new JasperserverRestClient(configuration);

        ClientUser user = new ClientUser()
                .setUsername("john.doe")
                .setPassword("12345678")
                .setEmailAddress("john.doe@email.net")
                .setEnabled(true)
                .setExternallyDefined(false)
                .setFullName("John Doe");

        try {
            client.authenticate("jasperadmin", "jasperadmin")
                    .usersService()
                    .username(user.getUsername())
                    .createOrUpdate(user);
        } catch (Exception e) {}
    }

    @AfterClass
    public static void tearDown(){
        try {
            client.authenticate("jasperadmin", "jasperadmin")
                    .usersService()
                    .username("john.doe")
                    .delete();
        } catch (Exception e) {}
    }

    @Test
    public void testExport() {

        StateDto exportState = client.authenticate("jasperadmin", "jasperadmin")
                .exportService()
                .newTask()
                .role("ROLE_ADMINISTRATOR").role("ROLE_USER")
                .user("jasperadmin").user("john.doe")
                .uri("/")
                .parameter(ExportParameter.ROLE_USERS).parameter(ExportParameter.REPOSITORY_PERMISSIONS)
                .create()
                .getEntity();

        export = client.authenticate("jasperadmin", "jasperadmin")
                .exportService()
                .task(exportState.getId())
                .fetch()
                .getEntity();

    }

    @Test(dependsOnMethods = "testExport", expectedExceptions = JSClientWebException.class)
    public void testDeleteJohnDoeUserAndCheckAbsence() {
        OperationResult result =
                client.authenticate("jasperadmin", "jasperadmin")
                        .usersService()
                        .username("john.doe")
                        .delete();
        assertEquals(result.getResponse().getStatus(), ResponseStatus.NO_CONTENT);

        OperationResult<ClientUser> result1 =
                client.authenticate("jasperadmin", "jasperadmin")
                        .usersService()
                        .username("john.doe")
                        .get();

        assertEquals(result1.getResponse().getStatus(), ResponseStatus.NOT_FOUND);
        assertEquals(result1.getEntity(), null);
    }

    @Test(dependsOnMethods = "testDeleteJohnDoeUserAndCheckAbsence")
    public void testImport() {

        StateDto stateDto = client.authenticate("jasperadmin", "jasperadmin")
                .importService()
                .newTask()
                .create(export)
                .getEntity();

        while (true){
            StateDto state = client.authenticate("jasperadmin", "jasperadmin")
                    .importService()
                    .task(stateDto.getId())
                    .state()
                    .getEntity();
            if ("finished".equals(state.getPhase()))
                break;
        }
    }

    @Test(dependsOnMethods = "testImport")
    public void testGetJohnDoeUserAfterImport(){
        OperationResult<ClientUser> result1 =
                client.authenticate("jasperadmin", "jasperadmin")
                        .usersService()
                        .username("john.doe")
                        .get();
        assertNotEquals(result1.getEntity(), null);
        assertEquals(result1.getEntity().getUsername(), "john.doe");
    }


}
