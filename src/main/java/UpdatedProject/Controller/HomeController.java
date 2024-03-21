package UpdatedProject.Controller;

import UpdatedProject.Repos.BlockInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    private final BlockInfoRepository blockRepo;

    @Autowired
    public HomeController(BlockInfoRepository blockRepo) {
        this.blockRepo = blockRepo;
    }

    @GetMapping("/home")
    public String showBlocks(Model model) {
        var blocks = blockRepo.findAll();
        model.addAttribute("blocks", blocks);
        return "blocks";
    }
}

