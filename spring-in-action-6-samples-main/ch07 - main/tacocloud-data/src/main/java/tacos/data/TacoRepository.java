package tacos.data;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import tacos.Taco;


public interface TacoRepository
         extends PagingAndSortingRepository<Taco, Long> {

  // Backs Spring Data REST's "recents" search resource at
  // /data-api/tacos/search/recent, followed by TacoCloudClient's
  // getRecentTacosWithTraverson().
  @RestResource(path = "recent", rel = "recent")
  List<Taco> findFirst12ByOrderByCreatedAtDesc();

}
