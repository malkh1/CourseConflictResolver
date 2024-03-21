package UpdatedProject.Controller;
import UpdatedProject.Models.BlockInfo;
import UpdatedProject.Repos.CourseRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * This controller handles the back-end logic for when user is viewing 
 * and editing a specific block
 * 
 * @author mohammad and waleed
 */
@Controller
public class BlockViewController {
    
    private final CourseRecordsRepository repo;
    
    @Autowired
    public BlockViewController(CourseRecordsRepository repo) {
        this.repo = repo;
        
    }
    
    @GetMapping("/{blockId}")
    public String showBlockView(@PathVariable String blockId, Model model) {
        BlockInfo block;
        model.addAttribute("blockId",blockId);
        return "blockview";
    }
}
