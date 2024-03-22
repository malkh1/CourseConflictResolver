package UpdatedProject.Controller;
import UpdatedProject.Models.BlockInfo;
import UpdatedProject.Repos.BlockInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * This controller handles the back-end logic for when user is viewing 
 * and editing a specific block
 * 
 * @author mohammad and waleed
 */
@Controller
@RequestMapping(value = "/blockview")
public class BlockViewController {
    
    private final BlockInfoRepository blockRepo;
    
    @Autowired
    public BlockViewController(BlockInfoRepository blockRepo) {
        this.blockRepo = blockRepo;
        
    }
    
    @GetMapping("/{blockId}")
    public String showBlockView(@PathVariable String blockId, Model model) {
        BlockInfo block = blockRepo.findByBlockId(blockId);
        model.addAttribute("blockId",blockId);
        model.addAttribute("block",block);
        return "blockview";
    }
}
