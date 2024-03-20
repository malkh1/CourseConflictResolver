package UpdatedProject.Controller;

import UpdatedProject.Parsers.BlockInfo;
import UpdatedProject.Services.BlockCombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.LinkedHashMap;

@Controller
public class HomeController {

    private final BlockCombinationService blockCombinationService;

    @Autowired
    public HomeController(BlockCombinationService blockCombinationService) {
        this.blockCombinationService = blockCombinationService;
    }

    @GetMapping("/home")
    public String showBlocks(Model model) {
        LinkedHashMap<String, BlockInfo> blocks = null;
        try {
            blocks = blockCombinationService.calculateAllCombinations("src/main/resources/BlockMaster.xlsx");
        } catch (IOException ex){}
        model.addAttribute("blocks", blocks);
        return "blocks";
    }
}

