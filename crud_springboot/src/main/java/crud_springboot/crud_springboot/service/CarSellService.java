package crud_springboot.crud_springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import crud_springboot.crud_springboot.model.CarSell;
import crud_springboot.crud_springboot.repository.CarSellRepository;

@Service
@Transactional
public class CarSellService {
    
    private CarSellRepository carSellRepository;

    public CarSellService(CarSellRepository carSellRepository){
        this.carSellRepository = carSellRepository;
    }

    public void saveCarSell(CarSell carSell){
        carSellRepository.save(carSell);
    }

    public void updateCarSell(CarSell carSell){
        carSellRepository.save(carSell);
    }

    public List<CarSell> findAllCarSell(){
        return carSellRepository.findAll();
    }

    public List<CarSell> buscarMasVendidos(Integer cantidad){
        return carSellRepository.findMasVendidos(cantidad);
    }

    public List<CarSell> buscarMontoMasVendidos(Integer cantidad, int monto){
        return carSellRepository.findMontoMasVendidos(cantidad,monto);
    }

    public void eliminarCarSell(Integer id){
        carSellRepository.deleteById(id);
    }
}
