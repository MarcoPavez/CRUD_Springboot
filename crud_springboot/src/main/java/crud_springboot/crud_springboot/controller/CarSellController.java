package crud_springboot.crud_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import crud_springboot.crud_springboot.model.CarSell;
import crud_springboot.crud_springboot.service.CarSellService;

@RestController
@CrossOrigin("*")
public class CarSellController {
    
    private CarSellService carSellService;

    public CarSellController(@Autowired CarSellService carSellService){
        this.carSellService = carSellService;
    }

    @PostMapping("/CarSell/save")
    public void guardarCarSell(@RequestBody CarSell carSell){
        carSellService.saveCarSell(carSell);
    }

    @PutMapping("/CarSell/update")
    public void actualizarCarSell(@RequestBody CarSell carSell){
        carSellService.updateCarSell(carSell);
    }

    @GetMapping("/CarSell/findAll")
    public List<CarSell> todoCarSell(){
        return carSellService.findAllCarSell();
    }

    @GetMapping("/CarSell/{cantidad}")
    public List<CarSell> buscarMasMasVendidos(Integer cantidad){
        return carSellService.buscarMasVendidos(cantidad);
    }

    @GetMapping("/CarSell")
    public List<CarSell> MontoMasVendidos(int cantidad, int monto){
        return carSellService.buscarMontoMasVendidos(cantidad, monto);
    }

    @DeleteMapping("/CarSell/eliminarCarSell/{id}")
    public void eliminarLicencia(@PathVariable Integer id){
        carSellService.eliminarCarSell(id);
    }
}
