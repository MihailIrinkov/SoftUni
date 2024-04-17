package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.DeviceType;

import java.util.List;
import java.util.Optional;


//TODO
@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    Optional<Device> findAllByBrand(String brand);

    Optional<Device> findAllByModelAndBrand(String model, String brand);

//    List<Device> findAllByDeviceTypeAndPriceLessThanAndStorageGreaterThanEqualIgnoreCaseOrderByBrandAsc(
//            DeviceType type, Double price, Integer storage
//    );

    List<Device> findAllByDeviceTypeAndPriceLessThanOrderByBrandAsc(
            DeviceType type, Double price
    );
}
