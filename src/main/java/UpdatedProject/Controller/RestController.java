
package UpdatedProject.Controller;

import UpdatedProject.Repos.BlockInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mohammad
 */
@RepositoryRestController
//@RequestMapping(value = "/blockInfoes")
public class RestController {

    
    
    private final BlockInfoRepository repo;
    
    @Autowired
    public RestController(BlockInfoRepository repo) {
        this.repo = repo;
    }
    
}
