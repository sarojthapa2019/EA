package edu.mum.service.impl;

import edu.mum.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.VehicleDao;
import edu.mum.domain.Vehicle;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    public void update(Vehicle member) {
        vehicleDao.update(member);
    }

    public void insert(Vehicle member) {
        vehicleDao.insert(member);
    }


    public Vehicle findByVehicleNo(String memberId) {
        return vehicleDao.findByVehicleNo(memberId);
    }

    @Override
    public void delete(Vehicle vehicle) {
        vehicleDao.delete(vehicle);
    }


}
