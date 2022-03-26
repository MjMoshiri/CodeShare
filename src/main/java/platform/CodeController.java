package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class CodeController {

    HttpHeaders responseHeaders = new HttpHeaders();


    @Autowired
    CodeService codeService;


    Code code;

    @Autowired
    Map<String, String> jsonPairs;

    @GetMapping("/code/{id}")
    String getCode(@PathVariable String id, Model model) {
        try {
            code = codeService.findCodeById(UUID.fromString(id));
            if (code == null)
                throw new RuntimeException();
            if (code.isSecret()) {
                if (!code.isValid()) {
                    codeService.delete(code);
                    throw new RuntimeException();
                } else {
                    if (code.updateAccess())
                        codeService.save(code);
                }
            }
            model.addAttribute("code", code);
            return "code";
        } catch (Exception e) {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

    @GetMapping("/code/latest")
    String getCode(Model model) {
        List<Code> latest = codeService.findLatest();
        model.addAttribute("containers", latest);
        return "latest";
    }

    @GetMapping("/api/code/{id}")
    public ResponseEntity<Code> apiCode(@PathVariable String id) {
        try {
            code = codeService.findCodeById(UUID.fromString(id));
            if (code == null)
                return new ResponseEntity(responseHeaders, NOT_FOUND);
            if (code.isSecret()) {
                if (!code.isValid()) {
                    codeService.delete(code);
                    return new ResponseEntity(responseHeaders, NOT_FOUND);
                } else {
                    if (code.updateAccess())
                        codeService.save(code);
                }
            }
            responseHeaders.set("Content-Type", "application/json");
            jsonPairs.clear();
            return new ResponseEntity(code, responseHeaders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(responseHeaders, NOT_FOUND);
        }
    }


    @GetMapping("/api/code/latest")
    public ResponseEntity<Code> apiCode() {
        responseHeaders.set("Content-Type", "application/json");
        List<Code> latest = codeService.findLatest();
        return new ResponseEntity(latest, responseHeaders, HttpStatus.OK);
    }

    @PostMapping(value = "/api/code/new")
    public ResponseEntity<Code> postCode(@RequestBody Code code) {
        code.setSecret();
        this.code = codeService.save(code);
        jsonPairs.clear();
        jsonPairs.put("id", String.valueOf(code.getId()));
        responseHeaders.set("Content-Type", "application/json");
        return new ResponseEntity(jsonPairs, HttpStatus.OK);
    }

    @GetMapping("/code/new")
    String sendModel(Model model) {
        return "newCode";
    }

}
