package Task.Controller;

import Task.Model.ErrorResponse;
import Task.Model.UserName;
import Task.Service.ServiceIMPL.GitInformationServiceIMPL;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get")

public class GitInformationController {
    public static final String NOT_FOUND =" 404 NOT FOUND";
    private GitInformationServiceIMPL gitInformationServiceIMPL;

    public GitInformationController(GitInformationServiceIMPL gitInformationServiceIMPL) {
        this.gitInformationServiceIMPL = gitInformationServiceIMPL;
    }
    @GetMapping
    public ResponseEntity<?> getGitInformation (
            @RequestBody UserName userName) {

        try {
            return new ResponseEntity<>(gitInformationServiceIMPL.getGitInformation(userName), HttpStatus.OK);
        } catch (FeignException.NotFound ex) {
            return new ResponseEntity<>(new ErrorResponse(NOT_FOUND, "Username doesn't exist"), HttpStatus.NOT_FOUND);
        }
    }
    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<String>   handleException(
            HttpMediaTypeNotAcceptableException e) {
        String jsonErrorResponse ="";
        ObjectMapper om = new ObjectMapper();
        try{ jsonErrorResponse = om.writeValueAsString(new ErrorResponse("406 NOT ACCEPTABLE","Entered media type is incorrect"));

        }
        catch (Exception ex){

        }
        return  new ResponseEntity<>(jsonErrorResponse, HttpStatus.NOT_ACCEPTABLE);
    }

}






