package controllers;

import com.encentral.app.api.IAdmin;
import com.encentral.app.model.Admin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.encentral.scaffold.commons.ControllerUtils.getJSONStringField;
import static com.encentral.scaffold.commons.ControllerUtils.isValidEmail;

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

    @ApiOperation(value = "Login as Admin")

    public Result login() throws JsonProcessingException {
        JsonNode data = request().body().asJson();
        if (data == null || data.isEmpty())
            return notFound("No data provided");

        List<String> errors = new ArrayList<>();

        String email = getJSONStringField(data, "email");
        if (email == null || email.isEmpty())
            errors.add("email is required");

        if (email != null && !email.isEmpty() && !isValidEmail(email))
            errors.add("email is not valid");

        String password = getJSONStringField(data, "password");
        if (password == null || password.isEmpty())
            errors.add("password is required");

        if (!errors.isEmpty())
            return badRequest(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errors));

        Optional<Admin> admin = iAdmin.getAdmin(email);
        if (admin.isEmpty())
            return unauthorized("Invalid email or password");

        if (!admin.get().getPassword().equals(password))
            return unauthorized("Invalid email or password");

        return ok(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(admin.get().getToken()));
    }
}




























