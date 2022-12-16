package crud_springboot.crud_springboot.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import crud_springboot.crud_springboot.model.BuySell;
import crud_springboot.crud_springboot.repository.BuySellRepository;

@Service
@Transactional
public class BuySellService {
    
    private BuySellRepository buySellRepository;

    public BuySellService(BuySellRepository buySellRepository){
        this.buySellRepository = buySellRepository;
    }

    public void saveBuySell(BuySell buySell){
        buySellRepository.save(buySell);
    }

    public void updateBuySell(BuySell buySell){
        buySellRepository.save(buySell);
    }

    public List<BuySell> findAllBuySell(){
        return buySellRepository.findAll();
    }

    public List<BuySell> buscarCompraUltimoAnio(Date fechaCompra){
        return buySellRepository.findCompradosUltimoAnio(fechaCompra);
    }

    public void eliminarBuySell(Integer id){
        buySellRepository.deleteById(id);
    }
}
