package tacos;

import org.springframework.data.repository.CrudRepository;

// No @Repository needed — Spring Data auto-detects this interface
// and generates a working implementation at runtime.
public interface TacoRepository extends CrudRepository<Taco, Long> {
}
