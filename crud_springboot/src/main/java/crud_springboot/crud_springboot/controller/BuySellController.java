package crud_springboot.crud_springboot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import crud_springboot.crud_springboot.model.BuySell;
import crud_springboot.crud_springboot.service.BuySellService;

@RestController
@CrossOrigin("*")
public class BuySellController {
    
    private BuySellService buySellService; 

    public BuySellController(@Autowired BuySellService buySellService){
        this.buySellService = buySellService;
    }

    @PostMapping("/BuySell/save")
    public void guardarCompraVenta(@RequestBody BuySell buySell){
        buySellService.saveBuySell(buySell);
    }

    @PutMapping("/BuySell/update")
    public void actualizarCompraVenta(@RequestBody BuySell buySell){
        buySellService.updateBuySell(buySell);
    }

    @GetMapping("/BuySell/findAll")
    public List<BuySell> todaCompraVenta(){
        return buySellService.findAllBuySell();
    }

    @GetMapping("/BuySell/ultimoAnio")
    public List<BuySell> compraUltimoAnio(Date fechaCompra){
        return buySellService.buscarCompraUltimoAnio(fechaCompra);
    }

    @DeleteMapping("/BuySell/eliminarBuySell/{id}")
    public void eliminarAuto(@PathVariable Integer id){
        buySellService.eliminarBuySell(id);
    }
}
