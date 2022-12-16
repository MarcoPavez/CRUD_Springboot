package crud_springboot.crud_springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import crud_springboot.crud_springboot.model.License;
import crud_springboot.crud_springboot.repository.LicenseRepository;

@Service
@Transactional
public class LicenseService {
    
    private LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository){
        this.licenseRepository = licenseRepository;
    }

    public void saveLicense(License license){
        licenseRepository.save(license);
    }

    public void updateLicense(License license){
        licenseRepository.save(license);
    }

    public List<License> findAllLicense(){
        return licenseRepository.findAll();
    }

    public List<License> buscarPorClase(String clase){
        return licenseRepository.findAllClase(clase);
    }

    public List<License> buscarPorEstado(String estado){
        return licenseRepository.findAllEstado(estado);
    }

    public List<License> buscarPorClaseEstado(String clase, String estado){
        return licenseRepository.findAllClaseEstado(clase, estado);
    }

    public void eliminarLicencia(Integer id){
        licenseRepository.deleteById(id);
    }
}
