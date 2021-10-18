package controllers;

import com.encentral.app.api.IAdmin;
import com.encentral.app.model.Admin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import io.swagger.annotations.*;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

@Transactional
@Api(value = "Admin")
public class AdminController extends Controller {
    @Inject
    IAdmin iAdmin;

    @Inject
    FormFactory formFactory;

    @Inject
    ObjectMapper objectMapper;

    @ApiOperation(value = "Add new Admin")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, response = Admin.class, message = "Newly created Admin")
            }
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "body",
                    value = "Admin details",
                    paramType = "body",
                    required = true,
                    dataType = "com.encentral.app.model.Admin"
            )
    })
    public Result add() throws JsonProcessingException {
        Form<Admin> adminForm = formFactory.form(Admin.class).bindFromRequest();
        if (adminForm.hasErrors())
            return badRequest(adminForm.errorsAsJson());
        else
            return ok(objectMapper.writeValueAsString(iAdmin.addAdmin(adminForm.get())));
    }
}
