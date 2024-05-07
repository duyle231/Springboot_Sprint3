package vn.unigap.api.service;

import vn.unigap.api.dto.in.EmployerUpdateRequest;
import vn.unigap.api.entity.Employer;
import vn.unigap.api.repository.EmployerRepository;
import vn.unigap.api.dto.in.EmployerCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {
    @Autowired
    private EmployerRepository employerRepository;

    public Employer createEmployer(EmployerCreationRequest request) {
        Employer employer = new Employer();
        if (employerRepository.existsByEmail(request.getEmail()))
            throw new RuntimeException("Email existed");

        employer.setEmail(request.getEmail());
        employer.setName(request.getName());
        employer.setProvince(request.getProvince());
        employer.setDescription(request.getDescription());
        employer.setCreated_at(request.getCreated_at());
        employer.setUpdated_at(request.getUpdated_at());

        return employerRepository.save(employer);
    }
    public Employer updateEmployer(String employerId, EmployerUpdateRequest request) {
        Employer employer = getEmployer(employerId);

        employer.setEmail(request.getEmail());
        employer.setName(request.getName());
        employer.setProvince(request.getProvince());
        employer.setDescription(request.getDescription());
        employer.setCreated_at(request.getCreated_at());
        employer.setUpdated_at(request.getUpdated_at());

        return employerRepository.save(employer);
    }
    public void deleteEmployer(String employerId){
        employerRepository.deleteById(employerId);
    }
    public List<Employer> getEmployers() {
        return employerRepository.findAll();
    }

    public Employer getEmployer(String id) {
        return employerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employer not found"));
    }
}