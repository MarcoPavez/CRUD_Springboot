package crud_springboot.crud_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import crud_springboot.crud_springboot.model.License;
import crud_springboot.crud_springboot.service.LicenseService;


@RestController
@CrossOrigin("*")
public class LicenseController {
    
    private LicenseService licenseService;

    public LicenseController(@Autowired LicenseService licenseService){
        this.licenseService = licenseService;
    }

    @PostMapping("/License/save")
    public void guardarLicencia(@RequestBody License license){
        licenseService.saveLicense(license);
    }

    @PutMapping("/License/update")
    public void actualizarLicencia(@RequestBody License license){
        licenseService.updateLicense(license);
    }

    @GetMapping("/License/findAll")
    public List<License> todasLasLicencias(){
        return licenseService.findAllLicense();
    }

    @GetMapping("/License/buscarClase/{clase}")
    public List<License> buscarClase(@PathVariable String clase){
        return licenseService.buscarPorClase(clase);
    }

    @GetMapping("/License/buscarEstado")
    public List<License> buscarEstado(@RequestBody String estado){
        return licenseService.buscarPorEstado(estado);
    }

    @GetMapping("/License/buscarClaseEstado")
    public List<License> buscarClaseEstado(@RequestBody String clase, String estado){
        return licenseService.buscarPorClaseEstado(clase, estado);
    }
    
    @DeleteMapping("/License/eliminarAuto/{id}")
    public void eliminarLicencia(@PathVariable Integer id){
        licenseService.eliminarLicencia(id);
    }
    
}
