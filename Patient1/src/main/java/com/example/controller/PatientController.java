package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BookingDTO;
import com.example.dto.DepartmentDTO;
import com.example.dto.HospitalDTO;
import com.example.entity.Patient;
import com.example.exception.PatientNotFound;
import com.example.feign.BookingClient;
import com.example.feign.DepartmentClient;
import com.example.feign.HospitalClient;
import com.example.service.PatientService;

import jakarta.validation.Valid;

/**
 * PatientController is a REST controller that handles HTTP requests related to patients.
 * It provides endpoints to register a new patient, retrieve patient details by ID, and register a patient to a hospital.
 */
@RestController
@RequestMapping("/patients")
public class PatientController {
    
    @Autowired
    PatientService patientService;
    
    @Autowired
    HospitalClient hospitalClient;
    
    @Autowired
    BookingClient bookingClient;
    
    @Autowired
    DepartmentClient departmentClient;
    
    /**
     * Registers a new patient.
     * 
     * @param patient the patient details to be registered
     * @return ResponseEntity containing the registered patient and HTTP status OK
     */
    @PostMapping("/register")
    public ResponseEntity<Patient> register(@Valid @RequestBody Patient patient){
        return new ResponseEntity<>(patientService.register(patient), HttpStatus.CREATED);
    }
    
    /**
     * Retrieves a patient by their ID.
     * 
     * @param id the ID of the patient to be retrieved
     * @return ResponseEntity containing the patient details and HTTP status OK
     */
    @GetMapping("/getById/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long id) throws PatientNotFound{
        return ResponseEntity.ok(patientService.getPatientById(id));
    }
    
    /**
     * Registers a patient to a hospital.
     * 
     * @param pId the ID of the patient to be registered
     * @param hId the ID of the hospital where the patient is to be registered
     * @return ResponseEntity containing the booking details and HTTP status OK
     */
    @PostMapping("/{pId}/register/{hId}/toDepartment/{dId}")
    public ResponseEntity<BookingDTO> registerPatientToHospital(@PathVariable("pId") long pId, @PathVariable("hId") long hId,  @PathVariable("dId") long dId){
    	
    	try {
            Patient patient = patientService.getPatientById(pId);
            if (patient == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            HospitalDTO hospital = hospitalClient.getHospitalById(hId).getBody();
            if (hospital == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            DepartmentDTO department = departmentClient.getById(dId).getBody();
            if (department == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            BookingDTO booking = new BookingDTO();
            booking.setPatientName(patient.getName());
            booking.setPatientGender(patient.getGender());
            booking.setPatientAge(patient.getAge());
            booking.setPatientId(patient.getId());
            booking.setHospitalId(hospital.getId());
            booking.setHospitalName(hospital.getName());
            booking.setHospitalAddress(hospital.getAddress());
            booking.setDepartmentId(department.getId());
            booking.setDepartmentName(department.getName());
            booking.setStatus("BOOKING CONFIRMED");

            bookingClient.register(booking);
            return ResponseEntity.ok(booking);

        } 
    	catch (PatientNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    	
//    	Patient patient = patientService.getPatientById(pId);
//        if (patient == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        HospitalDTO hospital = hospitalClient.getHospitalById(hId).getBody();
//        if (hospital == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        DepartmentDTO department = departmentClient.getById(dId).getBody();
//        if (department == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        BookingDTO booking = new BookingDTO();
//        booking.setPatientName(patient.getName());
//        booking.setPatientGender(patient.getGender());
//        booking.setPatientAge(patient.getAge());
//        booking.setPatientId(patient.getId());
//        booking.setHopspitalId(hospital.getId());
//        booking.setHopspitalName(hospital.getName());
//        booking.setHopspitalAddress(hospital.getAddress());
//        booking.setDepartmentId(department.getId());
//        booking.setDepartmentName(department.getName());
//        booking.setStatus("BOOKING CONFIRMED");
//        bookingClient.register(booking);
//        return ResponseEntity.ok(booking);
    	
    
    @GetMapping("/hospitals/getAll")
    public ResponseEntity<List<HospitalDTO>> getAllHospitals(){
    	List<HospitalDTO> list = hospitalClient.getAllHospitals().getBody();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/departments/getAll")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
    	List<DepartmentDTO> list = departmentClient.getAll().getBody();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<Patient>> getAllPatients(){
    	List<Patient> list = patientService.getAll();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }
}