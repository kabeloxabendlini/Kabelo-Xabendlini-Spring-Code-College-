package webapp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tacos")
// @Tag groups this controller's endpoints under one heading in the Swagger UI
@Tag(name = "Tacos", description = "Endpoints for creating and retrieving tacos")
public class TacoController {

    private final TacoRepository tacoRepo;

    public TacoController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    // @Operation adds a summary/description shown above this endpoint in Swagger UI
    @Operation(summary = "List all tacos", description = "Returns every taco currently stored.")
    @GetMapping
    public List<Taco> getAllTacos() {
        return (List<Taco>) tacoRepo.findAll();
    }

    @Operation(summary = "Get a single taco by ID")
    // @ApiResponses documents each possible HTTP status the endpoint can return —
    // this is what lets someone reading the docs know a 404 is possible
    // without having to read the method body.
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Taco found"),
        @ApiResponse(responseCode = "404", description = "No taco with that ID exists")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Taco> getTaco(
            @Parameter(description = "ID of the taco to retrieve", example = "1")
            @PathVariable("id") Long id) {
        return tacoRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new taco")
    @ApiResponse(responseCode = "201", description = "Taco created successfully")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Taco createTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }
}
