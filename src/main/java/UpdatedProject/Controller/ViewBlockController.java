package UpdatedProject.Controller;
import UpdatedProject.Parsers.BlockInfo;
import UpdatedProject.Services.BlockCombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * This controller handles the back-end logic for when user is viewing 
 * and editing a specific block
 * 
 * @author mohammad and waleed
 */
@Controller
@RequestMapping("/viewBlock")
public class ViewBlockController {
    
    public ViewBlockController() {
        
    }
    
    @GetMapping("/{pathVariable}")
    public String showBlockView() {
        return "blockview";
    }
}
