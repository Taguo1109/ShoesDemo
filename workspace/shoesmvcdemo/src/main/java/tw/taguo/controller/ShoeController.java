package tw.taguo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import tw.taguo.model.Shoe;
import tw.taguo.service.ShoeService;

@Controller
@RequestMapping("/shoes")
public class ShoeController {

    @Autowired
    private ShoeService shoeService;

    @GetMapping("{id}")
    public Shoe getShoeById(@PathVariable Long id) {
        return shoeService.getShoeById(id);
    }

//    @GetMapping("/list")
//    public List<Shoe> getAllShoes() {
//        return shoeService.getAllShoes();
//    }
    
    @GetMapping("/list")
    public String listAllShoes(Model model) {
        List<Shoe> shoes = shoeService.getAllShoes();
        model.addAttribute("shoes", shoes);
        return "listShoes"; // 這裡是 JSP 名稱
    }

//    @PostMapping(value = "/create", consumes = "application/json", produces = "text/plain")
//    public String createShoe(@RequestBody Shoe shoe) {
//        shoeService.saveShoe(shoe);
//        return "OK";
//    }
    
    @GetMapping("/add")
    public String showAddShoeForm() {
        return "addShoe";
    }

    @PostMapping("/create")
    public String createShoe(@ModelAttribute Shoe shoe) {
        shoeService.saveShoe(shoe);
        return "redirect:/shoes/list";
    }

    @GetMapping("/edit/{id}")
    public Shoe showEditForm(@PathVariable Long id) {
        return shoeService.getShoeById(id);
    }

    @PostMapping("/update")
    public Shoe updateShoe(@RequestBody Shoe updateShoe) {
        shoeService.updateShoe(updateShoe);
        return updateShoe;
    }

    @GetMapping
    public List<Shoe> searchShoesByName(@RequestParam String name) {
        return shoeService.searchShoesByName(name);
    }
    @GetMapping("/search")
    public String searchShoesByNamePage(@RequestParam(required = false) String brand, Model model) {
        System.out.println("快出來啦");
    	List<Shoe> shoes = shoeService.searchShoesByName(brand);
        model.addAttribute("shoes", shoes);
        return "search";
    }

}
