package tacos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tacos")
public class TacoController {

    private final TacoRepository tacoRepo;

    // Only one constructor, so Spring infers @Autowired automatically.
    public TacoController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @GetMapping
    public List<Taco> getAllTacos() {
        return (List<Taco>) tacoRepo.findAll();
    }

    @GetMapping("/{id}")
    public Taco getTaco(@PathVariable("id") Long id) {
        return tacoRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Taco createTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }
}
