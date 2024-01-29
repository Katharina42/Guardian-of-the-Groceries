package io.everyonecodes.projectmodule;

import io.everyonecodes.projectmodule.Item.ItemController;
import io.everyonecodes.projectmodule.Item.ItemService;
import io.everyonecodes.projectmodule.StorageLocation.StorageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    private final ItemService itemService;
    private final StorageService storageService;
    private final ItemController itemController;

    public WebController(ItemService itemService, StorageService storageService, ItemController itemController) {
        this.itemService = itemService;
        this.storageService = storageService;
        this.itemController = itemController;
    }

    @GetMapping("/")
    ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("locations", storageService.findAllSortedByLocationName());
        return mav;
    }

    @GetMapping("/storage_location/ordered/{id}")
    ModelAndView listOfItems(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("insideStorageLocation");
        var items = itemController.showAllItemsOrdered(id);
        mav.addObject("items", items);
        return mav;
    }
}
