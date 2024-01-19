package demo.rest;

import demo.html.model.Stock;
import demo.response.stockDataResponse;
import demo.service.impl.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "v")
public class IndexController {
    @Autowired
    StockServiceImpl sService;

    stockDataResponse sdResponce;

    @GetMapping(path = "/index")
    public String index(){
        System.out.print("GEORGY CONTROLLER INDEX "  );
        return "searchstock";
    }

    @PostMapping(path = "/register")
    public String stockRegistration(@RequestParam("stock") String stockId, Model model)
    {
        Stock stock = new Stock();
        System.out.print("input stock: "  + stockId  );
        try {
            sdResponce = new stockDataResponse();
            sdResponce = sService.getPrice(stockId);
            model.addAttribute("sdResponce", sdResponce);
            System.out.print("stock responce: "  + sdResponce.toString()  );
        }
        catch (Exception e){

        }
      return "searchresult";
    }
}
